
# <strong>dom.api</strong> namespace</p>
<p>Documentation of the <strong>dom/api.cljs</strong> file</p>

### add-event-listener!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [add-event-listener!]]))

(dom/add-event-listener! ...)
(add-event-listener!     ...)
```

```
@param (string) type
@param (function) listener-f
@param (DOM-element)(opt) target
```

```
@usage
(add-event-listener! "mousemove" (fn [event] ...))
```

```
@return (DOM-element)
```

---

### append-element!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [append-element!]]))

(dom/append-element! ...)
(append-element!     ...)
```

```
@param (DOM-element) parent-element
@param (DOM-element) child-element
```

```
@usage
(def my-parent-element (get-element-by-id "my-parent-element"))
(def my-child-element  (create-element! "div"))
(append-element! my-parent-element my-child-element)
```

```
@return (DOM-element)
```

---

### append-script!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [append-script!]]))

(dom/append-script! ...)
(append-script!     ...)
```

```
@param (string) script
```

```
@usage
(append-script! "console.log('420')")
```

```
@return (DOM-element)
```

---

### append-to-form-data!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [append-to-form-data!]]))

(dom/append-to-form-data! ...)
(append-to-form-data!     ...)
```

```
@param (FormData object) 
@param (keyword or string) prop-key
@param (*) prop-value
```

```
@usage
(def my-form-data (js/FormData.))
(append-to-form-data! my-form-data :name "John")
```

```
@return (FormData object)
```

---

### blur-element!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [blur-element!]]))

(dom/blur-element! ...)
(blur-element!     ...)
```

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(blur-element! my-element)
```

```
@return (DOM-element)
```

---

### create-element!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [create-element!]]))

(dom/create-element! ...)
(create-element!     ...)
```

```
@param (string) nodename
```

```
@usage
(create-element! "div")
```

```
@return (DOM-element)
```

---

### element-disabled?

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [element-disabled?]]))

(dom/element-disabled? ...)
(element-disabled?     ...)
```

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(element-disabled? my-element)
```

```
@return (boolean)
```

---

### element-enabled?

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [element-enabled?]]))

(dom/element-enabled? ...)
(element-enabled?     ...)
```

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(element-enabled? my-element)
```

```
@return (boolean)
```

---

### element-on-viewport-bottom?

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [element-on-viewport-bottom?]]))

(dom/element-on-viewport-bottom? ...)
(element-on-viewport-bottom?     ...)
```

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(element-on-viewport-bottom? my-element)
```

```
@return (boolean)
```

---

### element-on-viewport-left?

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [element-on-viewport-left?]]))

(dom/element-on-viewport-left? ...)
(element-on-viewport-left?     ...)
```

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(element-on-viewport-left? my-element)
```

```
@return (boolean)
```

---

### element-on-viewport-right?

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [element-on-viewport-right?]]))

(dom/element-on-viewport-right? ...)
(element-on-viewport-right?     ...)
```

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(element-on-viewport-right? my-element)
```

```
@return (boolean)
```

---

### element-on-viewport-top?

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [element-on-viewport-top?]]))

(dom/element-on-viewport-top? ...)
(element-on-viewport-top?     ...)
```

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(element-on-viewport-top? my-element)
```

```
@return (boolean)
```

---

### empty-element!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [empty-element!]]))

(dom/empty-element! ...)
(empty-element!     ...)
```

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(empty-element! my-element)
```

```
@return (DOM-element)
```

---

### event->node-name

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [event->node-name]]))

(dom/event->node-name ...)
(event->node-name     ...)
```

```
@param (DOM-event) event
```

```
@usage
(fn [my-event]
    (event->node-name my-event))
```

```
@return (string)
```

---

### event->value

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [event->value]]))

(dom/event->value ...)
(event->value     ...)
```

```
@param (dom-event) n
```

```
@usage
(fn [my-event]
    (event->value my-event))
```

```
@return (*)
```

---

### file->file-data

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [file->file-data]]))

(dom/file->file-data ...)
(file->file-data     ...)
```

```
@param (integer)(opt) file-dex
@param (file object) file
```

