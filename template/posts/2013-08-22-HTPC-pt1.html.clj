; @layout post
; @title  HTPC Build - Part 1: Hardware
; @tag    htpc hardware

(defn part [type name url price]
  (list (str type ": ") (link name url) (str " - " price)))

(defn part-title [type name url price]
  (list (h4 type) (p (link name url) (str " - " price))))

(p "I'm finishing up my yearly stint here in Craig, AK, and I thought it might be a good time to actually build that HTPC that I've been dreaming about for the last 3-4 years. For those unfamiliar with HTPCs, the basic idea is to have an all-in-one computer that is good for all media duties that you may have relating to your television. In my case, that means being able to watch movies and TV shows from many sources, including Netflix and Hulu (because I don't have cable), as well as being able to play videogames, both old and new. As I said above, this has been a dream of mine for a few years, and after seeing Sauerkrause's build, I felt the need to finally put my hard-earned money down. ")

(h2 "Motivation")
  (p "As I was going to school, my apartment slowly succumbed to the bachelor lifestyle. It didn't take too long until I moved my computer desk and desktop computer out into the living room next to the TV. I've been using my computer as a dual-monitor setup, with my normal monitor on my desk, and my TV acting as a secondary. This works fairly well, but can be strange at times. Navigating the desktop feels weird when either display is off, and AwesomeWM leaves a bit to be desired for dual-screen use (this could probably be configured better, but I haven't spent a lot of time on it). Also, I've had a lot of problems trying to get vertical syncing working correctly between the two displays, as they are running at different refresh rates. For the use of playing the occasional movie or tv show, this has worked mostly pretty good. However, as my desktop is a Linux-only system that I run a few services from, watching Netflix and Hulu becomes difficult, and playing any modern games is an exercise in futility.")

(h2 "Solution")
  (p "Hence, the right solution for the job is to build a small computer with enough horsepower to play modern games, and also being capable of running Netflix and Hulu. For these requirements, it seems very likely that Windows becomes the only option for operating system. I don't hate Windows, but I also like to see what can be done with Linux, and I'm more comfortable in the Linux environment after the last few years. With Steam now coming to Linux, I should slowly be able to play modern games as they become available. That may be idealistic, but I do consider myself an idealist. That being said, no amount of idealism is going to allow me to run Skyrim in Linux today. Also, there is still no acceptable way to use Netflix within Linux. All the solutions use Wine and are browser-based. Browser-based solutions mean that a mouse is required to use the system, which is against my main goals. The default answer to this problem is to use Windows exclusively or to dual-boot between Linux and Windows. Dual-booting is not an option for me. It totally breaks the experience, and pulls you out of the consumer experience I'm attempting. So the only option is to use Windows exclusively, right? Well, not quite.")

(h2 "PCI Passthrough")
  (p "Last year, I first read about PCI Passthrough, a virtualization technique in which you dedicate some PCI devices directly to a guest Virtual Machine (I will now refer to these as VMs). This allows the guest VM to use the device natively, without any translation cost between the host OS and guest VM. My use case for this would be to allow the host OS to use integrated graphics, while the guest VM uses a discrete GPU on the PCI-E bus. In short, this should allow me to use Linux as my host OS, running most of my media and games from within that environment, while also allowing a Windows VM to run without taking the heavy performance penalty that is usually inherent to virtualized environments. I'll be writing more about this in a future post, but wanted to mention it because it affected a lot of my hardware choices.")

