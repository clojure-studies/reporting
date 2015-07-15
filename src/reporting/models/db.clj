(ns reporting.models.db
  (:require [clojure.java.jdbc :as sql]
            [environ.core :refer [env]]
            [heroku-database-url-to-jdbc.core :as h]))

(def database-url (h/jdbc-connection-string (env :database-url)))

(def migratus-cfg {:store :database
                   :migration-dir "migrations"
                   :db database-url})

(def db {:connection-uri database-url})

(defn seed-employees []
  (sql/insert! db :employees
    {:name "Albert Einstein" :occupation "Engineer" :place "Ulm" :country "Germany"}
    {:name "Alfred Hitchcock" :occupation "Movie Director" :place "London" :country "UK"}
    {:name "Wernher Von Braun" :occupation "Rocket Scientist" :place "Wyrzysk" :country "Poland"}
    {:name "Sigmund Freud" :occupation "Neurologist" :place "Pribor" :country "Czech Republic"}
    {:name "Mahatma Gandhi" :occupation "Lawyer" :place "Gujarat" :country "India"}
    {:name "Sachin Tendulkar" :occupation "Cricket Player" :place "Mumbai" :country "India"}
    {:name "Michael Schumacher" :occupation "F1 Racer" :place "Cologne" :country "Germany"}))

(defn read-employees []
  (sql/query db ["SELECT * FROM employees"]))