```
@usage
(def my-file-selector (get-element-by-id "my-file-selector"))
(def my-file          (file-selector->file my-file-selector 0))
(file->file-data 2 my-file)
```

```
@return (map)
```

---

### file->filename

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [file->filename]]))

(dom/file->filename ...)
(file->filename     ...)
```

```
@param (file object) file
```

```
@usage
(def my-file-selector (get-element-by-id "my-file-selector"))
(def my-file          (file-selector->file my-file-selector 0))
(file->filename my-file)
```

```
@return (string)
```

---

### file->filesize

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [file->filesize]]))

(dom/file->filesize ...)
(file->filesize     ...)
```

```
@param (file object) file
```

```
@usage
(def my-file-selector (get-element-by-id "my-file-selector"))
(def my-file          (file-selector->file my-file-selector 0))
(file->filesize my-file)
```

```
@return (B)
```

---

### file->image?

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [file->image?]]))

(dom/file->image? ...)
(file->image?     ...)
```

```
@param (file object) file
```

```
@usage
(def my-file-selector (get-element-by-id "my-file-selector"))
(def my-file          (file-selector->file my-file-selector 0))
(file->image? my-file)
```

```
@return (boolean)
```

---

### file->mime-type

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [file->mime-type]]))

(dom/file->mime-type ...)
(file->mime-type     ...)
```

```
@param (file object) file
```

```
@usage
(def my-file-selector (get-element-by-id "my-file-selector"))
(def my-file          (file-selector->file my-file-selector 0))
(file->mime-type my-file)
```

```
@return (string)
```

---

### file-selector->any-file-selected?

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [file-selector->any-file-selected?]]))

(dom/file-selector->any-file-selected? ...)
(file-selector->any-file-selected?     ...)
```

```
@param (DOM-element) file-selector
```

```
@usage
(def my-file-selector (get-element-by-id "my-file-selector"))
(file-selector->any-file-selected? my-file-selector)
```

```
@return (boolean)
```

---

### file-selector->file

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [file-selector->file]]))

(dom/file-selector->file ...)
(file-selector->file     ...)
```

```
@param (DOM-element) file-selector
```

```
@usage
(def my-file-selector (get-element-by-id "my-file-selector"))
(file-selector->files my-file-selector)
```

```
@return (?)
```

---

### file-selector->file-count

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [file-selector->file-count]]))

(dom/file-selector->file-count ...)
(file-selector->file-count     ...)
```

```
@param (DOM-element) file-selector
```

```
@usage
(def my-file-selector (get-element-by-id "my-file-selector"))
(file-selector->file-count my-file-selector)
```

```
@return (integer)
```

---

### file-selector->file-list

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [file-selector->file-list]]))

(dom/file-selector->file-list ...)
(file-selector->file-list     ...)
```

```
@param (DOM-element) file-selector
```

```
@usage
(def my-file-selector (get-element-by-id "my-file-selector"))
(file-selector->file-list my-file-selector)
```

```
@return (file objects in vector)
```

---

### file-selector->files

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [file-selector->files]]))

(dom/file-selector->files ...)
(file-selector->files     ...)
```

```
@param (DOM-element) file-selector
```

```
@usage
(def my-file-selector (get-element-by-id "my-file-selector"))
(file-selector->files my-file-selector)
```

```
@return (?)
```

---

### file-selector->files-data

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [file-selector->files-data]]))

(dom/file-selector->files-data ...)
(file-selector->files-data     ...)
```

```
@param (DOM-element) file-selector
```

```
@usage
(def my-file-selector (get-element-by-id "my-file-selector"))
(file-selector->files-data my-file-selector)
```

```
@return (maps in vector)
```

---

### file-selector->files-meta

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [file-selector->files-meta]]))

(dom/file-selector->files-meta ...)
(file-selector->files-meta     ...)
```

```
@param (DOM-element) file-selector
```

```
@usage
(def my-file-selector (get-element-by-id "my-file-selector"))
(file-selector->files-meta my-file-selector)
```

```
@return (map)
```

---

### file-selector->files-size

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [file-selector->files-size]]))

(dom/file-selector->files-size ...)
(file-selector->files-size     ...)
```

