FROM mysql:5.7

ADD ./00_initialize.sh /docker-entrypoint-initdb.d

RUN apt-get update && apt-get install -y less vim

COPY my.cnf /etc/my.cnf
