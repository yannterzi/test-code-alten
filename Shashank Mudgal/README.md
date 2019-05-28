
Expedia flight search test to Armaan 

To run:

    Run as Springboot application. 
    Via terminal/command : mvn spring-boot:run
    Via IDE : Right click on the project (after importing it in an IDE) and run as Springboot app.

The rest API will be available at:

    http://localhost:8080

## API

Search a flight at a given time.

    GET /flight   
    Query parameter  time
    
Example : http://localhost:8080/flight?time=17:00

Kindly note, I am following 24 hour clock to remove ambiguity of AM/PM format. Please enter the time accordingly.
    
   