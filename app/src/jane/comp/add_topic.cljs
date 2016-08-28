
(ns jane.comp.add-topic
  (:require [respo.alias :refer [create-comp div input]]
            [respo-ui.style :as ui]
            [respo.comp.text :refer [comp-text]]
            [respo.comp.space :refer [comp-space]]
            [respo.comp.debug :refer [comp-debug]]
            [hsl.core :refer [hsl]]
            [jane.style.widget :as widget]
            [clojure.string :as string]))

(defn on-input [mutate!] (fn [e dispatch!] (mutate! (:value e))))

(defn update-state [state text] text)

(defn init-state [& args] "")

(defn on-create [content mutate!]
  (fn [e dispatch!]
    (if (not (string/blank? content))
      (do (println "create topic..." content) (mutate! "")))))

(defn render [store]
  (fn [state mutate!]
    (div
      {:style ui/card}
      (div {} (comp-text "Add a topic" nil))
      (comp-space nil "16px")
      (div
        {}
        (input
          {:style (merge ui/input {:line-height "40px", :width 360}),
           :event {:input (on-input mutate!)},
           :attrs {:placeholder "topic name", :value state}})
        (comp-space "8px" nil)
        (div
          {:style ui/button, :event {:click (on-create state mutate!)}}
          (comp-text "add" nil))))))

(def comp-add-topic
 (create-comp :add-topic init-state update-state render))
