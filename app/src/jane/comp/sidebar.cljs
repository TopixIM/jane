
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
    (comp-text
      "Topics"
      {:color (hsl 0 0 80),
       :font-size 24,
       :font-weight "lighter",
       :font-family "Helvetica Neue"})
    (div
      {:style (merge widget/button-small), :event {:click on-create}}
      (comp-text "+" nil))))

(def style-container {:min-width 320, :width "40%"})

(def style-topic
 {:border-style "solid",
  :line-height 2.4,
  :color (hsl 0 0 20),
  :border-left-width 0,
  :cursor "pointer",
  :border-right-width 0,
  :border-bottom-width "1px",
  :border-top-width 0,
  :padding "0 16px",
  :border-color (hsl 0 0 90)})

(defn render [router topics]
  (fn [state mutate!]
    (let [focused-topic (:params router)]
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
                     {:style
                      (merge
                        style-topic
                        (if (= topic-id focused-topic)
                          {:background-color (hsl 180 80 96)})),
                      :event {:click (on-topic topic-id)}}
                     (comp-text (:name topic) nil))])))))
        (comment comp-debug router nil)))))

(def comp-sidebar (create-comp :sidebar render))
