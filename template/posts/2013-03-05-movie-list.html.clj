; @layout post
; @title  Movie List
; @tag    personal

(defn watched [movie]
 [:span {:style "text-decoration: line-through"} movie])

(defn movie [title]
  (list title " " (link "IMDB" (str "http://www.imdb.com/find?q=" title "&s=tt&ttype=ft&exact=true&ref_=fn_tt_ex"))))

(p "Well, this is my first more personal post on the site. It's just a short list of movies that I am planning to watch with a few friends from school.")

(ul (list (watched (movie "The Legend of Drunken Master"))
          (movie "Black Dynamite")
          (watched (movie "They Live"))
          (watched (movie "Seven Psychopaths")) 
          (movie "The Fall")
          (movie "Conspirators of Pleasure")
          (movie "Lock, Stock and Two Smoking Barrels")
          (movie "Snatch")
          (movie "Trainspotting")
          (movie "Oldboy") 
          (movie "Fear and Loathing in Las Vegas")
          (movie "Freddy Got Fingered")))
