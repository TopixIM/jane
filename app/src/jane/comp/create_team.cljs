
(ns jane.comp.create-team
  (:require [respo.alias :refer [create-comp div input]]
            [respo-ui.style :as ui]
            [respo.comp.text :refer [comp-text]]
            [respo.comp.space :refer [comp-space]]
            [respo.comp.debug :refer [comp-debug]]
            [hsl.core :refer [hsl]]))

(defn on-input [mutate!] (fn [e dispatch!] (mutate! (:value e))))

(defn update-state [state new-text] new-text)

(defn init-state [& args] "")

(defn on-create [text] (fn [e dispatch!] (dispatch! :team/create text)))

(defn render []
  (fn [state mutate!]
    (div
      {:style {}}
      (comp-text "create one?" nil)
      (comp-space "8px" nil)
      (input
        {:style ui/input,
         :event {:input (on-input mutate!)},
         :attrs {:placeholder "team name", :value state}})
      (comp-space "8px" nil)
      (div
        {:style (merge ui/button), :event {:click (on-create state)}}
        (comp-text "create" nil)))))

(def comp-create-team
 (create-comp :create-team init-state update-state render))
