
(ns jane.comp.chatroom
  (:require [respo.alias :refer [create-comp div]]
            [respo-ui.style :as ui]
            [respo.comp.text :refer [comp-text]]
            [respo.comp.space :refer [comp-space]]
            [respo.comp.debug :refer [comp-debug]]
            [hsl.core :refer [hsl]]))

(def style-header {:background-color (hsl 0 0 70), :height 40})

(def style-container {:background-color (hsl 0 0 94)})

(def style-control {:background-color (hsl 0 80 80), :height 200})

(defn render [router]
  (fn [state mutate!]
    (div
      {:style (merge ui/flex ui/column style-container)}
      (div
        {:style style-header}
        (comp-text (get-in router [:data :name]) nil))
      (div {:style ui/flex})
      (div {:style style-control}))))

(def comp-chatroom (create-comp :chatroom render))
