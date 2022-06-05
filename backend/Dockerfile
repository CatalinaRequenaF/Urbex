FROM tomcat:9-jdk16-openjdk

WORKDIR /usr/local/tomcat/bin
COPY run.sh run.sh
RUN chmod +x run.sh

RUN apt-get update
RUN apt-get install default-jre --assume-yes
RUN apt-get install default-jdk --assume-yes
RUN apt-get install zip --assume-yes

# RUN wget -O mysql-jdbc.deb https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java_8.0.29-1debian11_all.deb \
# 	&& dpkg -i mysql-jdbc.deb \
# 	&& rm mysql-jdbc.deb

ENV JPDA_ADDRESS="8000"
ENV JPDA_TRANSPORT="dt_socket"

COPY entrypoint.sh /entrypoint.sh
RUN chmod 755 /entrypoint.sh

ENTRYPOINT ["/entrypoint.sh"]

WORKDIR /usr/local/tomcat/bin

CMD ["run.sh"]