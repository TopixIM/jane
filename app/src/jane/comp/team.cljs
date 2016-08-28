
(ns jane.comp.team
  (:require [respo.alias :refer [create-comp div]]
            [respo-ui.style :as ui]
            [respo.comp.text :refer [comp-text]]
            [respo.comp.space :refer [comp-space]]
            [respo.comp.debug :refer [comp-debug]]
            [hsl.core :refer [hsl]]
            [jane.comp.sidebar :refer [comp-sidebar]]
            [jane.style.widget :as widget]
            [jane.comp.add-topic :refer [comp-add-topic]]))

(defn render [store]
  (fn [state mutate!]
    (let [router (-> store :state :router)]
      (div
        {:style (merge ui/fullscreen ui/row)}
        (comp-sidebar store)
        (div {:style widget/row-divider})
        (case
          (:name (:router router))
          :add-topic
          (comp-add-topic)
          (comp-debug (:router router) nil))))))

(def comp-team (create-comp :team render))