```
@param (DOM-element) file-selector
```

```
@usage
(def my-file-selector (get-element-by-id "my-file-selector"))
(file-selector->files-size my-file-selector)
```

```
@return (B)
```

---

### file-selector->form-data

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [file-selector->form-data]]))

(dom/file-selector->form-data ...)
(file-selector->form-data     ...)
```

```
@param (DOM-element) file-selector
@param (strings in vector)(opt) filtered-file-keys
```

```
@usage
(def my-file-selector (get-elementy-by-id "my-file-selector"))
(file-selector->form-data my-file-selector)
```

```
@usage
(def my-file-selector (get-elementy-by-id "my-file-selector"))
(file-selector->form-data my-file-selector ["0" "1" "4"])
```

```
@return (FormData object)
```

---

### file-selector->image-data-url

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [file-selector->image-data-url]]))

(dom/file-selector->image-data-url ...)
(file-selector->image-data-url     ...)
```

```
@param (DOM-element) file-selector
@param (integer) file-dex
```

```
@usage
(def my-file-selector (get-element-by-id "my-file-selector"))
(file-selector->image-data-url my-file-selector 2)
```

```
@return (string)
```

---

### file-selector->mime-types

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [file-selector->mime-types]]))

(dom/file-selector->mime-types ...)
(file-selector->mime-types     ...)
```

```
@param (DOM-element) file-selector
```

```
@usage
(def my-file-selector (get-element-by-id "my-file-selector"))
(file-selector->mime-types my-file-selector)
```

```
@return (strings in vector)
```

---

### focus-element!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [focus-element!]]))

(dom/focus-element! ...)
(focus-element!     ...)
```

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(focus-element! my-element)
```

```
@return (DOM-element)
```

---

### get-active-element

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-active-element]]))

(dom/get-active-element)
(get-active-element)
```

```
@usage
(get-active-element)
```

```
@return (DOM-element)
```

---

### get-body-element

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-body-element]]))

(dom/get-body-element)
(get-body-element)
```

```
@usage
(get-body-element)
```

```
@return (DOM-element)
```

---

### get-body-style-value

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-body-style-value]]))

(dom/get-body-style-value ...)
(get-body-style-value     ...)
```

```
@param (string) style-name
```

```
@usage
(get-body-style-value "background-color")
```

```
@return (string)
```

---

### get-document-element

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-document-element]]))

(dom/get-document-element)
(get-document-element)
```

```
@usage
(get-document-element)
```

```
@return (DOM-element)
```

---

### get-document-height

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-document-height]]))

(dom/get-document-height)
(get-document-height)
```

```
@usage
(get-document-height)
```

```
@return (px)
```

---

### get-document-title

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-document-title]]))

(dom/get-document-title)
(get-document-title)
```

```
@usage
(get-document-title)
```

```
@return (string)
```

---

### get-document-width

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-document-width]]))

(dom/get-document-width)
(get-document-width)
```

```
@usage
(get-document-width)
```

```
@return (px)
```

---

### get-element-absolute-left

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-element-absolute-left]]))

(dom/get-element-absolute-left ...)
(get-element-absolute-left     ...)
```

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-element-absolute-left my-element)
```

```
@return (px)
```

---

### get-element-absolute-top

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-element-absolute-top]]))

(dom/get-element-absolute-top ...)
(get-element-absolute-top     ...)
```

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-element-absolute-top my-element)
```

```
@return (px)
```

---

### get-element-attribute

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-element-attribute]]))

(dom/get-element-attribute ...)
(get-element-attribute     ...)
```

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-element-attributes my-element)
```

```
@return (map)
```

---

### get-element-attributes

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-element-attributes]]))

(dom/get-element-attributes ...)
(get-element-attributes     ...)
```

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-element-attributes my-element)
```

```
@return (map)
```

---

### get-element-by-id

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-element-by-id]]))