(h1 "Major Components")
  (h2 "Overview")
    (ul (list (part "CPU" 
                    "Intel Core i5-4570S 2.9GHz Quad-Core Processor" 
                    "http://www.newegg.com/Product/Product.aspx?Item=N82E16819116897"
                    "$200")
              (part "Motherboard" 
                    "Gigabyte GA-Z87N-WIFI Mini ITX LGA1150 Motherboard" 
                    "http://www.newegg.com/Product/Product.aspx?Item=N82E16813128615"
                    "$135")
              (part "Memory" 
                    "Corsair Vengeance 8GB (2 x 4GB) DDR3-1600 Memory" 
                    "http://www.newegg.com/Product/Product.aspx?Item=N82E16820233144"
                    "$74")
              (part "Storage" 
                    "Intel 520 Series Cherryville 180GB 2.5\" Solid State Disk"
                    "http://www.newegg.com/Product/Product.aspx?Item=N82E16820167115"
                    "$205")
              (part "Video Card" 
                    "HIS Radeon HD 7850 2GB Video Card" 
                    "http://www.newegg.com/Product/Product.aspx?Item=N82E16814161406"
                    "$140")
              (part "Case" 
                    "Fractal Design Node 304 Mini ITX Tower Case" 
                    "http://www.newegg.com/Product/Product.aspx?Item=N82E16811352027"
                    "$55")
              (part "Power Supply" 
                    "Corsair CX 430W 80 PLUS Bronze Certified ATX12V Power Supply" 
                    "http://www.newegg.com/Product/Product.aspx?Item=N82E16817139049"
                    "$50")))

  (h2 "Details")
    (part-title "CPU"
                "Intel Core i5-4570S 2.9GHz Quad-Core Processor"
                "http://www.newegg.com/Product/Product.aspx?Item=N82E16819116897"
                "$200")
      (p "For selection of CPU, I've only ever dealt with Intel, so I wanted to stick with what I know there. I want to something with at least 4 cores and Haswell, and Core i7 seems overkill for my use. I commonly see that people buy the K version of Core i5/i7 CPUs, which have the unlocked multipliers, allowing easy overclocking. I want to point out that for the PCI passthrough technique to work, you must have a CPU with VT-d support (also called IOMMU), which only the non-K CPUs support. Because I'm trying to keep heat down, I've decided to get the S version, which requires less wattage, but also reduces the CPU clock speed. It is also currently $40 cheaper than the standard i5 4670.")

    (part-title "Motherboard"
                "Gigabyte GA-Z87N-WIFI Mini ITX LGA1150 Motherboard"
                "http://www.newegg.com/Product/Product.aspx?Item=N82E16813128615"
                "$135")
      (p "The choices for motherboard are currently very limited, as I want something in the mini-itx form factor that also supports Haswell processors. Other than supporting my processor, I didn't have really specific requirements, but Sauerkrause was already having success with the GA-Z87N-WIFI, so I've decided that this will be my default unless I find something better when I place the order. One reassuring thing about this board is that it has VT-d options in the EFI settings, which means it will help keep me compatible for PCI passthrough. Also, it has a very good selection of I/O on the back, such as dual HDMI out from the integrated graphics on my CPU, and dual LAN, which opens up the possibility of also using the box as a router. There is also integrated wifi, in case you need it, as well as Bluetooth, which should be useful for videogame controllers and such.")

    (part-title "Memory"
                "Corsair Vengeance 8GB (2 x 4GB) DDR3-1600 Memory"
                "http://www.newegg.com/Product/Product.aspx?Item=N82E16820233144"
                "$74")
      (p "I don't have much to say about RAM except that I've selected the cheapest DDR3-1600 that I could find that also ran at 1.5V. Initially, I was thinking of getting 4GB of RAM, with an option to upgrade later. To do this, I was going to get 1x4GB of RAM, but a friend pointed out that I lose out on dual-channel that way. I then decided to do 2x2GB of RAM for about $35. Since I've decided to pursue the PCI passthrough VM method, I've realized 4GB isn't enough to run a host OS and a gaming Windows VM, so I'm increasing it to 2x4GB. 4GB of RAM for each OS should be plenty in most cases, and I can easily change the split at any time to 2/6GB between Linux/Windows, or 8/0GB when I'm not using the VM.")

    (part-title "Storage"
                "Intel 520 Series Cherryville 180GB 2.5\" Solid State Disk"
                "http://www.newegg.com/Product/Product.aspx?Item=N82E16820167115"
                "$205")
      (p "This part is easy. I want my HTPC to be fast and quiet. SSD gives me that, at least on the storage side. I've decided that 180GB should be enough to facilitate the size of newer video games. If I learned anything from ECE485 (Computer Architecture), it's that harddrive access speed is literally many orders of magnitude slower than the next slowest component in the memory hierarchy. Anything to reduce the effect of this bottleneck is going to be felt across the entire system (assuming your process is I/O bound, which gaming certainly is during load times). I've been using SSDs for both my other computers for the last few years, so I think it'd be pretty hard to go back to spinning rust for anything other than media storage.")

    (part-title "Video Card"
                "HIS Radeon HD 7850 2GB Video Card" 
                "http://www.newegg.com/Product/Product.aspx?Item=N82E16814161406"
                "$140")
      (p "Ok, now we're getting into the nitty-gritty. I haven't looked at new graphics cards in years, so I'm starting from square one while researching these. I'm using Sauerkrause's nVidia GeForce GTX 660 as a starting point, and decided I probably don't need quite as much horsepower as he has. The 650s are about $50 cheaper, so I looked into those for a bit. Then I saw that the 650 Ti is quite a bit better for almost the same price, then the 650 Ti Boost. Initially I was only looking at nVidia because they have a better reputation for Linux compatibility than AMD. However, that all changed when I decided to go after the magical PCI passthrough. Since this card will only be seen by the Windows guest VM, I don't need to worry about Linux compatibility (which actually has been getting better, I've heard). Also, in my research of PCI passthrough, I've seen that in general, there is much higher levels of success with AMD cards. In fact, nVidia only supports PCI passthrough, it seems, if you are using their high-end Quadro cards, or are faking one by modifying your card. At this point, I'm looking at the AMD Radeon HD 7850s because they are the right amount of power for the right price. If I do see a 7870 on sale, however, I could quickly change my mind.")

    (part-title "Case"
                "Fractal Design Node 304 Mini ITX Tower Case" 
                "http://www.newegg.com/Product/Product.aspx?Item=N82E16811352027"
                "$55")
      (p "The case is really one of the most important parts that you need to select for an HTPC. When I started researching my HTPC, I was going for the smallest possible case I could find that would house all my components. I really like Sauerkrause's SilverStone Sugo SG08, but at $200, that seemed like one of the most likely components I could save on. For a while, my choice was the Silverstone SST-SG05BB-450-USB3.0 (Black) at $125 for the case + power supply. Later, I realized I could buy the same case and PSU individually, and actually save $25 that way. I really like that case, and it is smaller even than the SG08. However, it has two problems. The first issue is that it only works with a smaller form factor power supply, and the options for those are really limited. The second issue is that the PSU is installed right above the motherboard, which means that you have very limited room between the top of your CPU and the bottom of the PSU. I'm wary of thermal issues with so much hardware so close together, so I'd like the option to use better CPU coolers if necessary. This isn't possible with the SG05. As much as it pained me, I decided on another really great case that is 1\" larger in each direction than the SG08. The extra space allows the PSU to be placed at the front of the case, with the motherboard sitting behind it. This leaves all the space above the motherboard open. After doing some more research, I really think this is a good case, especially for the screaming deal of $55. There's a large 140MM fan on the back for exhaust, and two 92mm fans in the front for intake, as well as side vents for the PCI-E card and the PSU. There are dust filters on the front intake fans, and the bottom intake fan for the PSU, which are removable for cleaning. It is black, and clean as can be. The front is totally bare except a power LED, and there are a few side connectors for USB 3.0. There is no place for a DVD or Bluray drive in this case, but luckily I don't use either of those ever, so it's not an issue. In the rare case that I only have software available on DVD, I do have a portable slim DVD burner that will work.")

      (p "On a side note, another project I'd like to work on would be a NAS build, and there's a good chance I'd use this case for that project as well. Beyond the other features I've mentioned, there's actually room for up to 6 3.5\" SATA drives inside. Also, the NAS may lend itself better to also being a router, as mentioned above. I think this would work really well for something like a FreeNAS setup, which I will be investigating in the coming months.")

    (part-title " Power Supply"
                "Corsair CX 430W 80 PLUS Bronze Certified ATX12V Power Supply" 
                "http://www.newegg.com/Product/Product.aspx?Item=N82E16817139049"
                "$50")
      (p "I've gone through about 5 power supply selections so far, but I think I've found the one, finally. Initially, when I was planning to use the SG05 case, I was looking at a 450 Watt SFX power supply, but after I switched to the Fractal Design Node 304, I initially was looking at a nice 600 Watt power supply. Then I realized I could probably lower the wattage and also save money. Then, I started thinking about airflow, and all the excess cables that would be in a normal non-modular PSU, so I started looking at modular PSUs. The cheapest modular I've found is the Raidmax RX-530SS, at $40. The Raidmax says it's capable of 530 watts, but looking at the individual specs, it only supplies 20A to the +12V rail. From some reading I've done, the +12V rail of the PSU is very important for the graphics card. I've decided I will pay an extra $10 for a Corsair 430 watt power supply, because even though it is 100 less watts overall, it can supply 32A on its +12V rail. Corsair is known to be a good power supply manufacturer, and I've never heard of Raidmax. Lastly, the Corsair is modular all the way up to the casing, and the Raidmax instead had a bunch of short cables that you would add extensions to. I prefer the cleanliness of the casing ports.")

