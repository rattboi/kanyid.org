; @layout post
; @title  Movie List
; @tag    personal

(defn movie [title]
  (list title " " (link "IMDB" (str "http://www.imdb.com/find?q=" title "&s=tt&ttype=ft&exact=true&ref_=fn_tt_ex"))))

(p "Well, this is my first more personal post on the site. It's just a short list of movies that I am planning to watch with a few friends from school.")

(ul (list (movie "The Legend of Drunken Master")
          (movie "Black Dynamite")
          (movie "Seven Psychopaths")
          (movie "The Fall")
          (movie "Freddy Got Fingered")))
