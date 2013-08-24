; @layout post
; @title  HTPC Build - Part 1: Hardware
; @tag    htpc hardware

(defn part [type name url price]
  (list (str type ": ") (link name url) (str " - " price)))

(defn part-title [type name url price]
  (list (h4 type) (p (link name url) (str " - " price))))

(p "I'm finishing up my yearly summer stint here in " (link "Craig, AK" "http://en.wikipedia.org/wiki/Craig,_Alaska") ", and I thought it might be a good time to actually build that " (link "Home Theater PC" "http://en.wikipedia.org/wiki/Home_theater_PC") " that I've been dreaming about for the last 3-4 years. For those unfamiliar with HTPCs, the basic idea is to have an all-in-one computer that is good for all media duties that you may have relating to your television. In my case, that means being able to watch movies and TV shows from many sources, including " (link "Netflix" "http://www.netflix.com") " and " (link "Hulu" "http://www.hulu.com") " (because I don't have cable), as well as being able to play videogames, both " (link "old" "https://en.wikipedia.org/wiki/List_of_video_game_emulators") " and " (link "new" "http://www.tombraider2013.com/") ". As I said above, this has been a dream of mine for a few years, and after seeing " (link "Sauerkrause's build" "http://random-sequential.blogspot.com/2013/08/gaminghtpc-build-hardware.html") ", I felt the need to finally spend some of my hard-earned money and commit to the project.")

(h2 "Motivation")
  (p "While I was in school, my apartment slowly succumbed to the bachelor lifestyle. It didn't take too long until I moved my desktop computer out into the living room next to the TV. I've been using a dual-monitor setup, with my normal monitor on my desk and my TV acting as a secondary. This works fairly well, but leaves something to be desired. Navigating the desktop feels strange when either display is off, and " (link "AwesomeWM" "http://awesome.naquadah.org/") " leaves a bit to be desired for dual-screen use (I could probably configure this better, but I haven't spent a lot of time on it). Also, I've had a lot of problems trying to get vertical syncing working correctly between the two displays, as they are running at different refresh rates. For playing the occasional movie or tv show, this has worked pretty well. However, as my desktop is a Linux-only system that I run a few always-up services on, watching Netflix and Hulu becomes difficult, and playing modern games is an exercise in futility.")

(h2 "Solution")
  (p "My solution to this problem is to build a small computer with enough horsepower to play modern games, while also being capable of running Netflix and Hulu, as well as playing local media through XBMC. To meet these requirements, it seems that Windows becomes the only option for operating system. I don't hate Windows, but I also like to see what can be done with Linux, and I'm very comfortable in the Linux environment after the last 5 years. With " (link "Steam releasing a client for Linux" "http://store.steampowered.com/browse/linux/") ", I should slowly be able to play modern games as they become available. That may be idealistic, but I do consider myself an idealist. That being said, no amount of idealism is going to allow me to run Crysis 3 in Linux today. Also, there is still no acceptable way to use Netflix within Linux. All the solutions use Wine and are browser-based. Browser-based solutions mean that a mouse is required to use the system, which does not meet my minimum requirements. The default answer to this problem is to use Windows exclusively or to dual-boot between Linux and Windows, because Windows supports a " (link "Netflix plugin for Windows Media Center" "http://www.ehow.com/how_7682195_add-netflix-windows-media-center.html") ". Dual-booting is not an option for me. It totally breaks the user's experience. So the only option is to use Windows exclusively, right? Well, not quite.")

(h2 "PCI Passthrough")
  (p "Last year, I first read about " (link "PCI Passthrough" "http://wiki.xen.org/wiki/Xen_PCI_Passthrough") ", a virtualization technique in which you dedicate some PCI devices directly to a guest Virtual Machine (VM). This allows the VM to use the PCI device natively, without any translation overhead between the host OS and guest VM. My use case for this would be to allow the host OS to use an integrated graphics card, while the guest VM uses a discrete GPU on the PCI-E bus. In short, this should allow me to use Linux as my host OS, running most of my media and games from within that environment, while also allowing a Windows guest VM to run without taking the heavy performance penalty that is usually inherent to virtualized environments. " (link "Here's a good video demonstration." "http://youtu.be/Nz2c0Up2axk") "Note that he is within the Windows guest VM for the entirety of that video. I'll be writing more about this in a future post, but wanted to mention it because it affected a lot of my hardware choices.")

