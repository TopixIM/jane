
(ns jane.comp.portal
  (:require [respo.alias :refer [create-comp div]]
            [respo-ui.style :as ui]
            [respo.comp.text :refer [comp-text]]
            [respo.comp.space :refer [comp-space]]
            [respo.comp.debug :refer [comp-debug]]
            [hsl.core :refer [hsl]]
            [jane.comp.create-team :refer [comp-create-team]]))

(defn on-click [team-id]
  (fn [e dispatch!] (dispatch! :router/team team-id)))

(def style-team
 {:background-color (hsl 0 0 100),
  :width 200,
  :cursor "pointer",
  :padding 8,
  :display "inline-block",
  :margin-right 8,
  :margin-bottom 8,
  :height 64})

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
          (div
            {}
            (div
              {}
              (->>
                teams
                (map
                  (fn [entry]
                    (let [team (val entry) team-id (:id team)]
                      [team-id
                       (div
                         {:style style-team,
                          :event {:click (on-click team-id)}}
                         (comp-text (:name team) nil))])))))
            (comp-create-team)))))))

(def comp-portal (create-comp :portal render))