(dom/get-element-by-id ...)
(get-element-by-id     ...)
```

```
@param (DOM-element)(opt) parent-element
@param (string) element-id
```

```
@usage
(get-element-by-id "my-element")
```

```
@return (DOM-element or nil)
```

---

### get-element-by-query

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-element-by-query]]))

(dom/get-element-by-query ...)
(get-element-by-query     ...)
```

```
@param (DOM-element)(opt) parent-element
@param (string) query
```

```
@usage
(get-element-by-query ":scope > div")
```

```
@usage
(get-element-by-query "[type=\"text/css\"]")
```

```
@usage
(get-element-by-query "div.my-class, div.your-class")
```

```
@return (DOM-element)
```

---

### get-element-computed-style

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-element-computed-style]]))

(dom/get-element-computed-style ...)
(get-element-computed-style     ...)
```

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-element-computed-style my-element)
```

```
@return (CSSStyleDeclarationObject)
```

---

### get-element-height

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-element-height]]))

(dom/get-element-height ...)
(get-element-height     ...)
```

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-element-height my-element)
```

```
@return (px)
```

---

### get-element-masspoint-orientation

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-element-masspoint-orientation]]))

(dom/get-element-masspoint-orientation ...)
(get-element-masspoint-orientation     ...)
```

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-element-masspoint-orientation my-element)
```

```
@return (keyword)
```

---

### get-element-masspoint-x

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-element-masspoint-x]]))

(dom/get-element-masspoint-x ...)
(get-element-masspoint-x     ...)
```

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-element-masspoint-x my-element)
```

```
@return (px)
```

---

### get-element-masspoint-y

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-element-masspoint-y]]))

(dom/get-element-masspoint-y ...)
(get-element-masspoint-y     ...)
```

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-element-masspoint-y my-element)
```

```
@return (px)
```

---

### get-element-offset-left

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-element-offset-left]]))

(dom/get-element-offset-left ...)
(get-element-offset-left     ...)
```

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-element-offset-left my-element)
```

```
@return (px)
```

---

### get-element-offset-top

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-element-offset-top]]))

(dom/get-element-offset-top ...)
(get-element-offset-top     ...)
```

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-element-offset-top my-element)
```

```
@return (px)
```

---

### get-element-relative-left

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-element-relative-left]]))

(dom/get-element-relative-left ...)
(get-element-relative-left     ...)
```

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-element-relative-left my-element)
```

```
@return (px)
```

---

### get-element-relative-top

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-element-relative-top]]))

(dom/get-element-relative-top ...)
(get-element-relative-top     ...)
```

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-element-relative-top my-element)
```

```
@return (px)
```

---

### get-element-style

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-element-style]]))

(dom/get-element-style ...)
(get-element-style     ...)
```

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-element-style my-element)```

---

### get-element-style-value

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-element-style-value]]))

(dom/get-element-style-value ...)
(get-element-style-value     ...)
```

```
@param (DOM-element) element
@param (string) style-name
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-element-style my-element "position")
```

```
@return (string)
```

---

### get-element-width

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-element-width]]))

(dom/get-element-width ...)
(get-element-width     ...)
```

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-element-width my-element)
```

```
@return (px)
```

---

### get-elements-by-class-name

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-elements-by-class-name]]))

(dom/get-elements-by-class-name ...)
(get-elements-by-class-name     ...)
```

```
@param (DOM-element)(opt) parent-element
@param (string) class-name
```

```
@usage
(get-elements-by-class-name "my-class")
```

```
@return (vector)
```

---

### get-elements-by-query

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-elements-by-query]]))

(dom/get-elements-by-query ...)
(get-elements-by-query     ...)
```

```
@param (DOM-element)(opt) parent-element
@param (string) query
```

```
@usage
(get-elements-by-query ":scope > div")
```

```
@usage
(get-elements-by-query "[type=\"text/css\"]")
```

```
@usage
(get-elements-by-query "div.my-class, div.your-class")
```

```
@return (vector)
```

---

### get-elements-by-tag-name

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-elements-by-tag-name]]))

(dom/get-elements-by-tag-name ...)
(get-elements-by-tag-name     ...)
```

```
@param (DOM-element)(opt) parent-element
@param (string) tag-name
```

