(ns hn-clj.core.views.utilities)

(defn link
  [txt href]
  [:a {:href href} txt])

(defn user-link
  [txt uname]
  (link txt (str "/users/" uname)))

(defn story-link
  [txt id]
  (link txt (str "/stories/" id)))

(defn days-delta
  [secs]
  (let [current (quot (System/currentTimeMillis) 1000)
        day-secs (* 24 (* 60 60))
        delta (- current secs)]
    (int (/ delta day-secs))))
