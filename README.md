# soloregistra.me

This repository was created to store the code that solves the test purposed by solocontrata.me

## Structure

This project follows a basic client-server "architecture". The client is a Backbone.js application which is executed in the web browser.
The server was made using Java and deployed in a Tomcat 7 server.

The server exposes its services through a "REST API" (it does not follow the HATEOAS statement, so it's not real REST). 
Client and server communicates over HTTP. The payload of each HTTP request is a JSON object.
The server also consumes the GitHub API in order to show public repositories information.