```
@usage
(get-elements-by-class-name "div")
```

```
@return (vector)
```

---

### get-head-element

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-head-element]]))

(dom/get-head-element)
(get-head-element)
```

```
@usage
(get-head-element)
```

```
@return (DOM-element)
```

---

### get-mouse-viewport-quarter

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-mouse-viewport-quarter]]))

(dom/get-mouse-viewport-quarter ...)
(get-mouse-viewport-quarter     ...)
```

```
@param (DOM-event) mouse-event
```

```
@usage
(fn [mouse-event]
    (get-mouse-viewport-quarter mouse-event))
```

```
@return (keyword)
```

---

### get-mouse-x

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-mouse-x]]))

(dom/get-mouse-x ...)
(get-mouse-x     ...)
```

```
@param (DOM-event) mouse-event
```

```
@usage
(fn [mouse-event]
    (get-mouse-x mouse-event))
```

```
@return (px)
```

---

### get-scroll-direction

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-scroll-direction]]))

(dom/get-scroll-direction ...)
(get-scroll-direction     ...)
```

```
@param (integer) last-scroll-y
```

```
@usage
(get-scroll-direction 100)
```

```
@return (keyword or nil)
```

---

### get-scroll-progress

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-scroll-progress]]))

(dom/get-scroll-progress)
(get-scroll-progress)
```

```
@usage
(get-scroll-progress)
```

```
@return (percent)
```

---

### get-scroll-x

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-scroll-x]]))

(dom/get-scroll-x)
(get-scroll-x)
```

```
@usage
(get-scroll-x)
```

```
@return (px)
```

---

### get-scroll-y

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-scroll-y]]))

(dom/get-scroll-y)
(get-scroll-y)
```

```
@usage
(get-scroll-y)
```

```
@return (px)
```

---

### get-selection-end

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-selection-end]]))

(dom/get-selection-end ...)
(get-selection-end     ...)
```

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-selection-end my-element)
```

```
@return (integer)
```

---

### get-selection-start

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [get-selection-start]]))

(dom/get-selection-start ...)
(get-selection-start     ...)
```

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(get-selection-start my-element)
```

```
@return (integer)
```

---

### insert-after!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [insert-after!]]))

(dom/insert-after! ...)
(insert-after!     ...)
```

```
@param (DOM-element) parent-element
@param (DOM-element) child-element
@param (DOM-element) before-element
```

```
@usage
(def my-parent-element (get-element-by-id "my-parent-element"))
(def my-before-element (get-element-by-id "my-before-element"))
(def my-child-element  (create-element! "div"))
(insert-after! my-parent-element my-child-element my-before-element)
```

```
@return (DOM-element)
```

---

### insert-as-first-of-query-selected!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [insert-as-first-of-query-selected!]]))

(dom/insert-as-first-of-query-selected! ...)
(insert-as-first-of-query-selected!     ...)
```

```
@param (DOM-element) parent-element
@param (DOM-element) child-element
@param (string) query
```

```
@usage
(def head-element    (get-head-element))
(def my-link-element (create-element! "link"))
(insert-as-first-of-query-selected! head-element my-link-element "[type=\"text/css\"]")
```

```
@usage
(def body-element (get-body-element))
(def my-element   (create-element! "div"))
(insert-as-first-of-query-selected! body-element my-element "div.my-class, div.your-class")
```

```
@return (DOM-element)
```

---

### insert-as-first-of-type!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [insert-as-first-of-type!]]))

(dom/insert-as-first-of-type! ...)
(insert-as-first-of-type!     ...)
```

```
@param (DOM-element) parent-element
@param (DOM-element) child-element
```

```
@usage
(def my-parent-element (get-element-by-id "my-parent-element"))
(def my-child-element  (create-element! "div"))
(insert-as-first-of-type! my-parent-element my-child-element)
```

```
@return (DOM-element)
```

---

### insert-as-last-of-query-selected!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [insert-as-last-of-query-selected!]]))

