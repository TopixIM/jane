
(ns jane.comp.chatroom
  (:require [respo.alias :refer [create-comp div textarea]]
            [respo-ui.style :as ui]
            [respo.comp.text :refer [comp-text]]
            [respo.comp.space :refer [comp-space]]
            [respo.comp.debug :refer [comp-debug]]
            [hsl.core :refer [hsl]]
            [jane.comp.reply :refer [comp-reply]]))

(def style-header {:background-color (hsl 0 0 70), :height 40})

(def style-container {:background-color (hsl 0 0 94)})

(def style-control {:background-color (hsl 0 80 80), :height 120})

(defn render [router]
  (fn [state mutate!]
    (let [topic (get router :data)]
      (div
        {:style (merge ui/flex ui/column style-container)}
        (div {:style style-header} (comp-text (:name topic) nil))
        (div {:style ui/flex})
        (div {:style style-control} (comp-reply))
        (comment comp-debug topic nil)))))

(def comp-chatroom (create-comp :chatroom render))
