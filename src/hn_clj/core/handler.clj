(ns hn-clj.core.handler
  (:gen-class)
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [compojure.handler :as handler]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.adapter.jetty :as jetty]
            [hn-clj.core.controllers.story :as story]
            [hn-clj.core.controllers.users :as users]
            ))

(defroutes app-routes
  (GET "/" [limit] (story/index limit))
  (GET "/stories/:id" [id] (story/show-story id))
  (GET "/users/:username" [username] (users/show username)))

(defn -main []
  (let [port (Integer/parseInt (get (System/getenv) "PORT" "3000"))]
    (jetty/run-jetty app-routes {:port port})))
