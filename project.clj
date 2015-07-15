(defproject reporting "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.6"]
                 [hiccup "1.0.5"]
                 [ring-server "0.3.1"]
                 [postgresql/postgresql "9.1-901.jdbc4"]
                 [org.clojure/java.jdbc "0.3.7"]
                 [clj-pdf "2.0.9"]
                 [environ "1.0.0"]
                 [migratus "0.8.1"]
                 [heroku-database-url-to-jdbc "0.2.2"]]
  :plugins [[lein-ring "0.8.12"]]
  :ring {:handler reporting.handler/app
         :init reporting.handler/init
         :destroy reporting.handler/destroy}
  :profiles
  {:uberjar {:aot :all}
   :production
   {:ring
    {:open-browser? false, :stacktraces? false, :auto-reload? false}}
   :dev
   {:dependencies [[ring-mock "0.1.5"] [ring/ring-devel "1.3.1"]]}})
