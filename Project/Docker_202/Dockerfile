FROM openjdk

EXPOSE 8089

ADD ./dist/TheMuddyGame.jar /srv/TheMuddyGame.jar
ADD ./dist/restlet.jar /srv/restlet.jar

CMD java -cp /srv/restlet.jar:/srv/restlet-json.jar:/srv/TheMuddyGame.jar server.MuddyGameServer
