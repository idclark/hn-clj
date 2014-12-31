(ns hn-clj.core.views.stories.show
  (:require [hn-clj.core.views.layout :refer [main-layout]]
            [hn-clj.core.views.utilities :as util]))

(defn story-header
  [story]
  [:header {:class "story-header"}
   (util/link [:h2 (story "title")] (story "url"))
   (util/user-link [:h3 "By " (story "by")] (story "by"))])

(defn comment-html
  [comment]
  [:div {:class "comment"}
   (util/user-link [:h4 (comment "by") (comment "by")])
   [:p (comment "text")]
   [:ul (map comment-html (comment "comments"))]])

(defn comment-section
  [comments]
  (map comment-html comments))

(defn page
  [story]
  (main-layout {:title (str "HNClone: " (story "title"))}
               (story-header story)
               (comment-section (story "comments"))))