(dom/insert-as-last-of-query-selected! ...)
(insert-as-last-of-query-selected!     ...)
```

```
@param (DOM-element) parent-element
@param (DOM-element) child-element
@param (string) query
```

```
@usage
(def head-element    (get-head-element))
(def my-link-element (create-element! "link"))
(insert-as-first-of-query-selected! head-element my-link-element "[type=\"text/css\"]")
```

```
@usage
(def body-element (get-body-element))
(def my-element   (create-element! "div"))
(insert-as-first-of-query-selected! body-element my-element "div.my-class, div.your-class")
```

```
@return (DOM-element)
```

---

### insert-as-last-of-type!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [insert-as-last-of-type!]]))

(dom/insert-as-last-of-type! ...)
(insert-as-last-of-type!     ...)
```

```
@param (DOM-element) parent-element
@param (DOM-element) child-element
```

```
@usage
(def my-parent-element (get-element-by-id "my-parent-element"))
(def my-child-element  (create-element! "div"))
(insert-as-last-of-type! my-parent-element my-child-element)
```

```
@return (DOM-element)
```

---

### insert-before!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [insert-before!]]))

(dom/insert-before! ...)
(insert-before!     ...)
```

```
@param (DOM-element) parent-element
@param (DOM-element) child-element
@param (DOM-element) after-element
```

```
@usage
(def my-parent-element (get-element-by-id "my-parent-element"))
(def my-after-element  (get-element-by-id "my-after-element"))
(def my-child-element  (create-element! "div"))
(insert-before! my-parent-element my-child-element my-after-element)
```

```
@return (DOM-element)
```

---

### intersection-observer

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [intersection-observer]]))

(dom/intersection-observer ...)
(intersection-observer     ...)
```

```
@param (function) callback-f
```

```
@usage
(intersection-observer (fn [intersecting?] ...))
```

```
@return (?)
```

---

### merge-to-form-data!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [merge-to-form-data!]]))

(dom/merge-to-form-data! ...)
(merge-to-form-data!     ...)
```

```
@param (FormData object) form-data
@param (list of maps) xyz
```

```
@usage
(def my-form-data (js/FormData.))
(merge-to-form-data! my-form-data {...})
```

```
@usage
(def my-form-data (js/FormData.))
(merge-to-form-data! my-form-data {...} {...} {...})
```

```
@return (FormData object)
```

---

### move-caret-to-end!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [move-caret-to-end!]]))

(dom/move-caret-to-end! ...)
(move-caret-to-end!     ...)
```

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(move-caret-to-end! my-element)
```

```
@return (DOM-element)
```

---

### move-caret-to-start!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [move-caret-to-start!]]))

(dom/move-caret-to-start! ...)
(move-caret-to-start!     ...)
```

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(move-caret-to-start! my-element)
```

```
@return (DOM-element)
```

---

### on-mouse-left

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [on-mouse-left]]))

(dom/on-mouse-left ...)
(on-mouse-left     ...)
```

```
@param (DOM-event) mouse-event
@param (function) f
```

```
@usage
(on-mouse-left % (fn [mouse-event] ...))
```

```
@return (*)
```

---

### prepend-element!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [prepend-element!]]))

(dom/prepend-element! ...)
(prepend-element!     ...)
```

```
@param (DOM-element) parent-element
@param (DOM-element) child-element
```

```
@usage
(def my-parent-element (get-element-by-id "my-parent-element"))
(def my-child-element  (create-element! "div"))
(prepend-element! my-parent-element my-child-element)
```

```
@return (DOM-element)
```

---

### prevent-default!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [prevent-default!]]))

(dom/prevent-default! ...)
(prevent-default!     ...)
```

```
@param (DOM-event) event
```

```
@usage
(fn [my-event]
    (prevent-default! my-event))
```

```
@return (*)
```

---

### remove-child!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [remove-child!]]))