(h2 "Closing Notes")
  (p "There are a few things that I found noteworthy that didn't fit exactly in the above. One thing that could have easily messed me up is that some larger wattage power supplies are physically longer, especially the modular PSUs, and that could have easily obstructed the video card. Luckily, the Corsair 430W is short enough that this isn't going to be a problem. Another note and major annoyance is that video card manufacturers don't seem to post specific power requirements for their cards. Instead, they make very conservative shots in the dark, and try to guess your power requirements only based on the video card. The specifications for the HIS Radeon HD 7850 stated \"Use at least a 500W PSU with our card\", which assumes so much about the rest of the system. I'm hazarding using a 430 watt power supply because I did some research on the 7850's GPU and found that it only pulls about 100 watts itself. With my SSD, Mini-ITX motherboard, and low-power Core i5, I'm sitting at around 280-300 watts, according to the research I have done.")

(h2 "Conclusion")
  (p "So yeah, there's what I have so far. I expect that there are things that I forgot or left out, so if you see anything, please leave me a note below. My next HTPC post will be about the software setup I expect, and some of the integration ideas I'm going to try. I will discuss some about Arch Linux, LVM, Xen hypervisor, PCI passthrough, VT-d, and maybe even stuff about XBMC, Netflix, and Steam. See you then")
