---
title: Atari 7800 UAV Installation
date: 2017/08/15 00:00:01
tags: 
 - projects 
 - hardware
 - video games
 - diy
 - retrogaming
---

This is my most recently completed project. "Complete" is a fairly subjective word though, as the likelihood that I pop the top on my [Atari 7800] again soon is fairly high. The point of this project was to install the [Atari UAV board] inside my 7800 in order to get a much better video signal out of it.

The Atari 7800 only supported one type of video output signal, [ye olde radio frequency modulator]. You may remember the box doohickey you'd screw into your TV's coaxial connector from the NES. The 7800 has the same thing, except the box is integrated into the console itself. This is, in fact, the worst consumer standard for video (and audio) output. It combines all the signals into a single crappy signal that is then adjusted (magically) to appear on channel 3 of your old-ass television. Needless to say, this doesn't look great on a modern digital television. It really never looked good on older analog TVs either, but our expectations have changed since the 80s. 

Bryan on the [AtariAge] forum sells a ~$25 modification kit he's designed to tap into the mainboard of various Atari console and computers, and skip the RF interface altogether, giving you access to both a very nice S-Video as well as a less-nice-but-still-good composite video signal. The [forum post] has lots of images to pore over, if you're so inclined. I was after the S-Video signal, myself, as I have a Trinitron CRT television that supports this signal type, and I'm about to procure a Panasonic BT-M1390Y Color Video Monitor, which also supports S-Video.

There really wasn't that much to the installation of the board itself. I decided to pull out the RF adapter altogether, and place the board in its location. The only things I had any issues with were mechanical in nature. For whatever reason, mechanical stuff is just not my forte. When I was ready to install this sucker, I realized it didn't come with any of the mechanical parts, like the s-video plug or the rca jacks, so I had to order them from an electronics compoenent distributor. Once I received them, I went to work figuring out where I wanted the plugs located. After that, I just started drilling on the case, because I'm an idiot. One mistake I made was not giving adequate spacing between the RCA jacks, so the audio left + right jacks are too close together and it's a real squeeze to get both plugs in. Also, the jacks are low enough on the slope of the case that it's an issue to have them plugged in and not propping up the entire case like a bike kickstand. Also, I tried to eyeball the placement for the center of the s-video jack drill-out, and I was way off. I ended up needing to use a dremel to fix it, which fortunately came out alright.

The last little thing was that the audio lines don't go through the video board, and instead are just tapped from the mainboard and are expected to go to a 10uF capacitor before the jacks. I didn't order that, but luckily I had some on-hand from my now-ancient ECE undergrad toolbox.

Overall, I'd give myself like a 2/5 for planning, but everything worked out OK in the end, as I have the sharpest 7800 pixels you've ever seen. You could cut yourself on them. They're gonna look even more awesome once I receive my Panasonic monitor. I didn't grab any "before" shots (see? more proof of poor planning), so here's a couple I found online. 

<img src="/img/proj-roundup-pt1/rf-composite-comparison.jpg" style="width: 75%; display: block; margin-left: auto; margin-right: auto"/>

<img src="/img/proj-roundup-pt1/rf-svideo-comparison.jpg" style="width: 75%; display: block; margin-left: auto; margin-right: auto"/>

__UPDATE: I have now received the aformentioned monitor, and took some pictures of the project.__

<a href="/img/proj-roundup-pt1/atari-fullmod.jpg">
<img src="/img/proj-roundup-pt1/atari-fullmod-small.jpg" style="width: 75%; display: block; margin-left: auto; margin-right: auto"/>
</a>
<p style="text-align: center;">Full Mod</p>

<a href="/img/proj-roundup-pt1/atari-jack-closeup.jpg">
<img src="/img/proj-roundup-pt1/atari-jack-closeup-small.jpg" style="width: 75%; display: block; margin-left: auto; margin-right: auto"/>
<a>
<p style="text-align: center;">Close-up of the added jacks</p>

<a href="/img/proj-roundup-pt1/atari-too-close.jpg">
<img src="/img/proj-roundup-pt1/atari-too-close-small.jpg" style="width: 75%; display: block; margin-left: auto; margin-right: auto"/>
</a>
<p style="text-align: center;">RCA Jacks are too close together</p>

<a href="/img/proj-roundup-pt1/atari-kickstand.jpg">
<img src="/img/proj-roundup-pt1/atari-kickstand-small.jpg" style="width: 75%; display: block; margin-left: auto; margin-right: auto"/>
</a>
<p style="text-align: center;">Also, when cables are plugged in, you get this kickstand effect</p>

<a href="/img/proj-roundup-pt1/atari-kickstand-fix.jpg">
<img src="/img/proj-roundup-pt1/atari-kickstand-fix-small.jpg" style="width: 75%; display: block; margin-left: auto; margin-right: auto"/>
</a>
<p style="text-align: center;">Here's some adapters to 'fix' the kickstand effect</p>

<a href="/img/proj-roundup-pt1/atari-at-home.jpg">
<img src="/img/proj-roundup-pt1/atari-at-home-small.jpg" style="width: 75%; display: block; margin-left: auto; margin-right: auto"/>
</a>
<p style="text-align: center;">Atari 7800 back in its home</p>

<a href="/img/proj-roundup-pt1/atari-on-monitor.jpg">
<img src="/img/proj-roundup-pt1/atari-on-monitor-small.jpg" style="width: 75%; display: block; margin-left: auto; margin-right: auto"/>
</a>
<p style="text-align: center;">S-Video input on my new Panasonic BT-H1390Y</p>

<a href="/img/proj-roundup-pt1/atari-mario-closeup.jpg">
<img src="/img/proj-roundup-pt1/atari-mario-closeup-small.jpg" style="width: 75%; display: block; margin-left: auto; margin-right: auto"/>
</a>
<p style="text-align: center;">Close-up of Mario chillin' out</p>

[Atari 7800]: https://en.wikipedia.org/wiki/Atari_7800
[Atari UAV Board]:  http://atariage.com/forums/topic/246613-new-video-upgrade-coming-soon/
[ye olde radio frequency modulator]: https://en.wikipedia.org/wiki/RF_modulator
[AtariAge]: http://atariage.com/
[forum post]:  http://atariage.com/forums/topic/246613-new-video-upgrade-coming-soon/
