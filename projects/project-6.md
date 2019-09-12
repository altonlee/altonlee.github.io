---
layout: project
type: project
image: images/proj6-title.png
title: Calendar Event Creator
permalink: projects/penne
# All dates must be YYYY-MM-DD format!
date: 2019-07-31
labels:
  - JavaScript
  - HTML
  - Semantic UI
  
summary: Create exportable events with ease. An HTML and JS-based project for ICS 414. 
---

<img class="ui image" src="https://i.imgur.com/XiilLbR.png">

You can view the repo <a href="https://github.com/crisnow/Team_Penne">here!</a>

For ICS 414, we were assigned a group to create an event file that can be imported into popular calendar apps like Google Calendar and iCalendar. I was assigned to Team Penne, which consisted of Kristy Gong and Matthew Lam. Together we created a file generator app written in HTML and JavaScript, and masked with Semantic UI. 

We based our app around Google Calendar, which has lots of options for dates, times, and recursion. Our app asks for the basics, such as title, start and end dates and times, and details for the event. The user also has options to add a location. We implemented Google Maps to add coordinates to the location of the event, as well. 

<img class="ui image" src="https://raw.githubusercontent.com/crisnow/Team_Penne/master/map.jpg">

The app also has options for recursion, which can be as simple as weekly, or as complex as every Tuesday and Thursday every other three weeks. 

<img class="ui image" src="https://i.imgur.com/T8Z7yWK.png">

Lastly, the app has options for visibility and priority, and has limited Time Zone options. 

<img class="ui image" src="https://i.imgur.com/JwliUe8.png">

If all inputs are correct, then the file will spit out a filename.ics file containing all of the event data. The file will then be available to import into any calendar app of the user's choice. This program is a result of five weeks working together with Team Penne. My contributions include working on UI, and implementing recurrence, visibility, priority, and time zone options. 
