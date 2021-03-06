
(ns jane.view
  (:require [jane.schema :as schema]))

(defn render-router [router state-id db]
  (case
    (:name router)
    :home
    (assoc router :data {:teams (:teams db)})
    :team
    (let [team-id (get router :params)]
      (-> router
       (assoc :data {:team (get-in db [:teams team-id])})
       (update
         :router
         (fn [router]
           (case
             (:name router)
             :topic
             (let [topic-id (get router :params)
                   topic (get-in db [:teams team-id :topics topic-id])
                   messages (->>
                              (:messages topic)
                              (map
                                (fn 
                                  [entry]
                                  (let 
                                    [[message-id message] entry]
                                    [message-id
                                     (assoc
                                       message
                                       :author
                                       (get-in
                                         db
                                         [:users
                                          (:author-id message)]))])))
                              (into {}))]
               (assoc router :data (assoc topic :messages messages)))
             router)))))
    router))

(defn render-view [state-id db]
  (let [state (get-in db [:states state-id])
        user-id (:user-id state)
        router (:router state)]
    {:router (render-router router state-id db),
     :state (dissoc state :router),
     :user (if (some? user-id) (get-in db [:users user-id]) nil)}))

(defn render-scene [db] db)
