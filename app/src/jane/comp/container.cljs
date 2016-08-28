
(ns jane.comp.container
  (:require [hsl.core :refer [hsl]]
            [respo.alias :refer [create-comp div span]]
            [jane.style.widget :as widget]
            [jane.style.layout :as layout]
            [respo.comp.debug :refer [comp-debug]]
            [respo-ui.style :as ui]
            [jane.comp.login :refer [comp-login]]
            [jane.comp.portal :refer [comp-portal]]
            [jane.comp.team :refer [comp-team  ]]))

(defn render [store]
  (fn [state mutate!]
    (div
      {}
      (if (some? (:user store))
        (let [router (-> store :state :router)]
          (case
            (:name router)
            :home
            (comp-portal store)
            :team
            (comp-team store)
            (comp-debug router nil)))
        (comp-login))
      (comment comp-debug store nil))))

(def comp-container (create-comp :container render))
