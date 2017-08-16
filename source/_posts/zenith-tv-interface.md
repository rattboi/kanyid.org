---
title: Zenith TV Interface
date: 2017-08-15
tags: 
 - projects
 - hardware
 - python
 - c
---

Back in December, my buddy Epitrope moved to NY, and was trying to get rid of the things he wasn't going to transport across the entire US. One of these things was an older 720p plasma Zenith TV. He is a hacker extraordinaire, and after doing a bit of looking at [the manual], saw that the protocol for the serial interface on the back is documented. He created a set of programs to communicate with this port to do some TV automation, which I thought was really cool. After doing him the favor of taking the TV off his hands (I'm an altruist at heart...), I decided I wanted to use the same programs, running on a dusty [Raspberry Pi 1] I had laying around instead of using a full computer like he did. 

Epitrope architected the program really well, using a separate client/server interface, with the client written in Python and the server written in C. It also uses [protobufs] to have the protocol defined separately from the programs, and uses [ZeroMQ] to encapsulate commands between the two. I knew very little about protobufs or ZeroMQ as I went forward trying to "port" this program to Raspi, and ran into a handful of different issues. 

The first issue I ran into was that the Github repo Epitrope set up didn't have full build instructions, including the dependencies for C and Python that are necessary to run. As I discovered which packages supplied the right dependencies, I [put together some docs and fixed up the Makefile] to handle more steps, such as compiling the protocol buffer definitions.

There were a few interesting gotchas during this process. There are multiple bindings for ZeroMQ, depending on version. Using the wrong one doesn't work, obviously.
Also, the system package in Ubuntu for protobuf compiling doesn't include the compiler for C, but does include the one for Python, so you need to install two separate dependencies.

I then had to deal with the fact that the serial port used in the original was hardcoded, and didn't match the FTDI USB-to-Serial device I was using on the Raspi. [This was a fairly small change]. 

The next commit took the most research. Even though everything seemed to be wired together properly, I was getting corrupted data and commands weren't working. After fixing some of the debug output to display properly, it started to become clear that I was only getting partial data. The responses were supposed to be 14 bytes, but instead I was only getting the first 8. I finally figured out that the serial reads from the Raspi would only read 8 bytes at a time, so [you need to do multiple reads to get all the data]. Epitrope's hardware apparently returned all 14 bytes at once, and so never ran into this problem.

The last thing I did was to add a new TV command to do something you can't do with the remote, "screen mute". This effectively turns off the screen, but leaves the sound still being output. My wife likes to fall asleep with the TV on, but really the thing she's interested in is the sound, so I thought adding this feature would actually make this program useful to me. [The code for this] was very regular, and fit patterns put in place by Epitrope for the other commands. It did require extending the protocol buffer definition, and there was quite a bit of boilerplate.

I have aspirations of rewriting both programs into a single [Rust] program, as I feel that Rust lends itself to system code, but also for web code. The ultimate goal would be to have a RESTful API to control the TV, and perhaps even a small web frontend you could pull up on your phone, but I really haven't gotten very far in learning Rust this year, like I hoped I would. I still hope to come back to this sometime.

Overall, I had fun with this little port project. I learned about ZeroMQ and protobufs a bit, and learned you can't always assume even small serial reads will complete in a single read call. It was also the first C project I'd worked on in years, so it felt a little like going home to visit, even if it was only for a few days.

[the manual]: https://www.manualslib.com/manual/485866/Zenith-Z42p3.html?page=51
[Raspberry Pi 1]: https://www.raspberrypi.org/products/raspberry-pi-1-model-b/
[protobufs]: https://github.com/google/protobuf
[ZeroMQ]: http://zeromq.org/
[put together some docs and fixed up the Makefile]: https://github.com/rattboi/zenith-tv-serial/commit/6d55dd78664e24c13090c85167b9c7960794f8f3
[This was a fairly small change]: https://github.com/rattboi/zenith-tv-serial/commit/b2ab6cf4d162f935b275574b22bfd74a6c56df32
[you need to do multiple reads to get all the data]: https://github.com/rattboi/zenith-tv-serial/commit/867e0e3f9b15843196e2189947adda2a3f033d0d
[The code for this]: https://github.com/rattboi/zenith-tv-serial/commit/307ec2000400871e7d0f7cff46b73a4186f038ef
[Rust]: https://www.rust-lang.org/en-US/
