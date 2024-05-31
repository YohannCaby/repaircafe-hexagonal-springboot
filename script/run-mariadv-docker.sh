#!/bin/bash
CONTAINER_NAME=mariadb
MARIA_USER=repaircafe
MARIA_PASSWORD=repaircafe
MARIA_DBNAME=repaircafe
MARIA_PORT=3306
docker run --detach --name $CONTAINER_NAME \
                    --env MARIADB_USER=$MARIA_USER \
                    --env MARIADB_PASSWORD=$MARIA_PASSWORD \
                    --env MARIADB_DATABASE=$MARIA_DBNAME \
                    --env MARIADB_ROOT_PASSWORD=$MARIA_PASSWORD  \
                    -p $MARIA_PORT:3306 mariadb:latest
