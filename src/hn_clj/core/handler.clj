(ns hn-clj.core.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [compojure.handler :as handler]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [hn-clj.core.controllers.story :as story]
            [hn-clj.core.controllers.users :as users]
            ))

(defroutes app-routes
  (GET "/" [limit] (story/index limit))
  (GET "/stories/:id" [id] (story/show-story id))
  (GET "/users/:username" [username] (users/show username)))

(def app
  (wrap-defaults app-routes site-defaults))
