
(ns jane.comp.sidebar
  (:require [respo.alias :refer [create-comp div]]
            [respo-ui.style :as ui]
            [respo.comp.text :refer [comp-text]]
            [respo.comp.space :refer [comp-space]]
            [respo.comp.debug :refer [comp-debug]]
            [hsl.core :refer [hsl]]
            [jane.style.widget :as widget]))

(defn on-create [e dispatch!] (dispatch! :router/add-topic nil))

(defn render-header []
  (div
    {:style (merge ui/row ui/card {:justify-content "space-between"})}
    (comp-text "topics" nil)
    (div
      {:style (merge widget/button-small), :event {:click on-create}}
      (comp-text "new" nil))))

(def style-container {:min-width 320, :width "40%"})

(defn render []
  (fn [state mutate!]
    (div {:style style-container} (render-header) (div {}))))

(def comp-sidebar (create-comp :sidebar render))
