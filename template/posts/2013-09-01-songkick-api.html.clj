; @layout post
; @title  Using Songkick API in Javascript
; @tag    webdev music javascript

(defn songkick-content []
  (p {:id "songkick"} (js "/js/post/songkick.js")))

(p (link "Songkick" "https://www.songkick.com/") " is a music service that finds local concerts based on your personal tastes. You give it some info about what you like, either through an exported iTunes library, Pandora playlist, or Last.fm scrobble history, tell it where you're interested in going, and it lets you know who is playing and where. I've been a happy user for at least two years now, and it's a really good tool for tracking tours and " (link "concert history." "https://www.songkick.com/users/rattboi/gigography"))

(h2 "Requesting an API Key")
  (p "For all the aspects I enjoy about Songkick, I found it somewhat difficult directing people to my " (link "Upcoming Events calendar" "https://www.songkick.com/users/rattboi/calendar" ) ". They don't seem to offer any pre-configured way to embed the content in other places, but " (link "they do offer an API now" "https://www.songkick.com/developer" ) ". I requested an API key, and went to work trying to embed my Upcoming Events calendar into this blog post.")

(h2 "Dynamic Content on a Static Site?")
  (p "Initially, I thought I would do something similar to " (link "Mopidy-Subsonic" "https://github.com/rattboi/mopidy-subsonic") " and start working on some Python to decode the JSON I get from Songkick. However, I want to put it on this website, and my website is static content only. If I want any dynamic content, I'll have to resort to client-side Javascript, similar to how Disqus works for my blog comments. I am no Javascript expert, especially for client-side content, and I am no DOM expert either. However, I saw in the documentation that the right kind of request would generate JSONP, which I could then assign to a callback to do all the parsing and generating work. I imagined that at that point, I could fill in something like an empty div tag on the page with the generated HTML. My initial research on how to generate the API call bore interesting fruit. It was difficult to find much in the way of doing this without a library. Everyone uses " (link "JQuery" "http://jquery.com/") " or " (link "Prototype" "http://prototypejs.org/") " for this, it seems. I like libraries, but I don't want to add an entire library for one small feature, and I want to have an understanding of how it works before I rely on the library. I don't like magic. I found an article on " (link "requesting remote JSON without JQuery" "http://stackoverflow.com/questions/9649528/get-remote-json-without-jquery") " on Stack Overflow, and modified it to support the JSONP callback convention. I later found an article on " (link "the differences between JSONP and JSON" "http://stackoverflow.com/questions/2887209/what-are-the-differences-between-json-and-jsonp") ", which gave a similar snippet for attaching the JSONP as a script.")

(h2 "Javascript Code")
  (p "I've made a few comments in the code below to give you an idea what's going on, but the meat of the work is in the getConcertHTML function, a callback that is triggered when the JSONP object is received from Songkick. I'm using simple string concatenation to build up some generated HTML, which then replaces the content of the HTML element with 'songkick' as its ID.")

#-CODE
// callback used to process the JSONP object
var genConcertHTML = function(json) {
    var myHTML = ''

    // iterate through the entries in the results
    for (var entry = 0, entries = json.resultsPage.totalEntries; entry < entries; entry++) {
        // grab the elements we are interested in
        var event = json.resultsPage.results.calendarEntry[entry].event;
        var reason = json.resultsPage.results.calendarEntry[entry].reason;
        var date = event.start.date;
        var venue = event.venue.displayName;
        var uri = event.uri;
        var status = reason.attendance == 'im_going' ? "I'm going" : "Maybe";

        // put these elements into our generated HTML
        myHTML += '<div class="page-header"><h3>'
        myHTML += '<a href="' + uri + '">' + date + ' at ' + venue + '</a> - ' + status + '</h3>';

        // further iterate through the artists at a concert and generate an unordered list
        myHTML += '<ul>'
        for (var perf = 0, perfs = event.performance.length; perf < perfs; perf++) {
            var artist = event.performance[perf].artist;
            var name = artist.displayName;
            var band_uri = artist.uri;
            myHTML += '<li><a href="' + band_uri + '">' + name + '</a></li>';
        }
        myHTML += '</ul></div>'; 
    }
    document.getElementById('songkick').innerHTML = myHTML;
}

// setup Songkick API call
var sk_base     = "https://api.songkick.com/api/3.0/users/<user>/";
var sk_method   = "calendar.json?reason=attendance";
var sk_apikey   = "<apikey>";
var sk_callback = "&jsoncallback=genConcertHTML"; 
var sk_call     = sk_base + sk_method + "&apikey=" + sk_apikey + sk_callback;

// create script element, point at API call, and attach to page
var script = document.createElement('script');
script.src = sk_call;
document.getElementsByTagName('head')[0].appendChild(script);

CODE

(h2 "Static Site Code")

(p "For the static side, I'm using " (link "Misaki" "http://liquidz.github.io/misaki/") ", a static site generator in Clojure. It has allowed me to use native Clojure code and a little glue to make this blog, using a simple templating format. As you can see below, you are still using what are basically tags in the Clojure code, but it abstracts away a lot of the templating, formatting and resource management. You can " (link "read more about making this blog," "http://kanyid.org/2012-12/setting-up-this-blog.html") " if you are interested. A paragraph tag is created with the id 'songkick', and the Javascript code above is loaded into it. This element is later replaced by the callback.")

#-CODE
; @layout post
; @title  Using Songkick API in Javascript
; @tag    webdev music javascript

(defn songkick-content []
  (p {:id "songkick"} (js "/js/post/songkick.js")))

...other content...

(songkick-content)
CODE

(h2 "Conclusion")
(p "So, the Upcoming Events are shown below. The formatting isn't great, but it is functional. I'm curious what it would take to pull some of the templating out of the HTML generation code of the callback, because right now I have to hard-code some things like the styles. Perhaps something like the jQuery or Protype library would be useful for this. In the future, I would like to make an IRC bot that you could query for the same information in a channel. It shouldn't be hard to make a Python wrapper for the entire API, similar to " (link "libsonic" "https://github.com/crustymonkey/py-sonic") ", which I'm using in " (link "Mopidy-Subsonic" "https://github.com/rattboi/mopidy-subsonic") ". I hope you've enjoyed reading this post. I'm still catching up on a few posts that are backlogged, so hopefully there will be more soon.")

(h2 "Subsonic Upcoming Events Calendar")
(songkick-content)

