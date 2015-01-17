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
   [:p (util/user-link "Submissions" (user :id))]
   [:p (util/user-link "Comments" (user :id))]])

(defn submitted-html
  [story]
  [:div {:class "submitted-story"}
   (util/story-link [:p (story :title)] (story :id))])

(defn submitted-section
  [stories]
  (map submitted-html stories))

(defn user-page [user]
  (main-layout {:title (str "HN: " (user :id))}
               (user-header user)))

(defn subb-page
  [user]
  (main-layout {:title "submitted"}
               [:h4 (user :id) " 's submissions"]
               (submitted-section (user :stories))))

(defn comments-html
  [story]
  (main-layout {:title "comments"}
               ;[:h4 (str (user :id ) " 's comments")]
               [:div {:class "comment-header"}
                (str (util/user-link (story :by) (story :by) " ")
                     (util/days-delta (story :time) " days ago |")
                     (util/link "link |" (story :url)) "on "
                     (util/story-link (story :title) (story :id)))]
               [:div {:class "comment-text"}
                [:p (story :text)]]))

(defn comments-page
  [comments]
  [:h4 (str (user :id ) " 's comments")]
  (map comments-html comments))
