
(ns jane.updater.router)

(defn team [db op-data state-id op-id op-time]
  (assoc-in db [:states state-id :router] {:name :team, :data op-data}))
