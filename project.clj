(defproject hn-clj "0.1.1"
  :description "A HackerNews Clone using the Firebase API"
  :url "http://github.com/idclark/hn-clj"
  :source-paths ["src"]
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.3.1"]
                 [ring/ring-jetty-adapter "1.3.2"]
                 [ring/ring-defaults "0.1.2"]
                 [clj-http-lite "0.2.0"]
                 [cheshire "5.4.0"]
                 [hiccup "1.0.5"]]
  :plugins [[lein-ring "0.8.13"]]
  :ring {:handler hn-clj.core.handler/app}
  :profiles {:uberjar {:aot :all}}
  :uberjar-name "hn-clj.jar"
  :main hn-clj.core.handler)
