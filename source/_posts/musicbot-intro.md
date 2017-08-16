---
title: Musicbot for Hangouts
date: 2017/08/15 00:00:03
tags: 
 - projects 
 - programming 
 - music 
 - python
---

This project has been a lot of fun. The point of it is to assist in conversations in a music-related Hangouts group chat. I'm not sure why everyone settled on Hangouts as the chat standard for our group, but people like it because the barrier to entry is so low. 

<img src="/img/proj-roundup-pt1/hangouts-bot-now-all.jpg" style="width: 50%; display: block; margin-left: auto; margin-right: auto"/>
<p style="text-align: center;">!now command example output</p>

I'm used to IRC and having bots assist in the conversation, so I was a little bummed that everyone wanted to use Hangouts. After a bit of research, however, I found that there are actually a handful of bot frameworks for integration with Hangouts, all leveraging the [Hangups] Python library. I looked over a few, and found one that [hangoutsbot] had the feature-set I was looking for. This came with all the hooks to extend it effectively, as well as a [small ORM called peewee] to abstract out any database functionality. I think peewee is the first ORM I've used in Python, and it has been fairly straightforward. I think I still prefer the feel of something like [hugsql] over ORMs in general, but peewee is painless.

I've added quite a few integrations at this point, to the following services:

- [Google Play Music]
- [Last.fm]
- [Setlist.fm]
- [Goo.gl Url Shortener]

To make this work, we decided as a group to standardize on these services. I guess it probably wouldn't be too hard to also integrate with something like libre.fm for listening habit tracking, but we definitely needed to standardize on a music streaming service, and GPM has the best deal. $15/mo gets you 6 users with a family account. I split the cost with my friend Noah, and we share user accounts to others. For this to work correctly, the musicbot actually needs to be its own user in GPM as well, so keep that in mind, as that eats an account on its own. Theoretically, you could share your personal account, but you may get some strange behavior, because the bot maintains shared playlists and a few other things.

<img src="/img/proj-roundup-pt1/hangouts-bot-recent.jpg" style="width: 50%; display: block; margin-left: auto; margin-right: auto"/>
<p style="text-align: center;">!recent command example output</p>

A few cool things I've added that I'm pretty proud of are listed below. For a more in-depth overview of all the features, you can find them in the [project's readme].

```!playlist convert <url>``` will take an embedded Spotify playlist, finds all the songs it can on GPM, and creates a new shared playlist owned by the bot, but available to all. This, I think, is quite useful, as I often stumble across sites that embed Spotify playlists in them, and this makes the playlist easily available to me and my friends. I ended up using [BeautifulSoup] to scrape this data from the embedded playlist pages, then feeding this to the [gmusicapi] library to generate the playlist.

```!setlist generate <bandname>``` will find the band's most likely setlist using setlist.fm. Note that setlist.fm has a REST api, but this feature isn't available via the API, so it necessitated scraping using [BeautifulSoup]. It seems like that's something I've been doing a lot recently (stay tuned for part 2!).

<img src="/img/proj-roundup-pt1/hangouts-bot-setlist.jpg" style="width: 50%; display: block; margin-left: auto; margin-right: auto"/>
<p style="text-align: center;">!setlist command example output</p>

I still work on this project whenever I think of another cool feature. It's been really fun, and I enjoy adding features for my (very small) user base.

One thing I don't like about this bot is that it is tightly coupled only to Hangouts, although the features it offers really are more general. I've used Errbot in the past to write a decoupled chatbot with pluggable backends, and it'd be great to port over my functionality to that, but there are two main things barring me from doingso.

1. There is no Hangouts backend for Errbot, so I'd have to write the backend myself. I've actually contemplated doing this, as then I could leverage the entire Errbot plugin ecosystem, and so could anyone else standardizing on Hangouts as their chat medium.
1. Errbot doesn't come with a comparable database backend, so I'd have to roll my own or bring peewee with me, which complicates things.

The above points sound like a sizeable amount of work, but perhaps in the future you'll see a post about Errbot-Hangouts-Backend or some such project.

[Hangups]: https://github.com/tdryer/hangups
[hangoutsbot]: https://github.com/ovkulkarni/hangoutsbot
[small ORM called peewee]: http://docs.peewee-orm.com/en/latest/
[hugsql]: https://www.hugsql.org/
[Google Play Music]: https://en.wikipedia.org/wiki/Google_Play_Music
[Last.fm]: https://en.wikipedia.org/wiki/Last.fm
[Setlist.fm]: https://www.setlist.fm/
[Goo.gl Url Shortener]: https://goo.gl/
[project's readme]: https://github.com/rattboi/musicbot
[BeautifulSoup]: https://www.crummy.com/software/BeautifulSoup/bs4/doc/
[gmusicapi]: https://github.com/simon-weber/gmusicapi
