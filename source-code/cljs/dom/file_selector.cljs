
(ns dom.file-selector
    (:require [dom.file           :as file]
              [dom.form-data      :as form-data]
              [fruits.seqable.api :as seqable]
              [fruits.vector.api  :as vector]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn file-selector->files
  ; @description
  ; Returns the selected file list of the given file selector input element.
  ;
  ; @param (DOM Element object) file-selector
  ;
  ; @usage
  ; (def my-file-selector (get-element-by-id "my-file-selector"))
  ; (file-selector->files my-file-selector)
  ; =>
  ; #object[FileList]
  ;
  ; @return (DOM FileList object)
  [file-selector]
  (-> file-selector .-files))

(defn file-selector->file-list
  ; @description
  ; Returns the selected files (in a vector) of the given file selector input element.
  ;
  ; @param (DOM Element object) file-selector
  ;
  ; @usage
  ; (def my-file-selector (get-element-by-id "my-file-selector"))
  ; (file-selector->file-list my-file-selector)
  ; =>
  ; [#object[File] #object[File] #object[File]]
  ;
  ; @return (DOM File objects in vector)
  [file-selector]
  (-> file-selector .-files array-seq vec))

(defn file-selector->file
  ; @description
  ; Returns the nth selected file of the given file selector input element.
  ;
  ; @param (DOM Element object) file-selector
  ; @param (integer) file-dex
  ;
  ; @usage
  ; (def my-file-selector (get-element-by-id "my-file-selector"))
  ; (file-selector->file my-file-selector 1)
  ; =>
  ; #object[File]
  ;
  ; @return (DOM File object)
  [file-selector file-dex]
  (-> file-selector .-files array-seq vec (vector/nth-item file-dex)))

(defn file-selector->files-size
  ; @description
  ; Returns the summary size of selected files of the given file selector input element.
  ;
  ; @param (DOM Element object) file-selector
  ;
  ; @usage
  ; (def my-file-selector (get-element-by-id "my-file-selector"))
  ; (file-selector->files-size my-file-selector)
  ;
  ; @return (B)
  [file-selector]
  (letfn [(f0 [%1 %2] (+ %1 (.-size %2)))]
         (reduce f0 0 (-> file-selector .-files array-seq vec))))

(defn file-selector->file-count
  ; @description
  ; Returns the count of selected files of the given file selector input element.
  ;
  ; @param (DOM Element object) file-selector
  ;
  ; @usage
  ; (def my-file-selector (get-element-by-id "my-file-selector"))
  ; (file-selector->file-count my-file-selector)
  ; =>
  ; 3
  ;
  ; @return (integer)
  [file-selector]
  (-> file-selector .-files .-length))

(defn file-selector->any-file-selected?
  ; @description
  ; Returns TRUE if any file is selected by the given file selector input element.
  ;
  ; @param (DOM Element object) file-selector
  ;
  ; @usage
  ; (def my-file-selector (get-element-by-id "my-file-selector"))
  ; (file-selector->any-file-selected? my-file-selector)
  ; =>
  ; true
  ;
  ; @return (boolean)
  [file-selector]
  (-> file-selector .-files .-length (> 0)))

(defn file-selector->mime-types
  ; @description
  ; Returns the list of MIME types of the selected files of the given file selector input element.
  ;
  ; @param (DOM Element object) file-selector
  ;
  ; @usage
  ; (def my-file-selector (get-element-by-id "my-file-selector"))
  ; (file-selector->mime-types my-file-selector)
  ; =>
  ; ["image/png" "image/png" "image/png"]
  ;
  ; @return (strings in vector)
  [file-selector]
  (letfn [(f0 [%1 %2] (conj %1 (.-type %2)))]
         (reduce f0 [] (-> file-selector .-files array-seq vec))))

(defn file-selector->files-data
  ; @description
  ; Returns the details of the selected files of the given file selector input element.
  ;
  ; @param (DOM Element object) file-selector
  ;
  ; @usage
  ; (def my-file-selector (get-element-by-id "my-file-selector"))
  ; (file-selector->files-data my-file-selector)
  ; =>
  ; [{:file-dex 0 :filename "my-image-1.png" :filesize 420 :mime-type "image/png" :object-uri "..."}
  ;  {:file-dex 1 :filename "my-image-2.png" :filesize 420 :mime-type "image/png" :object-uri "..."}
  ;  {:file-dex 2 :filename "my-image-3.png" :filesize 420 :mime-type "image/png" :object-uri "..."}]
  ;
  ; @return (maps in vector)
  ; [(map) file-data
  ;   {:file-dex (integer)
  ;    :filename (string)
  ;    :filesize (B)
  ;    :mime-type (string)
  ;    :object-url (string)}]
  [file-selector]
  (letfn [(f0 [%1 %2 %3] (conj %1 (file/file->file-data %2 %3)))]
         (reduce-kv f0 [] (-> file-selector .-files array-seq vec))))

(defn file-selector->files-meta
  ; @description
  ; Returns the details of the file selection of the given file selector input element.
  ;
  ; @param (DOM Element object) file-selector
  ;
  ; @usage
  ; (def my-file-selector (get-element-by-id "my-file-selector"))
  ; (file-selector->files-meta my-file-selector)
  ; =>
  ; {:file-count 3
  ;  :file-size  1260}
  ;
  ; @return (map)
  ; {:file-count (integer)
  ;  :files-size (B)}
  [file-selector]
  {:file-count (file-selector->file-count file-selector)
   :files-size (file-selector->files-size file-selector)})

(defn file-selector->file-data-url
  ; @description
  ; Converts the nth selected file of the given file selector input element into data URL and applies the given callback function on the result.
  ;
  ; @param (DOM Element object) file-selector
  ; @param (integer) file-dex
  ; @param (function) callback-f
  ;
  ; @usage
  ; (def my-file-selector (get-element-by-id "my-file-selector"))
  ; (file-selector->file-data-url my-file-selector 2 (fn [data-url] ...))
  ; =>
  ; #object[File]
  ;
  ; @return (DOM File object)
  [file-selector file-dex callback-f]
  (let [file        (file-selector->file file-selector file-dex)
        file-reader (js/FileReader.)]
       (if callback-f (set! (.-onload file-reader) #(-> file-reader .-result callback-f)))
       (if file       (.readAsDataURL file-reader file))
       (-> file)))

(defn file-selector->form-data
  ; @description
  ; Returns a FormData object containing the selected files of the given file selector (input),
  ; optionally filtered based on the given file indices.
  ;
  ; @param (DOM Element object) file-selector
  ; @param (integers in vector)(opt) filtered-dexes
  ;
  ; @usage
  ; (def my-file-selector (get-elementy-by-id "my-file-selector"))
  ; (file-selector->form-data my-file-selector)
  ; =>
  ; #object[FormData]
  ;
  ; @usage
  ; (def my-file-selector (get-elementy-by-id "my-file-selector"))
  ; (file-selector->form-data my-file-selector [0 1 4])
  ; =>
  ; #object[FormData]
  ;
  ; @return (FormData object)
  ([file-selector]
   (let [file-list  (file-selector->file-list file-selector)
         file-dexes (seqable/dex-range        file-list)]
        (file-selector->form-data file-selector file-dexes)))

  ([file-selector filtered-dexes]
   (let [form-data  (js/FormData.)
         file-list  (file-selector->file-list file-selector)]
        (doseq [file-dex filtered-dexes]
               (if-let [file (vector/nth-item file-list file-dex)]
                       (form-data/append-to-form-data! form-data file-dex file)))
        (-> form-data))))
