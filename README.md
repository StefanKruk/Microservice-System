# Microservice-System

This Microservice-Demo System was developed by me for my Bachelor Thesis and should provide a quick intreduction in Microservice-Systems for Business applications.

This Microservice-Demo System makes use of the Spring Framework including Eureka, Feign, Ribbion, Zuul and Spring Config.

# How to Start

Before you can run the services you have to build them. For an easer use I added the [Maven Wrapper](https://github.com/takari/maven-wrapper) of [Takari](https://github.com/takari). 
To Build the Services you have to execute `mvnw clean install` in the parent dir.
After this all Services can be startet with `mvnw spring-boot:run`
Please note that all Services have to be startet seperately first the config service and second the eureka service has do be started in order to work.

The config microservice is the central Service for all configuration so it must be startet at first.
After that the eureka microservice should be startet for it is the service discovery Server.
Without the service discovery service other Services are not able to find the config microservice or other microservices.
Now all other services can be startet, but i recommend to start the gateway server next in order to use all APIs via Port 80.

# APIs

* account-microservice: `GET /accounts`
* accountclient-microservice: `GET /`
* config-microservice: `GET /{microservice-name}/default`
* frontend-microservice: `GET /`

The gateway-microservice is a bit special, while all of the services above has pre-defined apis, the api of the gateway-microservice is dynamic for it is a proxy service.
The gateway-microservice use the eureka-microservice (service discovery) to route all incomming traffic to the right microservice.
````
GET /{microservice-name}/{microservice-api}
````
In order to rout all traffic you first have to tell the service which service to use.
After that you can use the microservice specefic api.

# Ports

All Services are running on different ports in order to work.

* Eureka: 8761
* Zuul: 80
* config: 8888
* authentication: 9999
* frontend: 10000
* account: 10002
* client: 10003


# Sonstiges

Create Keystore:

````
keytool -genkeypair -alias jwt -keyalg RSA -keypass mySecretKey -keystore keystore.jks -storepass mySecretKey
````

Get the Public Key:

````
keytool -genkeypair -list -rfc -keystore keystore.jks | openssl x509 -inform pem -pubkey
````