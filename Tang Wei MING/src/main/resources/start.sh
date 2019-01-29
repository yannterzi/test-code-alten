#!/bin/sh
nohup  java -server -DrepositoryFile=flights.json  -jar target/demo-0.0.1-SNAPSHOT.jar &
