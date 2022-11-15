
(ns dom.intersection-observer
    (:require [candy.api :refer [return]]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn intersection-observer
  ; @param (function) callback-f
  ;
  ; @usage
  ; (intersection-observer (fn [intersecting?] ...))
  ;
  ; @return (?)
  [callback-f]
  (letfn [(f [%] (callback-f (-> % (aget 0) .-isIntersecting)))]
         (js/IntersectionObserver. f {})))

(defn setup-intersection-observer!
  ; @param (DOM-element) element
  ; @param (function) callback-f
  ;
  ; @usage
  ; (setup-intersection-observer! my-element (fn [intersecting?] ...))
  ;
  ; @return (DOM-element)
  [element callback-f]
  (let [observer (intersection-observer callback-f)]
       (.observe observer element)
       (return   observer)))

(defn remove-intersection-observer!
  ; @param (?) observer
  ; @param (DOM-element) element
  ;
  ; @usage
  ; (remove-intersection-observer! my-observer my-element)
  ;
  ; @return (DOM-element)
  [observer element]
  (.unobserve observer element)
  (return     observer))
