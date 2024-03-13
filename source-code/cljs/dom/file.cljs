
(ns dom.file
    (:require [io.api :as io]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn file->filesize
  ; @description
  ; Returns the filesize of the given file.
  ;
  ; @param (DOM File object) file
  ;
  ; @usage
  ; (def my-file-selector (get-element-by-id "my-file-selector"))
  ; (def my-file          (file-selector->file my-file-selector 0))
  ; (file->filesize my-file)
  ; =>
  ; 420
  ;
  ; @return (B)
  [file]
  (-> file .-size))

(defn file->filename
  ; @description
  ; Returns the filename of the given file.
  ;
  ; @param (DOM File object) file
  ;
  ; @usage
  ; (def my-file-selector (get-element-by-id "my-file-selector"))
  ; (def my-file          (file-selector->file my-file-selector 0))
  ; (file->filename my-file)
  ; =>
  ; "my-image.png"
  ;
  ; @return (string)
  [file]
  (-> file .-name))

(defn file->mime-type
  ; @description
  ; Returns the MIME type of the given file.
  ;
  ; @param (DOM File object) file
  ;
  ; @usage
  ; (def my-file-selector (get-element-by-id "my-file-selector"))
  ; (def my-file          (file-selector->file my-file-selector 0))
  ; (file->mime-type my-file)
  ; =>
  ; "png"
  ;
  ; @return (string)
  [file]
  (-> file .-type))

(defn file->image?
  ; @description
  ; Returns TRUE if the given file is an image (based on its MIME type).
  ;
  ; @param (DOM File object) file
  ;
  ; @usage
  ; (def my-file-selector (get-element-by-id "my-file-selector"))
  ; (def my-file          (file-selector->file my-file-selector 0))
  ; (file->image? my-file)
  ; =>
  ; true
  ;
  ; @return (boolean)
  [file]
  (-> file .-type io/mime-type->image?))

(defn file->file-data
  ; @description
  ; Returns the details of the given file.
  ;
  ; @param (integer)(opt) file-dex
  ; @param (DOM File object) file
  ;
  ; @usage
  ; (def my-file-selector (get-element-by-id "my-file-selector"))
  ; (def my-file          (file-selector->file my-file-selector 0))
  ; (file->file-data 2 my-file)
  ; =>
  ; {:file-dex   2
  ;  :filename   "my-image.png"
  ;  :filesize   420
  ;  :mime-type  "image/png"
  ;  :object-uri "..."}
  ;
  ; @return (map)
  ; {:file-dex (integer)
  ;  :filename (string)
  ;  :filesize (B)
  ;  :mime-type (string)
  ;  :object-url (string)}
  ([file]
   (file->file-data nil file))

  ([file-dex file]
   {:file-dex   file-dex
    :filename   (.-name file)
    :filesize   (.-size file)
    :mime-type  (.-type file)
    :object-url (.createObjectURL js/URL file)}))
