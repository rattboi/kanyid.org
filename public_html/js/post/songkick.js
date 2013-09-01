var genConcertHTML = function(json)
{
    var myHTML = ''

    for (var entry = 0, entries = json.resultsPage.totalEntries; entry < entries; entry++) 
    {
        var event = json.resultsPage.results.calendarEntry[entry].event;
        var reason = json.resultsPage.results.calendarEntry[entry].reason;
        var date = event.start.date;
        var venue = event.venue.displayName;
        var uri = event.uri;
        var status = reason.attendance == 'im_going' ? "I'm going" : "Maybe";
        myHTML += '<div class="page-header"><h3><a href="' + uri + '">' + date + ' at ' + venue + '</a> - ' + status + '</h3>';

        myHTML += '<ul>'
        for (var perf = 0, perfs = event.performance.length; perf < perfs; perf++)
        {
            var artist = event.performance[perf].artist;
            var name = artist.displayName;
            var band_uri = artist.uri;
            myHTML += '<li><a href="' + band_uri + '">' + name + '</a></li>';
        }
        myHTML += '</ul></div>'; 
    }
    document.getElementById('songkick').innerHTML = myHTML;
    console.log(json);
}
var songkick_call = "http://api.songkick.com/api/3.0/users/rattboi/calendar.json?reason=attendance&apikey=lb0mq3HKVI4Ko5ge";
var script = document.createElement('script');
script.src = songkick_call + "&jsoncallback=genConcertHTML";
document.getElementsByTagName('head')[0].appendChild(script);
