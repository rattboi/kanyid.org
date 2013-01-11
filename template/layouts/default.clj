; @title  default title
; @format html5

;; Your own function in template
(defn page-header [heading title & link]
  [:div {:class "page-title"}
   (if (nil? link)
     [heading title]
     [:a {:href (first link)} [heading title]])])

[:head
 [:meta {:charset (:charset site)}]
 [:meta {:name    "viewport"
         :content "width=device-width, initiali-scale=1.0, user-scalable=yes"}]

 [:title
  (if (= (:title site) "home")
    (:site-title site)
    (str (:site-title site) " - " (:title site)))]

 [:link {:rel   "shortcut icon"
         :href  "/favicon.ico"}]
 [:link {:href  "/atom.xml"
         :rel   "alternate"
         :title (:title site)
         :type  "application/atom-xml"}]

 (absolute-css ["/css/prettify.css" (:css site ())])
 (absolute-css {:media "only screen and (max-device-width:480px)"} (:device-css site))]
; /head

[:body

 ; github ribbon
 (github-ribbon "https://github.com/rattboi/kanyid.org")

 (container
  (page-header :h1 (:site-title site) "/" ) 

  contents

  (footer
    (str "// rattboi / ")
    (link (str "@" (:twitter site)) (str "http://twitter.com/" (:twitter site)))
    (str " / ")
    (link "rss" "atom.xml")
    (str " / ")
    (link "github" "https://github.com/rattboi")
    )
  
  (link (img "/img/poweredby-misaki.png") "https://github.com/liquidz/misaki"))

 ; /container

 (absolute-js ["/js/prettify.js"
               "/js/lang-clj.js"
               (:js site ())])]
; /body
