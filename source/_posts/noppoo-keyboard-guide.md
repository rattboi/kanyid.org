---
title: Noppoo Choc Mini Guide
date: 2014-08-19
tags: mechanical keyboard
---

## Introduction

Well, I finally did it; I bought my first mechanical keyboard, a [Noppoo Choc Mini 2M](http://www.amazon.com/dp/B00FVTQ1OE/) with [Cherry MX Blue](http://deskthority.net/wiki/Cherry_MX_Blue) switches from [Massdrop](https://massdrop.com). As this is my first mechanical keyboard, I really didn't know what to expect. I knew that there would be a few function keys to control some of the features, but I didn't really take the time to read up on them, past noting that there was no way through hardware to [rebind the Capslock key to Escape](http://vim.wikia.com/wiki/Avoid_the_escape_key). After looking at many keyboards and failing to find this feature, I've made my peace with it. But I digress...

<img src="/img/noppoo.jpg" style="width: 75%; display: block; margin-left: auto; margin-right: auto"/>

## Unboxing

Once it arrived, I immediately took it out of the box and plugged it in. There was only some bubble packaging, the rubber keyboard cover, a piece of paper with a serial number or something, and a small bag containing a USB cable, a wireless USB receiver, and a keycap puller. Upon plugging in the keyboard, it immediately went red and I could start typing. I really like the feel of the Cherry MX Blue switches, both the tactileness and the feedback from the clickiness.

<!-- more -->
## The Problem

After briefly testing and verifying the basic keypress functionality was working, I started looking into what features the keyboard offered. I searched online for a manual, and was suprised to find that there isn't one, at least not one that I could find. It seems a little strange to me that Noppoo doesn't even list this product on their website. After a little more research, I was also surprised to find that the [Deskthority wiki](http://deskthority.net/wiki/Noppoo_Choc_Mini) does not cover all the features of the Choc Mini. So I was left searching for each thing individually, finding bits of information and piecing it together. That was annoying, so I'm compiling the info and placing it here.

## Media Keys (Left Hand Cluster)

There were certain features of the keyboard that were immediately apparent, like how to use the media keys. There are laser-etched graphics on the top of each key that shows its primary function, and also screenprinted graphics on the front side of the key showing any secondary use. The media keys are in a cluster on the left hand, under the asdf keys, with volume control under the qwe keys. Fn+A/S/D/F controls playback, Fn+Q/W/E controls volume. Strangely, within the media key cluster is also Fn+R, which disables the Windows key. This would be a great boon if you are a Windows gamer, as it would disallow accidental presses of the Windows key, which would kick you out of your game. For me, this is basically useless, as the Win key is my main way of interacting with [Awesome, my window manager.](http://awesome.naquadah.org/)

## Numpad Emulation (Right Hand Cluster)

This functionality isn't actually a chorded motion, like the Fn+<key> bindings. This is a modal setting, based on the Numlock state. If Numlock is on, which you can toggle via Fn+PrtSc, then you can use your right hand for standard Numpad functions. This should be fairly obvious, so I'm not gonna go into detail. One interesting thing is that the comma key in Numlock mode is bound to 00. I could see this as useful if you're used to financial calculators.

<img src="/img/noppoo2.jpg" style="width: 75%; display: block; margin-left: auto; margin-right: auto"/>

## The Top Row

Ok, here's where things get interesting. The entire top row of the keyboard all have secondary functions while holding the Fn key. Fn+Esc turns off the keyboard paying attention to the Numlock status. In other words, Numlock state can be on or off, but the keyboard ignores this if you've pressed Fn+Esc. It's pictoral graphic is a number 1 crossed out in a circle. Fn+F1/F7 have mappings to special windows functions, such as bringing up Windows Explorer, a browser, an email client, the search tool, etc. These have no effect on my Arch Linux desktop. I suppose you could remap them to whatever. Fn+F8 maps to the Sleep button on some keyboards. This should be obvious, as it is a picture of the moon. Fn+F9 took me a while to figure out, but it swaps the Capslock key and the Control key. This is a big win if you are an Emacs guy (which I'm not). Fn+F10/F11 are interesting. They control the amount of debounce in the keys. I haven't played with this feature, but if you start finding that you press a key and it shows up twice, you can likely increase the debounce, and the doubled characters should stop. If you increase debounce too much, though, you may start missing legitimate keypresses. Fn+F12 is totally strange. It seems to reset the keyboard, all the way to being re-identified by the OS. Perhaps it does more, and I just haven't fully understood it. Fn+PrtSc is Numlock, with an LED indicator between keys. Fn+Pause is ScrollLock, which I've only actually seen used in Excel, and Fn+Delete is Insert (annoyingly).

## Hidden Extras

Last but not least, there's one set of 'hidden' Fn key mappings for controlling the brightness of the LED backlighting. Fn+Up/Down control 4 levels of brightness, from Really Bright, to Pretty Bright, to Sorta Bright, to Off. There might be other hidden features, but I haven't disovered them yet.

## Function Key Summary

|Key Combination|Explanation                         |
|---------------|------------------------------------|
|Fn+Escape      |Toggle 'No Numlock Mode'            |
|Fn+F1          |Windows Explorer                    |
|Fn+F2          |Internet Explorer                   |
|Fn+F3          |Calculator                          |
|Fn+F4          |Not Sure                            |
|Fn+F5          |Email Client                        |
|Fn+F6          |Search Tool?                        |
|Fn+F7          |Not Sure                            |
|Fn+F8          |Sleep                               |
|Fn+F9          |Switch Lock (swap Capslock and Ctrl)|
|Fn+F10         |Decrease Debounce                   |
|Fn+F11         |Increase Debounce                   |
|Fn+F12         |Reset Keyboard                      |
|Fn+PrtSc       |NumLock                             |
|Fn+Pause       |ScrLock                             |
|Fn+Delete      |Insert                              |
|Fn+Q           |Toggle Mute                         |
|Fn+W           |Decrease Volume                     |
|Fn+E           |Increase Volume                     |
|Fn+R           |Disable Windows Key                 |
|Fn+A           |Play/Pause                          |
|Fn+S           |Previous Track                      |
|Fn+D           |Next Track                          |
|Fn+F           |Stop                                |
|Fn+Up          |Increase LED Backlight Brightness   |
|Fn+Down        |Decrease LED Backlight Brightness   |
