
(ns jane.style.widget
  (:require [hsl.core :refer [hsl]]
            [jane.style.layout :as layout]
            [respo-ui.style :as ui]))

(def message {:padding "4px 0"})

(def dim8 {:background-color (hsl 0 0 80)})

(def notice-large
 {:color (hsl 0 0 70), :font-size "28px", :font-weight "lighter"})

(def resource
 {:line-height 2,
  :color (hsl 200 20 50),
  :font-size "14px",
  :padding "0 8px",
  :text-decoration "none"})

(def column-divider
 {:background-color (hsl 0 0 90), :width "auto", :height "1px"})

(def row-divider {:background-color (hsl 0 0 90), :width "1px"})

(def dim7 {:background-color (hsl 0 0 70)})

(def username
 {:line-height 2,
  :text-overflow "ellipsis",
  :color (hsl 0 0 60),
  :text-align "right",
  :font-size "12px",
  :overflow "hidden",
  :background-color (hsl 30 80 100),
  :width "100px",
  :padding "0 8px",
  :display "inline-block",
  :border-radius "4px"})

(defn logo-small [img]
  {:width "24px",
   :background-image (str "url(" img ")"),
   :background-repeat "no-repeat",
   :background-position "center",
   :background-size "contain",
   :height "24px"})

(def avatar
 {:width "80px",
  :flex-shrink 0,
  :background-image (str "url(tiye-400x400.jpg)"),
  :border-radius "50%",
  :background-size "cover",
  :height "80px"})

(def showcase
 (merge
   layout/row
   {:align-items "center",
    :width "180px",
    :padding "0 8px",
    :margin-right "8px",
    :border (str "1px solid " (hsl 0 0 90)),
    :border-radius "4px",
    :margin-bottom "8px",
    :height "40px"}))

(def textbox
 {:line-height 2,
  :font-size "16px",
  :padding "0 8px",
  :outline "none",
  :border "none"})

(def card {:padding "20px"})

(def button-small (merge ui/button {:line-height "24px"}))

(def dim9 {:background-color (hsl 0 0 90)})

(def time-tip
 {:color (hsl 0 0 80),
  :vertical-align "middle",
  :font-size "10px",
  :font-weight "lighter",
  :flex-shrink 0,
  :align-self "center",
  :font-family "Menlo,monospace"})

(def number-highlight
 {:line-height 2,
  :color (hsl 0 0 100),
  :font-size "12px",
  :background-color (hsl 40 80 60),
  :padding "0 8px",
  :display "inline-block",
  :border-radius "12px"})

(def button
 {:line-height 2,
  :color "white",
  :font-size "14px",
  :font-weight "normal",
  :background-color (hsl 200 60 80),
  :padding "0 8px",
  :outline "none",
  :border "none",
  :border-radius "8px"})
