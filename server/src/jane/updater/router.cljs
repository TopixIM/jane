
(ns jane.updater.router)

(defn add-topic [db op-data state-id op-id op-time]
  (update-in
    db
    [:states state-id :router]
    (fn [router]
      (assoc router :router {:name :add-topic, :params nil}))))

(defn team [db op-data state-id op-id op-time]
  (assoc-in
    db
    [:states state-id :router]
    {:name :team, :params op-data}))
