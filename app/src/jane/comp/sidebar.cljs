
(ns jane.comp.sidebar
  (:require [respo.alias :refer [create-comp div]]
            [respo-ui.style :as ui]
            [respo.comp.text :refer [comp-text]]
            [respo.comp.space :refer [comp-space]]
            [respo.comp.debug :refer [comp-debug]]
            [hsl.core :refer [hsl]]
            [jane.style.widget :as widget]))

(defn on-topic [topic-id]
  (fn [e dispatch!] (dispatch! :router/topic topic-id)))

(defn on-create [e dispatch!] (dispatch! :router/add-topic nil))

(defn render-header []
  (div
    {:style (merge ui/row ui/card {:justify-content "space-between"})}
    (comp-text "topics" nil)
    (div
      {:style (merge widget/button-small), :event {:click on-create}}
      (comp-text "new" nil))))

(def style-container {:min-width 320, :width "40%"})

(def style-topic
 {:line-height 2,
  :color (hsl 0 0 20),
  :cursor "pointer",
  :padding "0 8px"})

(defn render [topics]
  (fn [state mutate!]
    (div
      {:style style-container}
      (render-header)
      (div
        {}
        (->>
          topics
          (map
            (fn [entry]
              (let [[topic-id topic] entry]
                [topic-id
                 (div
                   {:style style-topic,
                    :event {:click (on-topic topic-id)}}
                   (comp-text (:name topic) nil))])))))
      (comment comp-debug topics nil))))

(def comp-sidebar (create-comp :sidebar render))
