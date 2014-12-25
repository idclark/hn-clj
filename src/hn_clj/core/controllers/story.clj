(ns hn-clj.controllers.story
  (require [hn-clj.views.index :as index-view]
           [hn-clj.views.show :as show-view]
           [hn-clj.api :as api]))

(defn index
  [limit]
  (if (nil? limit)
    (index-view/page (api/get-front-page))
    (index-view/page (api/get-front-page limit))))

(defn show-story
  [id]
  (show-view/page (api/get-nested-items id)))
