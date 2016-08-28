
(ns jane.updater.topic)

(defn create [db op-data state-id op-id op-time]
  (assoc-in
    db
    [:topics op-id]
    {:name op-data, :time op-time, :id op-id, :members (hash-set)}))
