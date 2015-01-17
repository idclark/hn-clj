(ns hn-clj.core.views.users.show
  (:require [hn-clj.core.views.layout :refer [main-layout]]
            [hn-clj.core.views.utilities :as util]))

(defn user-header
  [user]
  [:header {:class "user-header"}
   [:p "User: " (user :id)]
   [:p "Karma: " (user :karma)]
   [:p (str "Created: " (util/days-delta (user :created)) " days ago")]
   [:p "avg: " (user :avg)]
   [:p "about: " (user :about)]
   [:p (util/user-submissions "Submissions" (user :id))]
   [:p (util/user-comments "Comments" (user :id))]])

(defn submitted-html
  [story]
  [:div {:class "submitted-story"}
   (util/story-link [:p (story :title)] (story :id))])

(defn submitted-section
  [stories]
  (map submitted-html stories))

(defn user-page
  [user]
  (main-layout {:title (str "HN: " (user :id))}
               (user-header user)))

(defn subb-page
  [user]
  (main-layout {:title "submitted"}
               [:h4 (user :id) " 's submissions"]
               (submitted-section (user :stories))))

(defn comment-html
  [story]
  [:div {:class "comment header"}
   (util/user-link (story :by) (story :by)) " "
   (util/days-delta (story :time)) " days ago | "
   (util/link "link" (story :url)) " | on "
   (util/story-link (story :title) (story :id))
   [:p (story :text)]])

(defn all-comments
  [stories]
  (map comment-html stories))

(defn comments-page
  [user]
  (main-layout {:title "comments"}
               [:h4 (str (user :id) " 's comments")]
               (all-comments (user :stories))))
