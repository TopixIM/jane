
(ns jane.updater.topic)

(defn create [db op-data state-id op-id op-time]
  (let [[team-id team-name] op-data]
    (assoc-in
      db
      [:teams team-id :topics op-id]
      {:team-id team-id,
       :name team-name,
       :time op-time,
       :messages {},
       :id op-id,
       :member-ids {}})))
