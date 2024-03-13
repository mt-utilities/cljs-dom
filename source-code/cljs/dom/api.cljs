
(ns dom.api
    (:require [dom.animations            :as animations]
              [dom.attributes            :as attributes]
              [dom.body                  :as body]
              [dom.class                 :as class]
              [dom.dimensions            :as dimensions]
              [dom.position :as position]
              [dom.document              :as document]
              [dom.element               :as element]
              [dom.event                 :as event]
              [dom.file                  :as file]
              [dom.file-selector         :as file-selector]
              [dom.focus                 :as focus]
              [dom.form-data             :as form-data]
              [dom.head                  :as head]
              [dom.image                 :as image]
              [dom.intersection-observer :as intersection-observer]
              [dom.mouse                 :as mouse]
              [dom.node                  :as node]
              [dom.parse                 :as parse]
              [dom.script                :as script]
              [dom.scroll                :as scroll]
              [dom.selection             :as selection]
              [dom.style                 :as style]
              [dom.title                 :as title]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @redirect (dom.animations/*)
(def remove-element-animated! animations/remove-element-animated!)
(def hide-element-animated!   animations/hide-element-animated!)
(def reveal-element-animated! animations/reveal-element-animated!)

; @redirect (dom.attributes/*)
(def get-element-attribute-names attributes/get-element-attribute-names)
(def get-element-attributes      attributes/get-element-attributes)
(def remove-element-attributes!  attributes/remove-element-attributes!)
(def merge-element-attributes!   attributes/merge-element-attributes!)
(def set-element-attributes!     attributes/set-element-attributes!)
(def get-element-attribute       attributes/get-element-attribute)
(def remove-element-attribute!   attributes/remove-element-attribute!)
(def set-element-attribute!      attributes/set-element-attribute!)

; @redirect (dom.body/*)
(def get-body-element              body/get-body-element)
(def get-body-computed-style-value body/get-body-computed-style-value)
(def get-body-inline-style-value   body/get-body-inline-style-value)

; @redirect (dom.class/*)
(def set-element-class!    class/set-element-class!)
(def remove-element-class! class/remove-element-class!)

; @redirect (dom.dimensions/*)
(def get-element-offset-width  dimensions/get-element-offset-width)
(def get-element-offset-height dimensions/get-element-offset-height)

; @redirect (dom.document/*)
(def get-document-element       document/get-document-element)
(def get-document-scroll-height document/get-document-scroll-height)
(def get-document-scroll-width  document/get-document-scroll-width)
(def toggle-design-mode!        document/toggle-design-mode!)

; @redirect (dom.element/*)
(def get-element-tag-name       element/get-element-tag-name)
(def get-element-by-id          element/get-element-by-id)
(def get-element-by-class-name  element/get-element-by-class-name)
(def get-elements-by-class-name element/get-elements-by-class-name)
(def get-element-by-tag-name    element/get-element-by-tag-name)
(def get-elements-by-tag-name   element/get-elements-by-tag-name)
(def get-element-by-query       element/get-element-by-query)
(def get-elements-by-query      element/get-elements-by-query)
(def get-element-by-attribute   element/get-element-by-attribute)
(def get-elements-by-attribute  element/get-elements-by-attribute)
(def element-disabled?          element/element-disabled?)
(def element-enabled?           element/element-enabled?)
(def set-element-id!            element/set-element-id!)

; @redirect (dom.event/*)
(def on-mouse-left    event/on-mouse-left)
(def on-mouse-middle  event/on-mouse-middle)
(def on-mouse-right   event/on-mouse-right)
(def stop-propagation event/stop-propagation)
(def prevent-default  event/prevent-default)
(def get-event-value  event/get-event-value)

; @redirect (dom.file-selector/*)
(def file-selector->files              file-selector/file-selector->files)
(def file-selector->file-list          file-selector/file-selector->file-list)
(def file-selector->file               file-selector/file-selector->file)
(def file-selector->files-size         file-selector/file-selector->files-size)
(def file-selector->file-count         file-selector/file-selector->file-count)
(def file-selector->any-file-selected? file-selector/file-selector->any-file-selected?)
(def file-selector->mime-types         file-selector/file-selector->mime-types)
(def file-selector->files-data         file-selector/file-selector->files-data)
(def file-selector->files-meta         file-selector/file-selector->files-meta)
(def file-selector->file-data-url      file-selector/file-selector->file-data-url)
(def file-selector->form-data          file-selector/file-selector->form-data)

; @redirect (dom.file/*)
(def file->filesize  file/file->filesize)
(def file->filename  file/file->filename)
(def file->mime-type file/file->mime-type)
(def file->image?    file/file->image?)
(def file->file-data file/file->file-data)

; @redirect (dom.focus/*)
(def get-active-element   focus/get-active-element)
(def element-focused?     focus/element-focused?)
(def element-blurred?     focus/element-blurred?)
(def focus-element!       focus/focus-element!)
(def blur-element!        focus/blur-element!)
(def blur-active-element! focus/blur-active-element!)

; @redirect (dom.form-data/*)
(def append-to-form-data! form-data/append-to-form-data!)
(def merge-to-form-data!  form-data/merge-to-form-data!)

; @redirect (dom.head/*)
(def get-head-element head/get-head-element)

; @redirect (dom.image/*)
(def set-image-source! image/set-image-source!)

; @redirect (dom.intersection-observer/*)
(def create-intersection-observer!     intersection-observer/create-intersection-observer!)
(def disconnect-intersection-observer! intersection-observer/disconnect-intersection-observer!)
(def observe-element-intersection!     intersection-observer/observe-element-intersection!)
(def unobserve-element-intersection!   intersection-observer/unobserve-element-intersection!)

; @redirect (dom.mouse/*)
(def get-mouse-x                mouse/get-mouse-x)
(def get-mouse-y                mouse/get-mouse-y)
(def get-mouse-viewport-quarter mouse/get-mouse-viewport-quarter)

; @redirect (dom.node/*)
(def insert-before!                     node/insert-before!)
(def insert-after!                      node/insert-after!)
(def insert-as-first-of-type!           node/insert-as-first-of-type!)
(def insert-as-last-of-type!            node/insert-as-last-of-type!)
(def insert-as-first-of-query-selected! node/insert-as-first-of-query-selected!)
(def insert-as-last-of-query-selected!  node/insert-as-last-of-query-selected!)
(def append-element!                    node/append-element!)
(def prepend-element!                   node/prepend-element!)
(def create-element!                    node/create-element!)
(def remove-element!                    node/remove-element!)
(def remove-child-element!              node/remove-child-element!)
(def remove-element-children!           node/remove-element-children!)
(def set-element-content!               node/set-element-content!)

; @redirect (dom.parse/*)
(def parse-html parse/parse-html)

; @redirect (dom.position/*)
(def get-element-relative-x             position/get-element-relative-x)
(def get-element-relative-y             position/get-element-relative-y)
(def get-element-absolute-x             position/get-element-absolute-x)
(def get-element-absolute-y             position/get-element-absolute-y)
(def get-element-offset-x               position/get-element-offset-x)
(def get-element-offset-y               position/get-element-offset-y)
(def get-element-mass-point-x           position/get-element-mass-point-x)
(def get-element-mass-point-y           position/get-element-mass-point-y)
(def element-on-viewport-left?          position/element-on-viewport-left?)
(def element-on-viewport-right?         position/element-on-viewport-right?)
(def element-on-viewport-top?           position/element-on-viewport-top?)
(def element-on-viewport-bottom?        position/element-on-viewport-bottom?)
(def get-element-mass-point-orientation position/get-element-mass-point-orientation)

; @redirect (dom.script/*)
(def append-script! script/append-script!)

; @redirect (dom.scroll/*)
(def get-scroll-x              scroll/get-scroll-x)
(def get-scroll-y              scroll/get-scroll-y)
(def scroll-x-direction-ltr?   scroll/scroll-x-direction-ltr?)
(def scroll-x-direction-rtl?   scroll/scroll-x-direction-rtl?)
(def scroll-y-direction-ttb?   scroll/scroll-y-direction-ttb?)
(def scroll-y-direction-btt?   scroll/scroll-y-direction-btt?)
(def get-scroll-x-direction    scroll/get-scroll-x-direction)
(def get-scroll-y-direction    scroll/get-scroll-y-direction)
(def get-scroll-x-progress     scroll/get-scroll-x-progress)
(def get-scroll-y-progress     scroll/get-scroll-y-progress)
(def set-scroll-x!             scroll/set-scroll-x!)
(def set-scroll-y!             scroll/set-scroll-y!)
(def scroll-to-element-left!   scroll/scroll-to-element-left!)
(def scroll-to-element-right!  scroll/scroll-to-element-right!)
(def scroll-to-element-top!    scroll/scroll-to-element-top!)
(def scroll-to-element-bottom! scroll/scroll-to-element-bottom!)

; @redirect (dom.selection/*)
(def get-selection-start  selection/get-selection-start)
(def get-selection-end    selection/get-selection-end)
(def set-selection-start! selection/set-selection-start!)
(def set-selection-end!   selection/set-selection-end!)
(def set-selection-range! selection/set-selection-range!)
(def set-caret-position!  selection/set-caret-position!)
(def move-caret-to-start! selection/move-caret-to-start!)
(def move-caret-to-end!   selection/move-caret-to-end!)
(def select-content!      selection/select-content!)

; @redirect (dom.style/*)
(def get-element-computed-style         style/get-element-computed-style)
(def get-element-computed-style-value   style/get-element-computed-style-value)
(def get-element-inline-style           style/get-element-inline-style)
(def merge-element-inline-style!        style/merge-element-inline-style!)
(def set-element-inline-style!          style/set-element-inline-style!)
(def remove-element-inline-style!       style/remove-element-inline-style!)
(def get-element-inline-style-value     style/get-element-inline-style-value)
(def set-element-inline-style-value!    style/set-element-inline-style-value!)
(def remove-element-inline-style-value! style/remove-element-inline-style-value!)

; @redirect (dom.title/*)
(def get-document-title  title/get-document-title)
(def set-document-title! title/set-document-title!)
