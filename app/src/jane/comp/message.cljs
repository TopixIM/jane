
(ns jane.comp.message
  (:require [respo.alias :refer [create-comp div]]
            [respo-ui.style :as ui]
            [respo.comp.text :refer [comp-text]]
            [respo.comp.space :refer [comp-space]]
            [respo.comp.debug :refer [comp-debug]]
            [hsl.core :refer [hsl]]
            [jane.style.widget :as widget]))

(def style-name
 {:white-space "nowrap",
  :overflow "hidden",
  :width 80,
  :padding "0 8px"})

(defn render [message]
  (fn [state mutate!]
    (let [author (:author message)]
      (div
        {:style ui/row}
        (div {:style style-name} (comp-text (:name author) nil))
        (comp-text (:text message) nil)
        (comment comp-debug message nil)))))

(def comp-message (create-comp :message render))
