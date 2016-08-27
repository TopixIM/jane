
(ns jane.view
  (:require [jane.schema :as schema]))

(defn render-view [state-id db]
  (let [state (get-in db [:states state-id]) user-id (:user-id state)]
    {:state state,
     :user (if (some? user-id) (get-in db [:users user-id]) nil)}))

(defn render-scene [db] db)
