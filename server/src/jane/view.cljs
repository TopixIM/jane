
(ns jane.view
  (:require [jane.schema :as schema]))

(defn render-router [router state-id db]
  (case
    (:name router)
    :home
    router
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
             (let [topic-id (get router :params)]
               (assoc router :data (get-in db [:topics topic-id])))
             router)))))
    router))

(defn render-view [state-id db]
  (let [state (get-in db [:states state-id])
        user-id (:user-id state)
        router (:router state)]
    {:router (render-router router state-id db),
     :state state,
     :teams (:teams db),
     :user (if (some? user-id) (get-in db [:users user-id]) nil)}))

(defn render-scene [db] db)
