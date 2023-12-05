
(ns dom.value
    (:require [keyword.api :as keyword]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn value
  ; @description
  ; Transforms the given 'n' value into a valid HTML attribute value.
  ;
  ; @param (keyword or string) n
  ; @param (string)(opt) flag
  ;
  ; @example
  ; (value "my-namespace/my-value?")
  ; =>
  ; "my-namespace--my-value"
  ;
  ; @example
  ; (value :your-namespace/your-value!)
  ; =>
  ; "your-namespace--your-value"
  ;
  ; @example
  ; (value :our-namespace/our-value "420")
  ; =>
  ; "our-namespace--our-value--420"
  ;
  ; @return (string)
  [n & [flag]]
  (let [x (cond (keyword? n) (-> n keyword/to-string)
                (string?  n) (-> n))]
       (letfn [(f0 [result tag] (case tag "." (str result "--")
                                          "/" (str result "--")
                                          "?" result
                                          "!" result
                                          ">" result
                                              (str result tag)))]
              (str (reduce f0 nil x)
                   (if flag (str "--" flag))))))
