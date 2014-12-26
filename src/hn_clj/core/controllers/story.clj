(ns hn-clj.core.controllers.story
  (require [hn-clj.core.views.stories.index :as index-view]
           [hn-clj.core.views.stories.show :as show-view]
           [hn-clj.core.api :as api]))

(defn index
  [limit]
  (if (nil? limit)
    (index-view/page (api/get-frontpage))
    (index-view/page (api/get-frontpage limit))))

(defn show-story
  [id]
  (show-view/page (api/get-nested-items id)))
