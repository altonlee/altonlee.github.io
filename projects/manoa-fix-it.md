---
layout: project
type: project
image: img/prj-fixit/title.png
title: "Manoa Fix-It!"
date: 2020
published: true
labels:
  - Android SDK
  - Java
  - SQLite
summary: "An app designed for students to report facility-related issues. A final project for ICS 414."
---

### Introduction
For this project we were tasked to build an app that handles high traffic volume and database management. Our team decided on building an app that aims to capture campus-related issues and document any progress for campus-wide transparency. 

Our inspiration for this app was UH Manoa's Computer Science building notoriously having broken doors. After personally having to deal with broken doors for four years, but no streamlined way of reporting this issue, we wanted to bring this solution to life.

Our target demographic for this app are students and professors who use campus facilities regularly. As long as there are issues on campus, and there are students that enter the UH system, there will always be new users on the app.

Check out the video below to see the app in action!

<div class="p-4" style="text-align: center">
	<iframe width="100%" height="600" src="https://www.youtube-nocookie.com/embed/bbYfWPntq98?si=qHSzi5pjkqPyA7wR" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
</div>

### Development

We storyboarded the layout of the mobile app first, since the main user interaction would take place there. We had a rough idea of having popular issues rise to the top of the feed, so users could vote on issues that were important to the user demographic. We also opted to have a separate complaints list so users can submit suggestions or frustrations. 

The app was developed using Android SDK and the Java Source, and builds were made with mobile devices in mind. As this was the team's first time building a mobile app, we did run into issues with connecting to our local database and in-app navigation. Luckily, we were solely focused on Android development at the time, so we did not have any issues with compatability. 

The web-based admin functionality was developed with JS React and Semantic UI and is designed after the main UH branch's aethetics. The site would do a SQL query for either issues or complaints and sort based on user-reported urgency. As of writing the site functionality is merely a mock-up and has potential to grow.
