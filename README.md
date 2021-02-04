# Spring-Rest-Database
Spring REST application which stores peoples information into a database.

## Prerequisites
This application requires the user to have the following technologies
- Java 8 or higher
- Maven installed
- cURL or more preferrably Postman


## Files Supplied
Some extra files are supplied with the project
- A JSON File which contains the request and the JSON belonging to the requests which can be used to test the application. They are divided up into their individual use cases. File is called JSON-Requests.json and can be found in the ExampleJSON folder.
- Images to help describe different parts of the application are supplied. They can be found in the Images folder

## Project Separation
The files were separated out into relevant packages 
- controller
- model
- repsoitory
- service

See image Project-Structure.png for visualisation of this

## Technologies Used

### Development
- Spring Boot
- Spring JPA
- Spring Web
- H2 Database
- Maven
- Java 8
- IntelliJ

### Testing
- Postman
- Browser

### Why These Were Chosen
- Spring Boot for rapid application development, important due to the time restrictions on the project
- Spring JPA again provides rapid development for database operations 
- Spring web for rapid application development of REST requests
- H2 database was chosen as it's a database which doesn't need installation and that was required for the project. It's an embedded in-memory database. Can be downloaded as a dependency for Spring so very fast to get up and running
- Maven handles dependencies and project management
- Java 8 as it's the version of Java I've been personally using and it's a LTS version with support until 2030
- IntelliJ is my personal IDE of choice
- Postman as it's a popular application when working with REST architectures and has a range of features which aids in manually testing

## Missing Elements
There are some parts which are not implemented or not fully implemented due to time contraints. 
- Unit Tests
- Error Handling
- Validation (1 small example is included) 

## Issues
As this application was put together so quickly there are some issues with it.
- If an address is belonging a to person it can not be deleted directly due to referential integrity
  - Address does get deleted when the person is deleted (It cascades)
  - If an address has been added and not tied to a person it can be deleted
- Not as much work was put into the address as into the person due to time restraints
  - The POST request is used for updating as well as creating in the address, whereas, the PUT is used for updating the Person. 
  - With more time the address would be brought in alignment with the person in this regard.

## Use Cases
The requests and JSON required to perform these use cases are found in the JSON-Requests.json file.

- **Add Person**
  - POST - http://localhost:8080/person
- **Edit Person**
  - PUT http://localhost:8080/person
- **Delete Person**
  - DELETE http://localhost:8080/person/{id}
  - This cascades and will delete associated addresses also
- **Add Address To Person**
  - PUT - http://localhost:8080/person
  - An address can be added directly to the address table but will not have a relationship with a person
- **Edit Address**
  - POST - http://localhost:8080/address
  - Did not get to implement PUT for update of addresses
- **Delete Adddress**
  - DELETE http://localhost:8080/address/{id}
  - If address is belonging to person it can not be deleted directly due to referential integrity   constraint
- **Count Number Of Persons**
  - GET http://localhost:8080/person/count
- **List Persons**
  - GET http://localhost:8080/person
- **List Specific Person**
  - GET http://localhost:8080/person/{id}
- **Validation**
  - POST http://localhost:8080/person
  - Only one example included
  - Checks if the ID already exists and returns BAD REQUEST if it does

## Running The Spring Application
First download the application from GitHub or if you have the project already then use one of the following two methods.

1. Open the project in IntelliJ and select "**Run**" and choose "**PersondbApplication**"
2. From the command-line, navigate to the folder "**persondb**" folder and run the command **./mvnw spring-boot:run**

This will get the server up and running. See the image called SpringOutput.png from the Images folder for example of the console output

## Running The H2 Database

You first need to get the Spring application running at which point you can log into the H2 Database through the H2 Console. This can be done in the following way.

1. Paste the following link into your browser http://localhost:8080/h2-console
   1. This should bring up the console, see image H2-Console.png for example
2. You need to paste the following strings into the text boxes
   1. In **JDBC URL** paste **jdbc:h2:mem:persondb**
   2. In **Username** paste **chris**
   3. These can be seen in the H2-Console.png image for clarity
3. Press the connect button and it should log you in
   1. Once you are in it will look like the image H2-Database.png
4. From here you can input SQL and run it against the Person, Address and Person_Addresses table

* Note: The connection details for logging into the H2 Database are found in the application.properties file in the resources folder **persondb/src/main/resources/application.properties**
* Note: All data is lost when application is shut down as this is an in-memory database. To persist data it would be best to swap out the database for some other SQL database such as PostgreSQL