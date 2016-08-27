
(ns jane.comp.chatroom
  (:require [respo.alias :refer [create-comp div]]
            [respo-ui.style :as ui]
            [respo.comp.text :refer [comp-text]]
            [respo.comp.space :refer [comp-space]]
            [respo.comp.debug :refer [comp-debug]]
            [hsl.core :refer [hsl]]
            [jane.comp.sidebar :refer [comp-sidebar]]))

(def style-container {:background-color (hsl 0 0 80)})

(defn render [store]
  (fn [state mutate!]
    (div
      {:style (merge ui/fullscreen ui/row style-container)}
      (comp-sidebar)
      (div {}))))

(def comp-chatroom (create-comp :chatroom render))
