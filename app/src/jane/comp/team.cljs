
(ns jane.comp.team
  (:require [respo.alias :refer [create-comp div]]
            [respo-ui.style :as ui]
            [respo.comp.text :refer [comp-text]]
            [respo.comp.space :refer [comp-space]]
            [respo.comp.debug :refer [comp-debug]]
            [hsl.core :refer [hsl]]
            [jane.comp.sidebar :refer [comp-sidebar]]
            [jane.style.widget :as widget]
            [jane.comp.add-topic :refer [comp-add-topic]]
            [jane.comp.chatroom :refer [comp-chatroom]]))

(defn render [store]
  (fn [state mutate!]
    (let [router (:router store)
          team-id (:params router)
          sub-router (or (:router router) {})]
      (div
        {:style (merge ui/fullscreen ui/row)}
        (comp-sidebar
          sub-router
          (->> (get-in router [:data :team :topics]) (into {})))
        (div {:style widget/row-divider})
        (case
          (:name sub-router)
          :add-topic
          (comp-add-topic team-id)
          :topic
          (comp-chatroom sub-router)
          (comp-debug sub-router nil))
        (comment comp-debug sub-router nil)))))

(def comp-team (create-comp :team render))
