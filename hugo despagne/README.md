# dropwizard-expedia Requirement 1
Requirement 1 for the Expedia Code Test.  
Tried to stick to the 4 hours limit, but was probably more around 5.

## Stack
[DropWizard](https://www.dropwizard.io)  or on [GitHub](https://github.com/dropwizard/dropwizard)  
[Org.json](https://mvnrepository.com/artifact/org.json/json) To parse the JSON data given for the requirement  
Unit Test libraries :
[JUnit 5](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine)
[AssertJ](https://mvnrepository.com/artifact/org.assertj/assertj-core)
[Mockito](https://mvnrepository.com/artifact/org.mockito/mockito-core)

## Resources
The only resources from which copy-past part could be found is the official "get started" tutorial from dropWizard :
> https://www.dropwizard.io/0.9.1/docs/getting-started.html

## Launch
The application JAR is created with the "package" maven goal.
Everything is packaged in a "fat jar" to allow for a single deployable artifact.  

The REST server is launched with the command  
 >*java -jar target/dropwizard-expedia-1.0-SNAPSHOT.jar server config.yml*.  

Service can then be accessed through :  
> http://localhost:8080/flights Return all flights  
> http://localhost:8080/flights?departureSearchDate=5:00PM Return all flights within plus/minus 5 hours of 5:00PM
