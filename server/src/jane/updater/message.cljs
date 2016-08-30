
(ns jane.updater.message)

(defn create [db op-data state-id op-id op-time]
  (let [[team-id topic-id text] op-data
        state (get-in db [:states state-id])
        user-id (:user-id state)]
    (assoc-in
      db
      [:teams team-id :topics topic-id :messages op-id]
      {:team-id team-id,
       :id op-id,
       :topic-id topic-id,
       :author-id user-id,
       :text text})))
