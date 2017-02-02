#!/usr/bin/env bash

set -e

# Build the project and docker images
./mvnw clean install -P docker

# Export the active docker machine IP
export DOCKER_IP=${docker-machine ip $(docker-machine active)}

# docker-machine doesn't exist in Linux, assign default ip if it's not set
DOCKER_IP=${DOCKER_IP:-0.0.0.0}

# Remove existing containers
docker-compose stop
docker-compose rm -f

# Start the eureka-microservice fist and wait for it to become available
docker-compose up -d eureka-microservice

while [ -z ${EUREKA_SERVICE_READY} ]; do
    echo "Waiting for eureka-microservice..."
    if [ "$(curl --silent $DOCKER_IP:8761/health 2>&1 | grep -q '\"status\":\"UP\"'; echo $?)" = 0 ]; then
        EUREKA_SERVICE_READY=true;
    fi
    sleep 2
done

# Start the config service next and wait
docker-compose up -d config-microservice

while [ -z ${CONFIG_SERVICE_READY} ]; do
    echo "Waiting for config-microservice..."
    if [ "$(curl --silent $DOCKER_IP:8888/health 2>&1 | grep -q '\"status\":\"UP\"'; echo $?)" = 0 ]; then
        CONFIG_SERVICE_READY=true;
    fi
    sleep 2
done

# Start the other containers
docker-compose up -d

# Attach to the log output of the cluster
docker-compose logs -f