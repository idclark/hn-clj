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

(defn main-layout
  [{:keys [title]} & content]
  (html5
   [:head
    [:title title]
    (include-js "/js/main.js")
    (include-css "/css/main.css")]
   [:body
    (main-banner)
    [:div {:class "content"} content]]))