(h2 "Hardware Selection Methodology")
  (p "As with prior computer builds I've done in the past, I used " (link "PCPartPicker" "http://pcpartpicker.com") " for component selection. This site makes it very easy to manage parts and compatibility, while keeping an eye on your total cost. My saved configuration can be seen " (link "here" "http://pcpartpicker.com/user/rattboi/saved/2cDZ") " as well.")

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
              (p "Total: $859")  
  (h2 "Details")
    (part-title "CPU"
                "Intel Core i5-4570S 2.9GHz Quad-Core Processor"
                "http://www.newegg.com/Product/Product.aspx?Item=N82E16819116897"
                "$200")
      (p "For selection of CPU, I've only ever dealt with Intel, so I wanted to stick with what I know there. I want to have something with at least 4 cores and Haswell, and Core i7 seems overkill for my use. I commonly see that people buy the K version of Core i5/i7 CPUs, which have the unlocked multipliers, allowing easy overclocking. In order for the PCI passthrough technique mentioned above to work, the CPU must have an Input/Output Memory Unit (IOMMU). Intel's IOMMU technology is called " (link "VT-d" "http://www.linux-kvm.org/page/How_to_assign_devices_with_VT-d_in_KVM") ", and it is " (link "only present in the non-K CPUs" "http://www.pcper.com/news/Processors/Intel-Prevents-Overclocking-non-K-Haswell-Processors-and-Strips-Virtualization-and-T") ". Because I'm trying to keep heat down, I've decided to get the S version, which requires less wattage, but also reduces the CPU clock speed. It is also currently $40 cheaper than the standard i5 4670.")

    (part-title "Motherboard"
                "Gigabyte GA-Z87N-WIFI Mini ITX LGA1150 Motherboard"
                "http://www.newegg.com/Product/Product.aspx?Item=N82E16813128615"
                "$135")
      (p "The choices for motherboard are currently very limited, as I want something in the Mini-ITX form factor that also supports Haswell processors. Other than supporting my processor, I didn't have really specific requirements, but Sauerkrause was already having success with the GA-Z87N-WIFI, so I've decided that this will be my default unless I find something better when I place the order. One reassuring thing about this board is that it has VT-d options in the EFI settings, which will help keep PCI passthrough compatibility. Also, it has a very good selection of I/O on the back, including dual HDMI out from the integrated graphics on my CPU, and dual gigabit LAN, which opens up the possibility of also using the box as a router. There is also integrated WiFi, in case you need it, as well as Bluetooth, which should be useful for videogame controllers and such.")

    (part-title "Memory"
                "Corsair Vengeance 8GB (2 x 4GB) DDR3-1600 Memory"
                "http://www.newegg.com/Product/Product.aspx?Item=N82E16820233144"
                "$74")
      (p "I don't have much to say about RAM except that I've selected the cheapest DDR3-1600 that I could find that also ran at 1.5V. Initially, I was thinking of getting 4GB of RAM, with an option to upgrade later. To do this, I was going to get 1x4GB of RAM, but a friend pointed out that I lose out on " (link "dual-channel throughput" "https://en.wikipedia.org/wiki/Multi-channel_memory_architecture#Dual-channel_architecture") " that way. I then decided to do 2x2GB of RAM for about $35. Also, since I've decided to pursue the PCI passthrough VM method, I've realized that 4GB isn't enough to run both a host OS and a gaming Windows VM, so I'm increasing it to 2x4GB. 4GB of RAM for each OS should be plenty in most cases, and I can easily change the split at any time to 2/6GB between Linux/Windows, or 8/0GB when I'm not using the guest VM.")

    (part-title "Storage"
                "Intel 520 Series Cherryville 180GB 2.5\" Solid State Disk"
                "http://www.newegg.com/Product/Product.aspx?Item=N82E16820167115"
                "$205")
      (p "This part is easy. I want my HTPC to be fast and quiet. SSD gives me that, at least on the storage side. I've decided that 180GB should be enough to facilitate the size of newer video games. If I learned anything from ECE485 (Computer Architecture), it's that harddrive access speed is literally many orders of magnitude slower than the next slowest component in the memory hierarchy. Anything to reduce the effect of this bottleneck is going to be felt across the entire system (assuming your process is I/O bound, which gaming certainly is " (link "during load times" "http://www.tomshardware.com/reviews/battlefield-rift-ssd,3062-12.html") "). I've been using SSDs for both my other computers for the last few years, so I think it'd be pretty hard to go back to spinning rust for anything other than media storage.")

    (part-title "Video Card"
                "HIS Radeon HD 7850 2GB Video Card" 
                "http://www.newegg.com/Product/Product.aspx?Item=N82E16814161406"
                "$140")
      (p "Ok, now we're getting into the nitty-gritty. I haven't looked at new graphics cards in years, so I'm starting from square one while researching these. I'm using Sauerkrause's " (link "nVidia GeForce GTX 660" "http://www.newegg.com/Product/Product.aspx?Item=N82E16814125443") " as a starting point, and decided I probably don't need quite as much horsepower as he has. The 650s are about $50 cheaper, so I looked into those for a bit. I saw that the 650 Ti has quite a bit better performance for almost the same price, then saw the 650 Ti Boost has incrementally more horsepower for very little increased cost. Many of the quick comparisons I did between cards were facilitated through " (link "GPUBoss" "http://www.gpuboss.com") ". Initially I was only looking at nVidia because they have a " (link "longer history of good Linux compatibility than AMD" "http://hexus.net/tech/reviews/graphics/18017-ati-vs-nvidia-linux-showdown/") ". However, that all changed when I decided to go after the magical PCI passthrough fairy. Since this card will only be seen by the Windows VM, I don't need to worry about Linux-AMD compatibility (which actually has been getting better, I've heard). Also, in my research of PCI passthrough, I've seen that in general, there are much higher levels of success with AMD cards. In fact, nVidia only supports PCI passthrough, it seems, if you are using their " (link "high-end Quadro cards" "http://wiki.xen.org/wiki/Xen_VGA_Passthrough_Tested_Adapters#Nvidia_display_adapters") ", or are " (link "faking one by physically modifying your card" "http://www.eevblog.com/forum/chat/hacking-nvidia-cards-into-their-professional-counterparts/") ". All of this led me to AMD's Radeon HD 7850 because it is the right balance of performance and price. However, if I see a 7870 on sale, I could quickly change my mind.")

    (part-title "Case"
                "Fractal Design Node 304 Mini ITX Tower Case" 
                "http://www.newegg.com/Product/Product.aspx?Item=N82E16811352027"
                "$55")
      (p "The case is really one of the most important parts that you need to select for an HTPC. When I started researching my HTPC, I was going for the smallest possible case I could find that would house all my components. I really like Sauerkrause's " (link "SilverStone Sugo SG08" "http://www.newegg.com/Product/Product.aspx?Item=N82E16811163187") ", but at $200 for the case and PSU, this seems like one of the most likely components I could save on. For a while, my choice was the " (link "Silverstone SST-SG05BB-450-USB3.0 (Black)" "http://www.newegg.com/Product/Product.aspx?Item=N82E16811163208") " at $130 for the case + power supply. Later, I realized I could buy the " (link "same case" "http://www.newegg.com/Product/Product.aspx?Item=N82E16811163231&Tpk=sg05bb-lite") " and " (link "PSU" "http://www.newegg.com/Product/Product.aspx?Item=N82E16817256063") " individually, and actually save $25 that way. I really like that case, and it is smaller even than the SG08. However, it has two problems: The first issue is that it only works with a smaller form factor power supply, and the options for those are really limited. The second issue is that the PSU is installed right above the motherboard, which means that you have very limited room between the top of your CPU and the bottom of the PSU. I'm wary of thermal issues with so much hardware so close together, so I'd like the option to use a better CPU cooler if necessary. This isn't possible with the SG05. As much as it pains me, I've decided on the Fractal Design Node 304, which is 1\" larger in each direction than the SG08. The extra space allows the PSU to be placed at the front of the case, with the motherboard sitting behind it. This leaves all the space above the motherboard open. After doing some more research, I really think this is a good case, especially for the screaming deal of $55. There's a large 140MM fan on the back for exhaust, and two 92mm fans in the front for intake, as well as side vents for the PCI-E card and the PSU. There are dust filters on the front intake fans, and the bottom intake fan for the PSU, which are removable for cleaning. It is black, and clean as can be. The front is totally bare except a power LED, and there are a few side connectors for USB 3.0. There is a " (link "really good video about the case from Newegg" "https://www.youtube.com/watch?feature=player_embedded&v=gDJS5VvdDNY") ". You may notice that there is no place for a DVD or Bluray drive in this case, but luckily I don't use either of those regularly, so it's not an issue. In the rare case that I have software that is only available on DVD, I do have a portable slim DVD burner that will work.")

      (p "On a side note, another future project I'm considering is a NAS build, and there's a good chance I'd use this case for that project as well. Beyond the other features I've mentioned, there's actually room for up to 6 3.5\" SATA drives inside. Also, the NAS may lend itself better to also being a router, as mentioned above. I think this would work really well for something like a " (link "FreeNAS setup" "http://www.freenas.org/") ", which I will be investigating in the coming months.")

    (part-title " Power Supply"
                "Corsair CX 430W 80 PLUS Bronze Certified ATX12V Power Supply" 
                "http://www.newegg.com/Product/Product.aspx?Item=N82E16817139049"
                "$50")
      (p "I've gone through about 5 power supply selections so far, but I think I've found the one, finally. Initially, when I was planning to use the SG05 case, I was looking at a " (link "Silverstone 450 Watt SFX power supply" "http://www.newegg.com/Product/Product.aspx?Item=N82E16817256063") ", but after I switched to the Fractal Design Node 304, I initially was looking at a nice 600 Watt power supply. Then I realized I could probably lower the wattage and also save money. Then, I started thinking about airflow, and all the excess cables that would be in a normal non-modular PSU, so I started looking at " (link "modular PSUs" "https://en.wikipedia.org/wiki/Power_supply_unit_(computer)#Modular_power_supplies") ". The cheapest modular PSU I've found is the " (link "Raidmax RX-530SS, at $45" "http://www.newegg.com/Product/Product.aspx?Item=N82E16817152028") ". The Raidmax says it's capable of 530 watts, but looking at the individual specs, it only supplies 20A to the +12V rail. From " (link "some reading I've done" "http://www.newegg.com/product/CategoryIntelligenceArticle.aspx?articleId=199") ", the +12V rail of the PSU should supply at least 24A for a single enthusiast graphics card. I've decided I will pay an extra $10 for a Corsair 430 watt power supply, because even though it is 100 less watts overall, it can supply 32A on its +12V rail. Corsair is known to be a good power supply manufacturer, and I've never heard of Raidmax. Lastly, the Corsair is " (link "modular all the way up to the casing" "http://www.corsair.com/en/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/c/x/cxm430_500_600_backview.png") ", and the Raidmax instead has " (link "a bunch of short cables that you would add extensions to" "http://www.globalpc.co.nz/prodimages/PW09020.jpg") ". I prefer the cleanliness of the casing ports.")

