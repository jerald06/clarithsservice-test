# Cl@rIt Hostpitality Service

## build
mvn clean install

## run
Run the ClaritHsApplication.java as main

## Configuration
- Donwload and install the mongo db from here [download](https://www.mongodb.com/try/download/community-kubernetes-operator)
- update the application.properties file for mongo connections
```
spring.data.mongodb.uri=mongodb://localhost:27017/roomlist
spring.data.mongodb.database=roomlist
```
## External library
- Add all external libraries in the `pom.xml`
