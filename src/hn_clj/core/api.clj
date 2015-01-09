(ns hn-clj.core.api
  (:require [clj-http.lite.client :as client]
            [cheshire.core :as json]))

(def base-url "https://hacker-news.firebaseio.com/v0")

(defn- get-json
  [url]
  (let [response (json/parse-string (:body (client/get (str url ".json"))))]
    (clojure.walk/keywordize-keys response)))

(defn get-front-page-ids
  []
  (get-json (str base-url "/topstories")))

(defn get-item
  [id]
  (get-json (str base-url "/item/" id)))

(defn get-nested-items
  [id]
  (let [item (get-item id)]
    (assoc item :comments (pmap get-nested-items (item :kids)))))

(defn get-user
  [uname]
  (let [user (get-json (str base-url "/user/" uname))]
    (assoc user :stories (pmap get-item (user :submitted)))))

(defn get-frontpage
  ([]
   (get-frontpage 30))
  ([limit]
   (pmap get-item (take limit (get-front-page-ids)))))