(h2 "Closing Notes")
  (p "There are a few things that I found noteworthy that didn't fit exactly anywhere above. One thing that could have easily messed me up is that some larger wattage power supplies are physically longer, especially the modular PSUs, and that could have easily obstructed the video card. Luckily, the Corsair 430W is short enough that this isn't going to be a problem. Another major annoyance is that video card manufacturers don't seem to post specific power requirements for their cards. Instead, they make very conservative shots in the dark, and try to guess your power requirements only based on the video card. The specifications for the HIS Radeon HD 7850 stated " (link "\"500 Watt or greater power\"" "http://www.hisdigital.com/un/product2-698.shtml") ", which assumes a ridiculous amount about the rest of the system. I'm hazarding using a 430 watt power supply because I " (link "did some research using PSU Calculator" "http://extreme.outervision.com/psucalculatorlite.jsp") " with the 7850's GPU and found that it only pulls about 100 watts itself. Combined with my SSD, Mini-ITX motherboard, and low-power Core i5, I'm sitting at around 280-300 watts, which leaves me with quite a nice amount of overhead.")

(h2 "Conclusion")
  (p "So yeah, there's what I have so far. I expect that there are things that I forgot or left out, so if you see anything, please leave me a note below in the comments. My next HTPC post will be about my conceptual software setup, and some of the integration ideas I'm going to try. I will discuss some about Arch Linux, LVM, Xen hypervisor, PCI passthrough, VT-d, and maybe even stuff about XBMC, Netflix, and Steam. See you then.")
