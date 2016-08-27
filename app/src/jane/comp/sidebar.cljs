
(ns jane.comp.sidebar
  (:require [respo.alias :refer [create-comp div]]
            [respo-ui.style :as ui]
            [respo.comp.text :refer [comp-text]]
            [respo.comp.space :refer [comp-space]]
            [respo.comp.debug :refer [comp-debug]]
            [hsl.core :refer [hsl]]))

(defn render [] (fn [state mutate!] (div {} (comp-text "sidebar" nil))))

(def comp-sidebar (create-comp :sidebar render))
