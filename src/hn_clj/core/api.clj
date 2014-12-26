(ns hn-clj.core.api
  (:require [clj-http.lite.client :as client]
            [cheshire.core :as json]))

(def base-url "https://hacker-news.firebaseio.com/v0")

(defn- get-json
  [url]
  (json/parse-string (:body (client/get (str url ".json")))))

(defn get-front-page-ids
  []
  (get-json (str base-url "/topstories")))

(defn get-item
  [id]
  (get-json (str base-url "/item/" id)))

(defn get-nested-items
  [id]
  (let [item (get-item id)]
    (assoc item "comments" (map get-nested-items (item "kids")))))

(defn get-user
  [uname]
  (let [user (get-json (str base-url "/user/" uname))]
    (assoc user "stories" (map get-item (user "submitted")))))

(defn get-frontpage
  ([]
   (map get-item (take 30 (get-front-page-ids))))
  ([limit]
   (map get-item (take (Integer. limit) (get-front-page-ids)))))
