---
title: Setting Up This Blog
date: 2012-12-21
tags: 
- clojure 
- webdev
---

## Introduction

Ok, so my name is Bradon Kanyid, and I'm a Senior Computer Engineering student at [Portland State University](http://pdx.edu) in the [Maseeh College of Engineering and Computer Science ]. I have a lot of interests, mostly computer-related. At the end of fall quarter, I decided that it would be useful to start documenting projects and things I enjoy somewhere online.

## Where to start?

I decided to make this blog, but definitely do not have a lot of prior webdev experience. I've made little internal pages for work and such, but never really looked into hosting, domain registration, frameworks, or anything of the sort. I started asking my fellow students and [CAT members](http://cat.pdx.edu), and decided that the best thing for me would be to get my own VPS, register my own domain name, and find a static HTML site generator.

## Virtual Private Server

A friend at school was talking up [BuyVM](http://buyvm.net) as a VPS solution, mainly because the price is so awesome. For $15/year, I could have an [OpenVZ]() VM sitting on the Internet that I have root on. The main restriction of the $15 VM is that it is limited to only 128MB of RAM, 'burstable' to 256MB for short times. The BuyVM availability is also limited. When I first attempted to purchase a VM, their website said that they were \"sold out\". Apparently, it's common for VPS providers to over-provision. That is, even though each customer is supposed to have a guaranteed amount of memory (in my case, 128MB/256MB), the VPS provider has less RAM than the sum of the customers' guarantees. BuyVM doesn't over-provision, so they make sure they have the resources before selling more VMs. Luckily, I only needed to wait a day for more VMs to become available. Once my VM was purchased, I had to decide on a few things, including which distribution to use. Initially, I thought I would use [Arch Linux](https://archlinux.org), as this is the distro I use on my personal computers. However, it quickly became apparent that Arch Linux was not a viable choice with the pre-packaged version they offer for OpenVZ. It was built circa 2010, and Arch's [rolling-release model](https://en.wikipedia.org/wiki/Rolling_release) doesn't really lend itself to old installs. Since Arch was out, I had the option of either CentOS, Debian, or Ubuntu. I am more familiar with Debian-based distros, so it was really down to Ubuntu or Debian. I had never used Debian before, but was hearing good things about it from the same friend who recommended that I look into BuyVM, so I figured that if I ran into any problems with BuyVM + Debian, I'd have a friend who could help.

<!-- more -->

## Domain Name Registration

Ok, so the next decision to make was which registrar I would use to register my domain. I had heard not-good things about GoDaddy, and I was struggling to name another registrar. After talking to another friend, I decided to try gandi.net for registration. Their website is pretty intuitive, and I ended up with kanyid.org for $15 for a year. I needed to create a DNS zone using their web interface, but it was pretty trivial to make kanyid.org point at my VPS IP address, and make a CNAME record for www.kanyid.org. The TTL for gandi records is pretty large, so it took quite a while before it started working correctly.

## A Note About Reverse DNS

Much later, I realized that I had never set up a reverse DNS record, and so a reverse lookup to my IP address would return web.bhutantalk.com instead of kanyid.org. At first, I thought this would be part of my DNS Zone record with gandi, but their documentation told me that reverse DNS needs to be configured with the IP owner. After digging in BuyVM's web management, I found a place to set up reverse DNS.

## Static Site Generator

Now that I had a Debian box on the Internet, I needed to figure out how to set up a web server, and also a way to manage my web content. I had a little experience setting up Apache Web Server before, but that seemed pretty heavy and overkill for what I was trying to do. The only alternative I'd heard commonly thrown around was nginx, which I had never used myself.