(dom/remove-child! ...)
(remove-child!     ...)
```

```
@param (DOM-element) parent-element
@param (DOM-element) child-element
```

```
@usage
(def my-parent-element (get-element-by-id "my-parent-element"))
(def my-child-element  (get-element-by-id "my-child-element"))
(remove-child! my-parent-element my-child-element)
```

```
@return (DOM-element)
```

---

### remove-element!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [remove-element!]]))

(dom/remove-element! ...)
(remove-element!     ...)
```

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(remove-element! my-element)
```

```
@return (undefined)
```

---

### remove-element-attribute!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [remove-element-attribute!]]))

(dom/remove-element-attribute! ...)
(remove-element-attribute!     ...)
```

```
@param (DOM-element) element
@param (string) attribute-name
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(remove-element-attribute! my-element "my-attribute")
```

```
@return (DOM-element)
```

---

### remove-element-attributes!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [remove-element-attributes!]]))

(dom/remove-element-attributes! ...)
(remove-element-attributes!     ...)
```

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(remove-element-attribute! my-element)
```

```
@return (DOM-element)
```

---

### remove-element-class!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [remove-element-class!]]))

(dom/remove-element-class! ...)
(remove-element-class!     ...)
```

```
@param (DOM-element) element
@param (string) class-name
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(remove-element-class! my-element "my-class")
```

```
@return (DOM-element)
```

---

### remove-element-style!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [remove-element-style!]]))

(dom/remove-element-style! ...)
(remove-element-style!     ...)
```

```
@param (DOM-element) element
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(remove-element-style! my-element)
```

```
@return (DOM-element)
```

---

### remove-element-style-value!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [remove-element-style-value!]]))

(dom/remove-element-style-value! ...)
(remove-element-style-value!     ...)
```

```
@param (DOM-element) element
@param (string) style-name
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(remove-element-style-value! my-element "position")
```

```
@return (DOM-element)
```

---

### remove-event-listener!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [remove-event-listener!]]))

(dom/remove-event-listener! ...)
(remove-event-listener!     ...)
```

```
@param (string) type
@param (function) listener-f
@param (DOM-element)(opt) target
```

```
@usage
(def my-listener-f (fn [event]))
(remove-event-listener! "mousemove" my-listener-f)
```

```
@return (DOM-element)
```

---

### remove-intersection-observer!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [remove-intersection-observer!]]))

(dom/remove-intersection-observer! ...)
(remove-intersection-observer!     ...)
```

```
@param (?) observer
@param (DOM-element) element
```

```
@usage
(def my-element  (get-element-by-id "my-element"))
(def my-observer (intersection-observer! my-element (fn [intersecting?])))
(remove-intersection-observer! my-observer my-element)
```

```
@return (DOM-element)
```

---

### scroll-direction-btt?

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [scroll-direction-btt?]]))

(dom/scroll-direction-btt? ...)
(scroll-direction-btt?     ...)
```

```
@param (integer) last-scroll-y
```

```
@usage
(scroll-direction-btt? 100)
```

```
@return (boolean)
```

---

### scroll-direction-ttb?

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [scroll-direction-ttb?]]))

(dom/scroll-direction-ttb? ...)
(scroll-direction-ttb?     ...)
```

```
@param (integer) last-scroll-y
```

```
@usage
(scroll-direction-ttb? 100)
```

```
@return (boolean)
```

---

### scroll-to-element-top!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [scroll-to-element-top!]]))

(dom/scroll-to-element-top! ...)
(scroll-to-element-top!     ...)
```

```
@param (DOM-element) element
@param (px)(opt) offset
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(scroll-to-element-top! my-element)```

---

### select-preventer

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [select-preventer]]))

(dom/select-preventer ...)
(select-preventer     ...)
```

```
@param (DOM-event) mouse-event
```

```
@usage
(fn [mouse-event]
    (select-preventer mouse-event))```

---

### set-caret-position!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [set-caret-position!]]))

(dom/set-caret-position! ...)
(set-caret-position!     ...)
```

```
@param (DOM-element) element
@param (integer) caret-position
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(set-caret-position! my-element 20)
```

```
@return (DOM-element)
```

---

### set-document-title!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [set-document-title!]]))

(dom/set-document-title! ...)
(set-document-title!     ...)
```

```
@param (string) title
```

```
@usage
(set-document-title! "My title")
```

```
@return (string)
```

---

### set-element-attribute!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [set-element-attribute!]]))

(dom/set-element-attribute! ...)
(set-element-attribute!     ...)
```

