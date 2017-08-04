---
title: Project Roundup
date: 2017-08-01
tags: projects
---

Ok, so my last post was all about what I was gonna do this year. The #1 thing on there was blog more! Jeez, what's with this guy? He sucks.  

Instead of trying to get all deep about something, I'm thinking it's a good idea to just get something out about a few of the projects I worked on in the last 7 months.  

## All the Things

1. [Atari 7800 UAV Installation](#a7800)
1. [Zenith TV Interface](#zenith-tv)
1. [Musicbot for Hangouts](#musicbot)
1. [Trello-concert-tracker](#trello-track)
1. [ice-rom](#ice-rom)
1. [Open Source Scan Converter](#ossc)
1. [Steambot](#steambot)
1. [Google Play Music Desktop Player feature](#gpmdp)
1. [Standup bot feature and web frontend](#standup)

### <a name="a7800"></a>Atari 7800 UAV Installation

This is my most recently completed project. "Complete" is a fairly subjective word though, as the likelihood that I pop the top on my [Atari 7800] again soon is fairly high. The point of this project was to install the [Atari UAV board] inside my 7800 in order to get a much better video signal out of it.

The Atari 7800 only had one type of video out supported, [ye olde radio frequency modulator]. You may remember the old box deal you'd screw into your TV's coaxial connector from the NES. The 7800 has the same except the box is integrated into the console itself. This is, in fact, the worst consumer standard for video (and audio) output. It combines all the signals into a single crappy signal that is then adjusted (magically) to appear on channel 3 of your old-ass television. Needless to say, this didn't look great on a modern digital television. It really never looked good on older analog TVs either, but our expectations have changed since the 80s. 

Bryan on the [AtariAge] forum sells a kit he's designed to tap into the mainboard of various Atari console and computers, and skip the RF interface altogether, giving you a nice S-Video and/or composite video signal. Pretty boss. The [forum post] has lots of images to gawk at. I was after the s-video signal, myself. 

There really wasn't that much to the installation of the board itself. I decided to pull out the RF adapter altogether, and place the board in its location. The main thing I had any issues with were all mechanical. For whatever reason, mechanical stuff is just not my forte. When I was ready to install the sucker, I realized it didn't come with any of the mechanical parts, like the s-video plug or the rca jacks, so I had to order those from mouser. Once I received them, I went to work figuring out where I wanted the plugs located. After that, I just started drilling on the case, because I'm a dumbass. One mistake I made was not giving adequate spacing between the RCA jacks, so the audio left + right jacks are too close together and it's a real squeeze to get both plugs in. Also, the jacks are low enough on the slope of the case that it's an issue to have them plugged in and not propping up the entire case like a bike kickstand. Also, I tried to eyeball the placement for the center of the s-video jack drill-out, and I was way off. I ended up needing to use a dremel to fix it, and it came out alright.

The last little thing was that the audio lines don't go through the board, and instead are just tapped from the mainboard and are expected to go to a 10uF capacitor before the jacks. I didn't order that, but luckily I had some on-hand from my now-ancient toolbox from my ECE undergrad degree.

Overall, I'd give myself like a 2/5 for planning, but everything worked out ok in the end, as I have the sharpest 7800 pixels you've ever seen. You could cut yourself on them. They're gonna look even more awesome once I receive my Panasonic BT-M1390Y. Here's some screenshots from my LCD, for now. I didn't grab any "before" shots (see? more proof of poor planning), so here's a couple I found online.

<img src="/img/rf-composite-comparison.jpg" style="width: 75%; display: block; margin-left: auto; margin-right: auto"/>

<img src="/img/rf-svideo-comparison.jpg" style="width: 75%; display: block; margin-left: auto; margin-right: auto"/>

[Atari 7800]: https://en.wikipedia.org/wiki/Atari_7800
[Atari UAV Board]:  http://atariage.com/forums/topic/246613-new-video-upgrade-coming-soon/
[ye olde radio frequency modulator]: https://en.wikipedia.org/wiki/RF_modulator
[AtariAge]: http://atariage.com/
[forum post]:  http://atariage.com/forums/topic/246613-new-video-upgrade-coming-soon/

### <a name="zenith-tv"></a>Zenith TV Interface

Back in December, my buddy Epitrope moved to NY, and was trying to get rid of the things he wasn't going to transport across the entire US. One of these things was an older 720p Zenith TV. He is a hacker extraordinaire, and after doing a bit of looking at the manual, saw that the protocol for the serial interface on the back is documented. He created a set of programs to communicate with this port to do some TV automation, which I thought was really cool. I decided I wanted to use the same thing, with the host program running on an old Raspi I had laying around instead of using a full computer like he did. 

Epitrope architected the program really well, using a separate client/server interface, with the client written in python and the server written in C. It also uses protobufs to have the protocol defined separately from the programs, and uses zeromq to encapsulate commands between the two. I knew very little about protobufs + zeromq as I went forward trying to "port" this program to Raspi, and ran into a handful of different issues. 

The first issue I ran into was that the github repo Epitrope set up didn't have full build instructions, including the dependencies for C and python that are necessary to run. As I discovered which packages supplied the right dependencies, I [put together some docs and fixed up the Makefile] to handle more steps, such as compiling the protobufs.

There were a few interesting gotchas during this process. There are multiple bindings for zeromq, depending on version. Using the wrong one doesn't work, obviously.
Also, the system package in ubuntu for protobuf compiling doesn't include the compiler for C, but does include the one for Python, so you need to install two separate dependencies.

I then had to deal with the fact that the serial port used was hardcoded, and didn't match the FTDI usb->serial device I was using on the Raspi. [This was a fairly small change]. 

The next commit took the most research. Even though everything seemed to be wired together properly, I was getting corrupted data and commands weren't working. After fixing some of the debug output to display properly, it started to become clear that I was only getting partial data. There responses were supposed to be 14 bytes, but instead I was only getting the first 8. I finally figured out that the serial reads from the Raspi would only read 8 bytes at a time, so [you need to do multiple reads to get all the data]. Epitrope's hardware apparently returned all 14 bytes at once, and so never ran into this problem.

The last thing I did was to add a new TV command to do something you can't do with the remote, "screen mute". This effectively turns off the screen, but leaves the sound still being output. My wife likes to go to sleep with the TV on, but really the thing she's interested in is the sound, so I thought adding this feature would actually make this program useful to me. [The code for this] was very regular, and fit patterns put in place by Epitrope for the other commands. It did require extending the protocol buffer definition, and there was quite a bit of boilerplate.

I have aspirations of rewriting the entire thing in Rust, as I feel that Rust lends itself to system code, but also for web code. The ultimate goal would be to have a RESTful API to control the TV, and perhaps even a small web frontend you could pull up on your phone, but I really haven't gotten very far in learning Rust this year, like I hoped I would. I still hope to come back to this sometime.

Overall, I had fun with this little port project. I learned about zeromq a bit, and protobufs, and learned you can't always assume even small reads will complete in a single read. It was also the first C project I'd worked on in years, so it felt kinda nice to be back at home with that, even if it was only for a few days.

[put together some docs and fixed up the Makefile]: https://github.com/rattboi/zenith-tv-serial/commit/6d55dd78664e24c13090c85167b9c7960794f8f3
[This was a fairly small change]: https://github.com/rattboi/zenith-tv-serial/commit/b2ab6cf4d162f935b275574b22bfd74a6c56df32
[you need to do multiple reads to get all the data]: https://github.com/rattboi/zenith-tv-serial/commit/867e0e3f9b15843196e2189947adda2a3f033d0d
[The code for this]: https://github.com/rattboi/zenith-tv-serial/commit/307ec2000400871e7d0f7cff46b73a4186f038ef

### <a name="musicbot"></a>Musicbot for Hangouts

Content Content Content!
Content Content Content!
Content Content Content!
Content Content Content!
Content Content Content!
Content Content Content!
Content Content Content!

### <a name="trello-track"></a>Trello Concert Tracker

Content Content Content!
Content Content Content!
Content Content Content!
Content Content Content!
Content Content Content!
Content Content Content!
Content Content Content!

### <a name="ice-rom"></a>iCE-ROM

Content Content Content!
Content Content Content!
Content Content Content!
Content Content Content!
Content Content Content!
Content Content Content!
Content Content Content!

### <a name="ossc"></a>Open Source Scan Converter

Content Content Content!
Content Content Content!
Content Content Content!
Content Content Content!
Content Content Content!
Content Content Content!
Content Content Content!

### <a name="steambot"></a>Steambot

Content Content Content!
Content Content Content!
Content Content Content!
Content Content Content!
Content Content Content!
Content Content Content!
Content Content Content!

### <a name="gpmdp"></a>Google Play Music Desktop Player feature

Content Content Content!
Content Content Content!
Content Content Content!
Content Content Content!
Content Content Content!
Content Content Content!
Content Content Content!

### <a name="standup"></a>Standup bot feature and web frontend

Content Content Content!
Content Content Content!
Content Content Content!
Content Content Content!
Content Content Content!
Content Content Content!
Content Content Content!
