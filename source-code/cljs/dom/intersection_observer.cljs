
(ns dom.intersection-observer)

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
  ; (def my-element (get-element-by-id "my-element"))
  ; (setup-intersection-observer! my-element (fn [intersecting?] ...))
  ;
  ; @return (DOM-element)
  [element callback-f]
  (let [observer (intersection-observer callback-f)]
       (-> observer (.observe element))
       (-> observer)))

(defn remove-intersection-observer!
  ; @param (?) observer
  ; @param (DOM-element) element
  ;
  ; @usage
  ; (def my-element  (get-element-by-id "my-element"))
  ; (def my-observer (intersection-observer! my-element (fn [intersecting?])))
  ; (remove-intersection-observer! my-observer my-element)
  ;
  ; @return (DOM-element)
  [observer element]
  (-> observer (.unobserve element))
  (-> observer))
