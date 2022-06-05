#!/bin/sh

cd /src/$APP_NAME/webapp
if [ ! -d WEB-INF ]; then
	echo "[!] src/$APP_NAME/webapp/WEB-INF doesn't exists"
	exit 1
fi

cd WEB-INF
echo "[i][$APP_NAME] compiling java code"
javac -classpath .:/usr/local/tomcat/lib/servlet-api.jar -d classes ../../java/$APP_CLASS/*
echo "[i][$APP_NAME] finished compiling"

ln -s /usr/local/tomcat/webapps.dist/manager /usr/local/tomcat/webapps/manager
ln -s /src/$APP_NAME/webapp /usr/local/tomcat/webapps/$APP_NAME

# Hand off to the CMD
exec "$@"