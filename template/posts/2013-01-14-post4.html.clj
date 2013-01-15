; @layout post
; @title  Evil-mode (Part 1)
; @tag    editors clojure evil-mode

(p "I've been using vim for the last 3-4 years regularly as my main editor, and in all things. Any application that I can, I will use vi/vim bindings if they are offered. I use vi-mode emulation in my terminal shell, zsh. I use a vim emulation layer in Firefox called Pentadactyl. I use a pdf reader called mupdf that has vim bindings, and the list goes on. Since learning Clojure, though, I've been interested in using emacs, as there is a lot of support for Clojure tools. I still have no idea what I'm doing, nonetheless...")

(h2 "Evil-mode is a thing!")

(p (link "Evil-mode" "http://emacswiki.org/emacs/Evil") " is an installable submode of emacs that gives you your vim keybindings and familiar environment, all while allowing you to do the emacs thing at the same time. At this time, I really can't say much about doing the emacs thing, but I'm hoping that being able to start from something familiar will help me build my repertoire. Now for a little bit about installation.")

(h2 "Installation")

(p "I'm going to assume you're coming from vim and have just installed a fresh emacs install. As I understand it, starting at version 24 of emacs, a package management system is built in. This is called " (link "packages.el" "http://emacswiki.org/emacs/ELPA") ". Unfortunately, the default repository that comes with emacs is very limited, and doesn't offer the evil-mode package. On first run of emacs, it will create a directory called .emacs.d in your homedir. Add the following lines to ~/.emacs.d/init.el.")
#-CODE
(require 'package)
(add-to-list 'package-archives
             '("marmalade" . "http://marmalade-repo.org/packages/"))
(package-initialize)
CODE

(p "Now re-open emacs, and type the following:")
#-CODE
M-x package-list-packages
CODE

(p "A new buffer will open showing all the available packages.")
(p "Search for evil by typing the following:")
#-CODE
C-s evil
CODE

(p "Packages.el's interface seems a little goofy to me, but the 15-second guide is pressing 'i' next to a package name will queue it for installation, and pressing 'x' will execute your queue. So press 'i' next to evil, then press 'x'. Type 'yes' when prompted if you want to install evil. Emacs will fetch and compile evil-mode from marmalade's repository. When it's finished, you will see that it says 'Done' in the status line at the bottom.")
(p "At this point, quit emacs again, and we'll add the evil-mode initialization to '~/.emacs.d/init.el', below the package init code we added earlier.")
#-CODE
(require 'evil)
(evil-mode 1)
CODE
(p "Alright, all the initialization should be done at this point. Start emacs. You're in evil-mode!")

(h2 "Using evil-mode")
(p "You should see that most of your favorite vim bindings are immediately available. Try navigating the initial buffer with hjkl keys. Press i to enter Insert mode. The basic Command-mode commands work as well. :e for edit, :w for writing out, :q to quit. I haven't fully experimented with evil-mode yet, so I'm still not clear how where the line is drawn between what evil-mode supports and what it doesn't. I'm also unclear how you are supposed to access emacs' default functionality.")

(h2 "Conclusion")
(p "I hope that you've learned a bit about getting started with emacs and evil-mode. Look for future posts here, as I progress in learning evil-mode and emacs.")
