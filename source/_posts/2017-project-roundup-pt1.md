---
title: Project Roundup Pt. 1
date: 2017-08-05
tags: projects
---

__Note: as I wrote this post, I realized I worked on a lot of projects! I decided to split this into a couple separate posts to make each more readable and get something out sooner rather than later.__

Ok, so my last post was all about what I was gonna do this year. The #1 thing on there was blog more! Jeez, what's with this guy? He sucks. 

Anyway, now that I just started a new position at [Standard Insurance], I again have a sizable commute. The nice thing about my commute is that it gives me around an hour every day to rededicate myself to self-improvement. These are my first steps in that endeavor.

Instead of trying to get all deep about something, I think it's a good idea to just get something out about a few of the projects I worked on in the last 7 months. I'm not sure if that's going to be interesting for anyone else, but it's good writing practice, and my memory isn't very good, so this lets me outline any importand details, which is useful to me.

[Standard Insurance]: https://www.standard.com/

## Project Overview

1. [Atari 7800 UAV Installation](#a7800)
1. [Zenith TV Interface](#zenith-tv)
1. [Musicbot for Hangouts](#musicbot)

### <a name="a7800"></a>Atari 7800 UAV Installation

This is my most recently completed project. "Complete" is a fairly subjective word though, as the likelihood that I pop the top on my [Atari 7800] again soon is fairly high. The point of this project was to install the [Atari UAV board] inside my 7800 in order to get a much better video signal out of it.

The Atari 7800 only supported one type of video output signal, [ye olde radio frequency modulator]. You may remember the box doohickey you'd screw into your TV's coaxial connector from the NES. The 7800 has the same thing, except the box is integrated into the console itself. This is, in fact, the worst consumer standard for video (and audio) output. It combines all the signals into a single crappy signal that is then adjusted (magically) to appear on channel 3 of your old-ass television. Needless to say, this doesn't look great on a modern digital television. It really never looked good on older analog TVs either, but our expectations have changed since the 80s. 

Bryan on the [AtariAge] forum sells a modification kit he's designed to tap into the mainboard of various Atari console and computers, and skip the RF interface altogether, giving you access to both a very nice S-Video as well as a less-nice-but-still-good composite video signal. Pretty boss. The [forum post] has lots of images to investigate. I was after the s-video signal, myself, as I have a Trinitron CRT Television that supports this signal type, and I'm about to procure a Panasonic BT-M1390Y Color Video Monitor, which also supports S-Video.

There really wasn't that much to the installation of the board itself. I decided to pull out the RF adapter altogether, and place the board in its location. The only things I had any issues with were mechanical in nature. For whatever reason, mechanical stuff is just not my forte. When I was ready to install this sucker, I realized it didn't come with any of the mechanical parts, like the s-video plug or the rca jacks, so I had to order them from an electronics compoenent distributor. Once I received them, I went to work figuring out where I wanted the plugs located. After that, I just started drilling on the case, because I'm an idiot. One mistake I made was not giving adequate spacing between the RCA jacks, so the audio left + right jacks are too close together and it's a real squeeze to get both plugs in. Also, the jacks are low enough on the slope of the case that it's an issue to have them plugged in and not propping up the entire case like a bike kickstand. Also, I tried to eyeball the placement for the center of the s-video jack drill-out, and I was way off. I ended up needing to use a dremel to fix it, which fortunately came out alright.

The last little thing was that the audio lines don't go through the video board, and instead are just tapped from the mainboard and are expected to go to a 10uF capacitor before the jacks. I didn't order that, but luckily I had some on-hand from my now-ancient ECE undergrad toolbox.

Overall, I'd give myself like a 2/5 for planning, but everything worked out OK in the end, as I have the sharpest 7800 pixels you've ever seen. You could cut yourself on them. They're gonna look even more awesome once I receive my Panasonic monitor. I didn't grab any "before" shots (see? more proof of poor planning), so here's a couple I found online. 

<img src="/img/rf-composite-comparison.jpg" style="width: 75%; display: block; margin-left: auto; margin-right: auto"/>

<img src="/img/rf-svideo-comparison.jpg" style="width: 75%; display: block; margin-left: auto; margin-right: auto"/>

[Atari 7800]: https://en.wikipedia.org/wiki/Atari_7800
[Atari UAV Board]:  http://atariage.com/forums/topic/246613-new-video-upgrade-coming-soon/
[ye olde radio frequency modulator]: https://en.wikipedia.org/wiki/RF_modulator
[AtariAge]: http://atariage.com/
[forum post]:  http://atariage.com/forums/topic/246613-new-video-upgrade-coming-soon/

### <a name="zenith-tv"></a>Zenith TV Interface

Back in December, my buddy Epitrope moved to NY, and was trying to get rid of the things he wasn't going to transport across the entire US. One of these things was an older 720p plasma Zenith TV. He is a hacker extraordinaire, and after doing a bit of looking at [the manual], saw that the protocol for the serial interface on the back is documented. He created a set of programs to communicate with this port to do some TV automation, which I thought was really cool. After doing him the favor of taking the TV off his hands (I'm all about altruism...), I decided I wanted to use the same thing, with the host program running on an old [Raspberry Pi 1] I had laying around instead of using a full computer like he did. 

Epitrope architected the program really well, using a separate client/server interface, with the client written in python and the server written in C. It also uses [protobufs] to have the protocol defined separately from the programs, and uses [zeromq] to encapsulate commands between the two. I knew very little about protobufs + zeromq as I went forward trying to "port" this program to Raspi, and ran into a handful of different issues. 

The first issue I ran into was that the github repo Epitrope set up didn't have full build instructions, including the dependencies for C and python that are necessary to run. As I discovered which packages supplied the right dependencies, I [put together some docs and fixed up the Makefile] to handle more steps, such as compiling the protobufs.

There were a few interesting gotchas during this process. There are multiple bindings for zeromq, depending on version. Using the wrong one doesn't work, obviously.
Also, the system package in Ubuntu for protobuf compiling doesn't include the compiler for C, but does include the one for Python, so you need to install two separate dependencies.

Then I had to deal with the fact that the serial port used in the original was hardcoded, and didn't match the FTDI USB-to-Serial device I was using on the Raspi. [This was a fairly small change]. 

The next commit took the most research. Even though everything seemed to be wired together properly, I was getting corrupted data and commands weren't working. After fixing some of the debug output to display properly, it started to become clear that I was only getting partial data. The responses were supposed to be 14 bytes, but instead I was only getting the first 8. I finally figured out that the serial reads from the Raspi would only read 8 bytes at a time, so [you need to do multiple reads to get all the data]. Epitrope's hardware apparently returned all 14 bytes at once, and so never ran into this problem.

The last thing I did was to add a new TV command to do something you can't do with the remote, "screen mute". This effectively turns off the screen, but leaves the sound still being output. My wife likes to fall asleep with the TV on, but really the thing she's interested in is the sound, so I thought adding this feature would actually make this program useful to me. [The code for this] was very regular, and fit patterns put in place by Epitrope for the other commands. It did require extending the protocol buffer definition, and there was quite a bit of boilerplate.

I have aspirations of rewriting both programs into a single [Rust] program, as I feel that Rust lends itself to system code, but also for web code. The ultimate goal would be to have a RESTful API to control the TV, and perhaps even a small web frontend you could pull up on your phone, but I really haven't gotten very far in learning Rust this year, like I hoped I would. I still hope to come back to this sometime.

Overall, I had fun with this little port project. I learned about zeromq and protobufs a bit, and learned you can't always assume even small serial reads will complete in a single read call. It was also the first C project I'd worked on in years, so it felt a little like going home to visit, even if it was only for a few days.

[the manual]: https://www.manualslib.com/manual/485866/Zenith-Z42p3.html?page=51
[Raspberry Pi 1]: https://www.raspberrypi.org/products/raspberry-pi-1-model-b/
[protobufs]: https://github.com/google/protobuf
[zeromq]: http://zeromq.org/
[put together some docs and fixed up the Makefile]: https://github.com/rattboi/zenith-tv-serial/commit/6d55dd78664e24c13090c85167b9c7960794f8f3
[This was a fairly small change]: https://github.com/rattboi/zenith-tv-serial/commit/b2ab6cf4d162f935b275574b22bfd74a6c56df32
[you need to do multiple reads to get all the data]: https://github.com/rattboi/zenith-tv-serial/commit/867e0e3f9b15843196e2189947adda2a3f033d0d
[The code for this]: https://github.com/rattboi/zenith-tv-serial/commit/307ec2000400871e7d0f7cff46b73a4186f038ef
[Rust]: https://www.rust-lang.org/en-US/

### <a name="musicbot"></a>Musicbot for Hangouts

This project has been a lot of fun. The point of it is to assist in conversations in a music-related Hangouts group chat. I'm not sure why everyone settled on Hangouts as the chat standard for our group, but people like it because the barrier to entry is so low. 

I'm used to IRC and having bots assist in the conversation, so I was a little bummed that everyone wanted to use Hangouts. After a bit of research, however, I found that there are actually a handful of bot frameworks for integration with Hangouts, all leveraging the [Hangups] python library. I looked over a few, and found one that had the feature-set I was looking for called [hangoutsbot]. This came with all the hooks to extend appropriately, as well as a [small ORM called peewee] to abstract out any database functionality. I believe peewee is the first ORM I've used in Python, and it has been fairly straightforward. I think I still prefer the feel of something like [hugsql] over ORMs in general, but peewee is painless.

I've added quite a few integrations at this point, to the following services:

- [Google Play Music]
- [Last.fm]
- [Setlist.fm]
- [Goo.gl Url Shortener]

To make this work, we decided as a group to standardize on these services. I guess it probably wouldn't be too hard to also integrate with something like libre.fm for listening habit tracking, but we definitely needed to standardize on a music streaming service, and GPM has the best deal. $15/mo gets you 6 users with a family account. I split the cost with my friend Noah, and we share user accounts to others. For this to work correctly, the musicbot actually needs to be its own user in GPM as well, so keep that in mind, as that eats an account on its own. Theoretically, you could share your personal account, but you may get some strange behavior, because the bot maintains shared playlists and a few other things.

A few cool things I've added that I'm pretty proud of are listed below. For a more in-depth overview of all the features, you can find them in the [project's readme].

```!playlist convert <url>``` will take an embedded spotify playlist, finds all the songs it can on GPM, and creates a new shared playlist owned by the bot, but available to all. This, I think, is quite useful, as I often stumble across sites that embed spotify playlists in them, and this makes the playlist easily available to me and my friends. I ended up using [BeautifulSoup] to scrape this data from the embedded playlist pages, then feeding this to the [gmusicapi] library to generate the playlist.

```!setlist generate <bandname>``` will find the band's most likely setlist using setlist.fm. Note that setlist.fm has a REST api, but this feature isn't available via the API, so it necessitated scraping using [BeautifulSoup]. It seems like that's something I've been doing a lot recently (stay tuned for part 2!).

I still work on this project whenever I think of another cool feature. It's been really fun, and I enjoy adding features for my (very small) user base.

[Hangups]: https://github.com/tdryer/hangups
[hangoutsbot]: https://github.com/ovkulkarni/hangoutsbot
[small ORM called peewee]: http://docs.peewee-orm.com/en/latest/
[Google Play Music]: https://en.wikipedia.org/wiki/Google_Play_Music
[Last.fm]: https://en.wikipedia.org/wiki/Last.fm
[Setlist.fm]: https://www.setlist.fm/
[Goo.gl Url Shortener]: https://goo.gl/
[project's readme]: https://github.com/rattboi/musicbot
[BeautifulSoup]: https://www.crummy.com/software/BeautifulSoup/bs4/doc/
[gmusicapi]: https://github.com/simon-weber/gmusicapi

### End of Part 1

Thanks for reading my little project roundup. I have quite a few more still to write about. In part 2, I'm going to write about Trello Concert Tracker, iCE-ROM, and my Open Source Scan Converter build project. Hope to see you there!
