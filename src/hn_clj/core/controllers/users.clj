(ns hn-clj.core.controllers.users
  (:require [hn-clj.core.views.users.show :as show-views]
           [hn-clj.core.api :as api]))

(defn show-user
  [uname]
  (show-views/user-page (api/get-user uname)))

(defn show-subbs
  [uname]
  (show-views/subb-page (api/get-user uname)))

(defn show-comms
  [uname]
  (show-views/comments-page (api/get-user uname)))
