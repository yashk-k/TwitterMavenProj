# TwitterMavenProj
## Table of contents
* [General info](#general-info)
* [Prerequisites](#prerequisites)
* [Technologies](#technologies)
* [Execution](#execution)

## General info
This is a simple project is to post a Tweet or retrieve timeline from a Command line.

## Prerequisites
You need to have a Twitter Developer access to get the Authentication keys.
Java 8 installed.

## Technologies
Project is created with:
* Java 8

	
## Execution
To run this project,  :

Download TwitterMavenProj/target/TwitterProj.jar
,,,
Navigate to the direcotry where the file is downloaded.
For Windows
Edit the jar using any Zip Utility softwares and modify the config.properties and mention the authentication keys of Twitter
$ cd <FileDownloadPath>
Run the below command for posting to Twitter. 
Argument 'post' is to indicate to post to Twitter followed by the Tweet.
$ java -jar TwitterProj.jar post "<Tweet Content>"
Argument 'retrieve' is to fetch the Timeline
$ java -jar TwitterProj.jar retrieve


For Linux/macOS
Edit the jar using the command below and modify the config.properties and mention the authentication keys of Twitter
$ cd <FileDownloadPath>
$ vim TwitterProj.jar
Argument 'post' is to indicate to post to Twitter followed by the Tweet.
$ java -jar TwitterProj.jar post "<Tweet Content>"
Argument 'retrieve' is to fetch the Timeline
$ java -jar TwitterProj.jar retrieve
