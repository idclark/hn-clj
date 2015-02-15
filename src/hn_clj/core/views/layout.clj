(ns hn-clj.core.views.layout
  (require [hiccup
            [page :refer [html5]]
            [page :refer [include-js include-css]]]
           [hn-clj.core.views.utilities :as util]))

(defn main-banner
  []
  [:header {:class "main-banner"}
   [:h1 "Hacker News Clone"]
   (util/link "new" "/newest") " | "
    (util/link "threads" "https://news.ycombinator.com/threads") " | "
    (util/link "comments" "https://news.ycombinator.com/comments") " | "
    (util/link "show" "https://news.ycombinator.com/show") " | "
    (util/link "ask" "https://news.ycombinator.com/ask") " | "
    (util/link "jobs" "https://news.ycombinator.com/jobs") " | "
   (util/link "submit" "https://news.ycombinator.com/submit") " | "
   ])

(defn ribbon
  []
  [:a {:href "https://github.com/idclark"}
   [:img {:style "position: absolute; top: 0; right: 0; border: 0;"
          :src "https://camo.githubusercontent.com/365986a132ccd6a44c23a9169022c0b5c890c387/68747470733a2f2f73332e616d617a6f6e6177732e636f6d2f6769746875622f726962626f6e732f666f726b6d655f72696768745f7265645f6161303030302e706e67"
          :alt "Fork me on GitHub"}]])

(defn main-layout
  [{:keys [title]} & content]
  (html5
   [:head
    [:title title]
    (include-js "/js/tm.js")
    (include-css "/css/main.css")]
   [:body
    (main-banner)
    (ribbon)
    [:div {:class "content"} content]]))
