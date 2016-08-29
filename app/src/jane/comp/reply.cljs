
(ns jane.comp.reply
  (:require [respo.alias :refer [create-comp div textarea]]
            [respo-ui.style :as ui]
            [respo.comp.text :refer [comp-text]]
            [respo.comp.space :refer [comp-space]]
            [respo.comp.debug :refer [comp-debug]]
            [hsl.core :refer [hsl]]
            [jane.style.widget :as widget]))

(defn on-input [mutate!] (fn [e dispatch!] (mutate! (:value e))))

(defn update-state [state text] text)

(defn init-state [& args] "")

(defn on-keydown [state mutate!]
  (fn [e dispatch!]
    (if (and (= (:key-code e) 13) (.-metaKey (:original-event e)))
      (do (mutate! "") (dispatch! :message/create state)))))

(defn render []
  (fn [state mutate!]
    (textarea
      {:style
       (merge
         ui/input
         {:background-color (hsl 0 0 100),
          :width "100%",
          :height "100%"}),
       :event
       {:keydown (on-keydown state mutate!),
        :input (on-input mutate!)},
       :attrs {:placeholder "reply...", :value state}})))

(def comp-reply (create-comp :reply init-state update-state render))
