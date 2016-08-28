
(ns jane.comp.team
  (:require [respo.alias :refer [create-comp div]]
            [respo-ui.style :as ui]
            [respo.comp.text :refer [comp-text]]
            [respo.comp.space :refer [comp-space]]
            [respo.comp.debug :refer [comp-debug]]
            [hsl.core :refer [hsl]]
            [jane.comp.sidebar :refer [comp-sidebar]]))

(defn render [store]
  (fn [state mutate!] (div {} (comp-sidebar) (div {}))))

(def comp-team (create-comp :team render))
