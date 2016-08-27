
(ns jane.comp.overview
  (:require [respo.alias :refer [create-comp div]]
            [respo-ui.style :as ui]
            [respo.comp.text :refer [comp-text]]
            [respo.comp.space :refer [comp-space]]
            [respo.comp.debug :refer [comp-debug]]
            [hsl.core :refer [hsl]]
            [jane.comp.create-team :refer [comp-create-team]]))

(defn render [store]
  (fn [state mutate!]
    (div
      {:style
       (merge ui/fullscreen {:background-color (hsl 200 80 90)})}
      (let [teams (:teams store)]
        (if (empty? teams)
          (div
            {:style (merge ui/column ui/card)}
            (div {} (comp-text "There is no teams!" nil))
            (comp-space nil "16px")
            (comp-create-team))
          (div {}))))))

(def comp-overview (create-comp :overview render))
