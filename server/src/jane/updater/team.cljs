
(ns jane.updater.team)

(defn create [db op-data state-id op-id op-time]
  (assoc-in
    db
    [:teams op-id]
    {:name op-data, :time op-time, :id op-id}))
