
(ns jane.updater.core
  (:require [jane.updater.state :as state]
            [jane.updater.user :as user]))

(defn default-handler [db op-data state-id op-id op-time] db)

(defn updater [db op op-data state-id op-id op-time]
  (let [handler (case
                  op
                  :state/connect
                  state/connect
                  :state/disconnect
                  state/disconnect
                  :user/login
                  user/login
                  (do
                    (println "found no handler for" op)
                    default-handler))]
    (handler db op-data state-id op-id op-time)))
