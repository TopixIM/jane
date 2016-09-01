
(ns jane.comp.chatroom
  (:require [respo.alias :refer [create-comp div textarea]]
            [respo-ui.style :as ui]
            [respo.comp.text :refer [comp-text]]
            [respo.comp.space :refer [comp-space]]
            [respo.comp.debug :refer [comp-debug]]
            [hsl.core :refer [hsl]]
            [jane.comp.reply :refer [comp-reply]]
            [jane.comp.message :refer [comp-message]]
            [jane.style.widget :as widget]))

(def style-header
 {:align-items "center",
  :color (hsl 0 0 60),
  :font-size 24,
  :font-weight "lighter",
  :background-color (hsl 0 0 100),
  :padding "0 16px",
  :font-family "Helvetica Neue",
  :height 60})

(def style-container {:background-color (hsl 0 0 100)})

(def style-control {:background-color (hsl 0 80 80), :height 80})

(defn render [router]
  (fn [state mutate!]
    (let [topic (get router :data)]
      (div
        {:style (merge ui/flex ui/column style-container)}
        (div
          {:style (merge ui/row style-header)}
          (comp-text (:name topic) nil))
        (div
          {:style ui/flex}
          (->>
            (:messages topic)
            (map
              (fn [entry]
                (let [[message-id message] entry]
                  [message-id (comp-message message)])))))
        (div {:style widget/column-divider})
        (div {:style style-control} (comp-reply topic))
        (comment comp-debug topic nil)))))

(def comp-chatroom (create-comp :chatroom render))
