
(ns jane.view
  (:require [jane.schema :as schema]))

(defn render-view [state-id db]
  {:state (get-in db [:states state-id]), :statistics {}})

(defn render-scene [db] db)