```
@param (DOM-element) element
@param (string) attribute-name
@param (string) attribute-value
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(set-element-attribute! my-element "my-attribute" "my-value")
```

```
@return (DOM-element)
```

---

### set-element-attributes!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [set-element-attributes!]]))

(dom/set-element-attributes! ...)
(set-element-attributes!     ...)
```

```
@param (DOM-element) element
@param (map) attributes
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(set-element-attributes! my-element {"my-attribute" "my-value"})
```

```
@return (DOM-element)
```

---

### set-element-class!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [set-element-class!]]))

(dom/set-element-class! ...)
(set-element-class!     ...)
```

```
@param (DOM-element) element
@param (string) class-name
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(set-element-class! my-element "my-class")
```

```
@return (DOM-element)
```

---

### set-element-content!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [set-element-content!]]))

(dom/set-element-content! ...)
(set-element-content!     ...)
```

```
@param (DOM-element) element
@param (string) content
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(set-element-content! my-element "Hakuna Matata!")
```

```
@return (DOM-element)
```

---

### set-element-id!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [set-element-id!]]))

(dom/set-element-id! ...)
(set-element-id!     ...)
```

```
@param (DOM-element) element
@param (string) element-id
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(set-element-id! my-element "my-element-id")
```

```
@return (DOM-element)
```

---

### set-element-style!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [set-element-style!]]))

(dom/set-element-style! ...)
(set-element-style!     ...)
```

```
@param (DOM-element) element
@param (map) style
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(set-element-style! my-element {:position "fixed" :top "0"})
```

```
@return (DOM-element)
```

---

### set-element-style-value!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [set-element-style-value!]]))

(dom/set-element-style-value! ...)
(set-element-style-value!     ...)
```

```
@param (DOM-element) element
@param (string) style-name
@param (*) style-value
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(set-element-style-value! my-element "position" "fixed")
```

```
@return (DOM-element)
```

---

### set-scroll-x!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [set-scroll-x!]]))

(dom/set-scroll-x! ...)
(set-scroll-x!     ...)
```

```
@param (px) scroll-x
@param (map)(opt) options
```

```
@usage
(set-scroll-x! 100)```

---

### set-selection-end!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [set-selection-end!]]))

(dom/set-selection-end! ...)
(set-selection-end!     ...)
```

```
@param (DOM-element) element
@param (integer) selection-end
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(set-selection-end! my-element 2)
```

```
@return (DOM-element)
```

---

### set-selection-range!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [set-selection-range!]]))

(dom/set-selection-range! ...)
(set-selection-range!     ...)
```

```
@param (DOM-element) element
@param (integer) selection-start
@param (integer) selection-end
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(set-selection-range! my-element 2 10)
```

```
@return (DOM-element)
```

---

### set-selection-start!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [set-selection-start!]]))

(dom/set-selection-start! ...)
(set-selection-start!     ...)
```

```
@param (DOM-element) element
@param (integer) selection-start
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(set-selection-start! my-element 2)
```

```
@return (DOM-element)
```

---

### setup-intersection-observer!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [setup-intersection-observer!]]))

(dom/setup-intersection-observer! ...)
(setup-intersection-observer!     ...)
```

```
@param (DOM-element) element
@param (function) callback-f
```

```
@usage
(def my-element (get-element-by-id "my-element"))
(setup-intersection-observer! my-element (fn [intersecting?] ...))
```

```
@return (DOM-element)
```

---

### stop-propagation!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [stop-propagation!]]))

(dom/stop-propagation! ...)
(stop-propagation!     ...)
```

```
@param (DOM-event) event
```

```
@usage
(fn [my-event]
    (stop-propagation! my-event))
```

```
@return (*)
```

---

### toggle-design-mode!

```
@require
(ns my-namespace (:require [dom.api :as dom :refer [toggle-design-mode!]]))

(dom/toggle-design-mode!)
(toggle-design-mode!)
```

```
@usage
(toggle-design-mode!)```