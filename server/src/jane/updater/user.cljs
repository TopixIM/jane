
(ns jane.updater.user)

(defn login [db op-data state-id op-id op-time]
  (let [[username password] op-data
        state (get-in db [:states state-id])
        target-user (->>
                      (:users db)
                      (filter
                        (fn [entry]
                          (let [user (val entry)]
                            (and (= (:name user) username)))))
                      (first))]
    (println "target-user" target-user)
    (if (some? target-user)
      ((assoc-in db [:states state-id :user-id] (:id target-user))
        (update-in
          db
          [:states state-id]
          (fn [state]
            (if (= password (:password target-user))
              (assoc state :user-id (:id target-user))
              (update
                state
                :notifications
                (fn [notifications]
                  (conj
                    notifications
                    {:id op-id, :text "wrong password!"})))))))
      (-> db
       (assoc-in
         [:users op-id]
         {:password password, :name username, :id op-id})
       (assoc-in [:states state-id :user-id] op-id)))))
