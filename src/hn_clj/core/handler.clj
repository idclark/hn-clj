(ns hn-clj.core.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [hn-clj.core.controllers.story :as story]
            ))

(defroutes app-routes
  (GET "/" [limit] (story/index limit))
  (GET "stories/:id" [id] (story/show-story id)))

(def app
  (wrap-defaults app-routes site-defaults))
