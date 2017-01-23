---
title: Evil-mode (Part 1)
date: 2013-01-14
tags: 
- editors 
- clojure 
- evil-mode
---

I've been using [vim](http://www.vim.org/) for the last 4 years regularly as my text editor, and in many ways, vim has permiated all the other tools I use. In any application that I can, I will use vi/vim bindings if they are offered. I use vi-mode emulation in my terminal shell, [zsh](http://www.zsh.org/). I use a vim emulation layer in [Firefox](http://getfirefox.com/) called [Pentadactyl](http://5digits.org/pentadactyl/). I use a pdf reader called [mupdf](http://www.mupdf.com/) that has vim bindings, and the list goes on. Since learning the programming language [Clojure](http://clojure.org/), though, I've been interested in learning the text editor [emacs](http://www.gnu.org/s/emacs/), as there are a lot of Clojure tools designed around emacs. I still have no idea what I'm doing, nonetheless...

## Evil-mode is a thing!

[Evil-mode](http://emacswiki.org/emacs/Evil) is an installable addon for emacs that recreates the familiar (to me) environment and keybindings of vim, all while allowing the emacs thing at the same time. At this time, I really can't say much about the emacs thing, but I'm hoping that being able to start from something so familiar will allow me to have my cake and eat it too. Now, how about a little bit about installation.

## Installation

I'm going to assume you're coming from vim, like me, and have a fresh emacs install. As I understand it, starting at emacs version 24, a package management system is built in. This is called [packages.el](http://emacswiki.org/emacs/ELPA). Unfortunately, the default package repository that comes with emacs is very limited, and doesn't offer the evil-mode package. On first run of emacs, it will create a directory called .emacs.d in your homedir. Adding the following lines to ~/.emacs.d/init.el (which you will need to create) will add the 'marmalade' repository, which offers many more packages.

<!-- more -->

```lisp
(require 'package)
(add-to-list 'package-archives
             '("marmalade" . "http://marmalade-repo.org/packages/"))
(package-initialize)
```

Now re-open emacs, and type the following:

```
M-x package-list-packages
```

Note that 'M-x' means 'hold the alt key and press the x key'. A new buffer will open showing all the available packages.

Search for evil by typing the following:

```
C-s evil
```

Packages.el's interface seems a little goofy to me, but the 15-second guide is as follows: pressing 'i' next to a package name will queue it for installation, and pressing 'x' will execute your queue, installing those packages. So press 'i' next to evil, then press 'x'. When prompted to install evil, type 'yes'. Emacs will fetch and compile evil-mode from marmalade's repository. When it's finished, you will see that it says 'Done' in the status line at the bottom.

At this point, quit emacs again, and we'll add the evil-mode initialization to '~/.emacs.d/init.el', below the package init code we added earlier.

```lisp
(require 'evil)
(evil-mode 1)
```

Alright, all the initialization should be done at this point. Start emacs. You're in evil-mode!

## Using evil-mode

You should see that most, if not all, of your favorite vim bindings are immediately available. Try navigating the initial buffer with hjkl keys. Press i to enter Insert mode. The basic Command-mode commands work as well. :e for edit, :w for writing out, :q to quit. I haven't fully experimented with evil-mode yet, so I'm still unclear where the line is drawn between what evil-mode supports and what it doesn't. I'm also unclear how you are supposed to access emacs' default functionality.

## Conclusion

I hope that you've learned a bit about getting started with emacs and evil-mode. Look for future posts here, as I progress in learning evil-mode and emacs.
