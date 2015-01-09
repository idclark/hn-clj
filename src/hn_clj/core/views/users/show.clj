(ns hn-clj.core.views.users.show
  (:require [hn-clj.core.views.layout :refer [main-layout]]
            [hn-clj.core.views.utilities :as util]))

(defn user-header
  [user]
  [:header {:class "user-header"}
   [:h2 (user :id)]
   [:p "Karma: " (user :karma)]])

(defn submitted-html
  [story]
  [:div {:class "submitted-story"}
   (util/story-link [:p (story :title)] (story :id))])

(defn submitted-section
  [stories]
  (map submitted-html stories))

(defn page [user]
  (main-layout {:title (str "HN: " (user :id))}
               (user-header user)
               (submitted-section (user :stories))))
