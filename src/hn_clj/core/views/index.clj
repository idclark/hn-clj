(ns hn-clj.views.stories.index
  (:require [hn-clj.views.layout :refer [main-layout]]
            [hn-clj.views.utilities :as util]))

(defn story-html
  [story]
  [:li {:class "story"}
   (util/link (story "title") (story "url"))
   [:p
    (story "score") " points by "
    (util/user-link (story "by") (story "by")) " | "
    (util/story-link
     (str (count (story "kids")) " comments") (story "id"))]])
(defn page
  [stories]
  (main-layout {:title "Hacker News Clone"}
               [:ol (map story-html stories)]))
