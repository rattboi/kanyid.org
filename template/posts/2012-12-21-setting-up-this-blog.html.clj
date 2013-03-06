; @layout  post
; @title  Setting up this blog
; @tag    clojure webdev

(h2 "Introduction")

(p "Ok, so my name is Bradon Kanyid, and I'm a Senior Computer Engineering student at " (link "Portland State University" "http://pdx.edu") " in the " (link "Maseeh College of Engineering and Computer Science") ". I have a lot of interests, mostly computer-related. At the end of fall quarter, I decided that it would be useful to start documenting projects and things I enjoy somewhere online.")

(h2 "Where to start?")

(p "So I decided to make this blog, but definitely have not a lot of prior webdev experience. I've made little internal pages for work and such, but never really looking into hosting, domain registration, frameworks, and the like. I started asking around with my fellow students and " (link "CAT members" "http://cat.pdx.edu") ", and decided the best thing for me would be to get a VPS, domain name, and static HTML framework. ")

(h2 "Virtual Private Server")

(p "A friend at school had been talking up " (link "BuyVM" "http://buyvm.net") " as a VPS solution, mainly because the price is so awesome. For $15/year, I could have an " (link "OpenVZ") " VM sitting on the Internet that I have root on. The main restriction of the $15 VM is that it is limited to only 128MB of RAM, 'burstable' to 256MB for short times. The BuyVM availability is also limited. When I first attempted to purchase a VM, their website said that they were \"sold out\". Apparently, it's common for VPS providers to over-provision. That is, even though each customer is supposed to have a guaranteed amount of memory (in my case, 128MB/256MB), the VPS provider has less RAM than the sum of the customers' guarantees. BuyVM doesn't over-provision, so they make sure they have the resources before selling more VMs. Luckily, I only needed to wait a day for more VMs to become available. Once my VM was purchased, I had to decide on a few things, including which distribution to use. Initially, I thought I would use " (link  "Arch Linux" "https://archlinux.org") ", as this is the distro I use on my personal computers. However, it quickly became apparent that Arch Linux was not a viable choice with the pre-packaged version they offer for OpenVZ. It was built circa 2010, and Arch's " (link  "rolling-release model" "https://en.wikipedia.org/wiki/Rolling_release") " doesn't really lend itself to old installs. Since Arch was out, I had the option of either CentOS, Debian, or Ubuntu. I am more familiar with Debian-based distros, so it was really down to Ubuntu or Debian. I had never used Debian before, but was hearing good things about it from the same friend who recommended that I look into BuyVM, so I figured that if I ran into any problems with BuyVM + Debian, I'd have a friend who could help." )

(h2 "Domain Name Registration")

(p "")

(h2 "Web Framework")

(p "")
