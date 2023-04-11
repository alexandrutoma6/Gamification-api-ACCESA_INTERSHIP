# Gamification-api-ACCESA_INTERSHIP
This is an API for a gamification project

The tools used:
Spring Boot framework to create the REST API
Maven to manage the project dependencies and build application
PostgreSQL for database, to o store and retrieve data from your REST API
Postman for testing

The application can send POST mappings to create a user, a quest or an assignment (the assignment needs a user and a quest to be created)
GET mappings can also be sent to check the database, and DELETE mappings to delete objects from the database
The functionality of winning tokens is realized at the moment when the status of the assignment changes to "done".
Then the user is allocated (in addition to what he had) the tokens earned from the completed quest (the reward).
