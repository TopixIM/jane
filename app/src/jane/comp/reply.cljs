
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

(defn on-keydown [state mutate! topic]
  (fn [e dispatch!]
    (let [event (:original-event e)]
      (if (and (= (:key-code e) 13) (not (.-shift event)))
        (do
          (mutate! "")
          (.preventDefault event)
          (let [team-id (:team-id topic) topic-id (:id topic)]
            (dispatch! :message/create [team-id topic-id state])))))))

(defn render [topic]
  (fn [state mutate!]
    (textarea
      {:style
       (merge
         ui/input
         {:background-color (hsl 0 0 100),
          :width "100%",
          :padding "16px",
          :height "100%"}),
       :event
       {:keydown (on-keydown state mutate! topic),
        :input (on-input mutate!)},
       :attrs {:placeholder "reply...", :value state}})))

(def comp-reply (create-comp :reply init-state update-state render))
