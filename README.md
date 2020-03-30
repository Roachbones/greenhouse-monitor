# Greenhouse Monitor
Converts the greenhouse's data exports into friendly html tables to be served through a web server for remote access. [See a demo here.](https://rose.systems/greenhouse-monitor/) This is my first project in Java.

Here's what the different files are:

- **src/greenhouse_monitor/WebpageMaker.java** converts greenhouse data (data.csv) into a webpage with an html table (index.html). In the future, this would save index.html somewhere a web server application can find it.
- **data.csv** is the greenhouse source data. We still need to figure out how to automatically get this from the greenhouse computer.
- **index.html** is the main webpage that will be viewed by a gardener. It displays recent greenhouse data in a friendly format.
- **template.html** is a webpage template used to generate index.html. The table rows go after the `<!--[[DATAROWS]]-->` comment.
- **style.css** is a stylesheet used by template.html.
- **colortest.html** demonstrates the spectrums of colors used to highlight temperatures and humidity levels on the html table. It is generated along with index.html.
