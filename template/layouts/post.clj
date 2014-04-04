; @layout  default
; @title   post default title

;; ///// FUNCTIONS //////
  
(defn disqus [username]
 [:div {:id "disqus_thread"}
  [:script {:type "text/javascript"}
           "(function() {
                var dsq = document.createElement('script'); dsq.type = 'text/javascript'; dsq.async = true;
                dsq.src = '//"  username ".disqus.com/embed.js';
                (document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(dsq);
            })();"]
  [:noscript "Please enable JavaScript to view the " (link "comments powered by Disqus." "//disqus.com/?ref_noscript")]])

;; ///// TEMPLATE //////

[:article 
 ;; previous/next post
 ;; (prev-next-post-link)

 [:div {:class "post"}
   ; page header
   (post-header :h1 (:title site))

   ; contents
   contents] 
 
 ; previous/next post
 (prev-next-post-link)

 (disqus "bradonkanyidsblog")]
