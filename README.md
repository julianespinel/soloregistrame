# soloregistra.me

This repository was created to store the code that solves the test purposed by solocontrata.me

## Description

This project follows a basic client-server "architecture". The client is a Backbone.js application which is executed in the web browser.
The server was made using Java and deployed in a Tomcat 7 server.

The server exposes its services through a "REST API" (it does not follow the HATEOAS statement, so it's not real REST). 
Client and server communicates over HTTP. The payload of each HTTP request is a JSON object.
The server also consumes the GitHub API in order to show public repositories information.

## Structure

In this repository you can find to folders with source files.

### 1. soloregistrame

This folder contains the Backbone.js client.

### 2. soloregistrame2

This folder contains the server source files.

## Wanna try it out?

~~This project is deployed on AWS, you can try it here: [soloregistra.me](http://54.245.124.110:8080/soloregistrame)~~
