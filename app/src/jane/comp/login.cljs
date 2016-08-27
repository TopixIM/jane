
(ns jane.comp.login
  (:require [respo.alias :refer [create-comp div input]]
            [hsl.core :refer [hsl]]
            [respo-ui.style :as ui]
            [respo.comp.text :refer [comp-text]]
            [respo.comp.space :refer [comp-space]]
            [respo.comp.debug :refer [comp-debug]]))

(defn update-state [state changes] (merge state changes))

(defn on-password-input [mutate!]
  (fn [e dispatch!] (mutate! {:password (:value e)})))

(def style-container {:background-color (hsl 160 40 86)})

(defn init-state [& args] {:password "", :name ""})

(defn on-name-input [mutate!]
  (fn [e dispatch!] (mutate! {:name (:value e)})))

(defn on-login [state]
  (fn [e dispatch!]
    (dispatch! :user/login [(:name state) (:password state)])))

(defn render []
  (fn [state mutate!]
    (div
      {:style (merge ui/fullscreen ui/card style-container)}
      (div
        {}
        (div {} (comp-text "You need to login first" nil))
        (comp-space nil "16px")
        (div
          {}
          (input
            {:style ui/input,
             :event {:input (on-name-input mutate!)},
             :attrs {:placeholder "username", :value (:name state)}}))
        (comp-space nil "16px")
        (div
          {}
          (input
            {:style ui/input,
             :event {:input (on-password-input mutate!)},
             :attrs
             {:placeholder "password", :value (:password state)}}))
        (comp-space nil "16px")
        (div
          {}
          (div
            {:style ui/button, :event {:click (on-login state)}}
            (comp-text "login" nil)))))))

(def comp-login (create-comp :login init-state update-state render))
