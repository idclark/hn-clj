(ns hn-clj.core.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [compojure.handler :as handler]
            [hiccup.middleware :refer [wrap-base-url]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.adapter.jetty :as jetty]
            [hn-clj.core.controllers.story :as story]
            [hn-clj.core.controllers.users :as users]
            ))

(defroutes app-routes
  (GET "/" [limit] (story/index limit))
  (GET "/stories/:id" [id] (story/show-story id))
  (GET "/users/:username" [username] (users/show username)))

(defn app
  []
  (-> (handler/site app-routes)
      (wrap-base-url)))

(defn -main
  []
  (jetty/run-jetty (app) {:port 3000}))
