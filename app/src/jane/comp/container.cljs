
(ns jane.comp.container
  (:require [hsl.core :refer [hsl]]
            [respo.alias :refer [create-comp div span]]
            [jane.style.widget :as widget]
            [jane.style.layout :as layout]
            [respo.comp.debug :refer [comp-debug]]
            [respo-ui.style :as ui]
            [jane.comp.login :refer [comp-login]]
            [jane.comp.chatroom :refer [comp-chatroom]]
            [jane.comp.overview :refer [comp-overview]]))

(defn render [store]
  (fn [state mutate!]
    (div
      {}
      (if (some? (:user store))
        (let [router (-> store :state :router)]
          (case
            (:name router)
            :chatroom
            (comp-chatroom store)
            :home
            (comp-overview store)
            (comp-debug router nil)))
        (comp-login)))))

(def comp-container (create-comp :container render))
