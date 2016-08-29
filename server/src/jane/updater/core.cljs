
(ns jane.updater.core
  (:require [jane.updater.state :as state]
            [jane.updater.user :as user]
            [jane.updater.team :as team]
            [jane.updater.router :as router]
            [jane.updater.topic :as topic]))

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
                  :team/create
                  team/create
                  :router/team
                  router/team
                  :router/add-topic
                  router/add-topic
                  :topic/create
                  topic/create
                  :router/topic
                  router/topic
                  (do
                    (println "found no handler for" op)
                    default-handler))]
    (handler db op-data state-id op-id op-time)))
