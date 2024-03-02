
(ns dom.intersection-observer
    (:require [fruits.vector.api :as vector]
              [fruits.mixed.api :as mixed]
              [fruits.math.api :as math]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn create-intersection-observer!
  ; @param (function) callback-f
  ; @param (map)(opt) options
  ; {:root-element (DOM Element object)(opt)
  ;   Default: js/document
  ;  :root-margin (string)(opt)
  ;   Default: "0px 0px 0px 0px"
  ;  :threshold (percentage or percentages in vector)(opt)
  ;   Default: 0}
  ;
  ; @usage
  ; (create-intersection-observer! (fn [intersecting?] ...))
  ; =>
  ; #object[IntersectionObserver]
  ;
  ; @usage
  ; (create-intersection-observer! (fn [intersecting?] ...) {...})
  ;
  ; @return (DOM IntersectionObserver object)
  ([callback-f]
   (create-intersection-observer! callback-f {}))

  ([callback-f {:keys [root-element root-margin threshold]}]
   (letfn [(f0 [%] (-> % (aget 0) .-isIntersecting callback-f))
           (f1 [%] (-> % (mixed/to-vector) f2))
           (f2 [%] (-> % (vector/update-all-item f3)))
           (f3 [%] (-> % (mixed/to-number) (/ 100) (math/between 0 1)))]
          (js/IntersectionObserver. f0 {:root       (or root-element js/document)
                                        :rootMargin (or root-margin "0px 0px 0px 0px")
                                        :threshold  (-> threshold f1)}))))

(defn disconnect-intersection-observer!
  ; @param (DOM IntersectionObserver object) observer
  ;
  ; @usage
  ; (def my-observer (create-intersection-observer! (fn [intersecting?] ...)))
  ; (disconnect-intersection-observer! my-observer)
  ; =>
  ; nil
  ;
  ; @return (nil)
  [observer]
  (-> observer (.disconnect)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn observe-element-intersection!
  ; @description
  ; Adds the given element as a target element of the given intersection observer.
  ;
  ; @param (DOM IntersectionObserver object) observer
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element  (get-element-by-id "my-element"))
  ; (def my-observer (create-intersection-observer! (fn [intersecting?] ...)))
  ; (observe-element-intersection! my-observer my-element)
  ; =>
  ; #object[IntersectionObserver]
  ;
  ; @return (DOM IntersectionObserver object)
  [observer element]
  (-> observer (.observe element))
  (-> observer))

(defn unobserve-element-intersection!
  ; @description
  ; Removes the given element from the target elements of the given intersection observer.
  ;
  ; @param (DOM IntersectionObserver object) observer
  ; @param (DOM Element object) element
  ;
  ; @usage
  ; (def my-element  (get-element-by-id "my-element"))
  ; (def my-observer (create-intersection-observer! (fn [intersecting?] ...)))
  ; (unobserve-element-intersection! my-observer my-element)
  ; =>
  ; #object[IntersectionObserver]
  ;
  ; @return (DOM IntersectionObserver object)
  [observer element]
  (-> observer (.unobserve element))
  (-> observer))
