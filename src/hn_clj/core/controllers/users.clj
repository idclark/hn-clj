(ns hn-clj.core.controllers.users
  (:require [hn-clj.core.views.users.show :as show-views]
           [hn-clj.core.api :as api]))

(defn show
  [uname]
  (show-views/page (api/get-user uname)))
