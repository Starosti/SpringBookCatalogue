# Spring Book Catalogue
A basic book catalogue API made using Spring Boot and Spring JPA, using the PostgreSQL as the DBMS.
Currently, this project features no frontend. API's are defined as follows:

```
Note: replace fields in curly brackets with respective data. Ex: "/api/v1/book/3" to get the book with id 3.

/api/v1
  /author
  |  | GET  -> Get a list of all authors
  |  | POST -> Add an author (use JSON to define fields)
  |  | PUT  -> Edit details of an author (use JSON to define fields) 
  |  |
  |  /{id}
  |    | GET    -> Find an author with ID
  |    | DELETE -> Delete an author with ID
  |
  /book
  |  | GET  -> Get a list of all books
  |  | POST -> Add a book (use JSON to define fields)
  |  | PUT  -> Edit details of a book (use JSON to define fields) 
  |  |
  |  /{id}
  |    | GET    -> Find a book with ID
  |    | DELETE -> Delete a book with ID
  |
  /genre
     | GET  -> Get a list of all genres
     | POST -> Add a genre (use JSON to define fields)
     | PUT  -> Edit details of a genre (use JSON to define fields) 
     |
     /{id}
       | GET    -> Find a genre with ID
       | DELETE -> Delete a genre with ID
```

# Setting Up the Project

Before you run the project, make sure to create the file ```src/main/resources/env.properties``` to define the datasource. Copy the lines from below into the file and replace the sections marked with curly braces:
```properties
DB_URL=jdbc:postgresql://{URL TO DATABASE}
DB_USERNAME={USERNAME OF DB USER}
DB_PASSWORD={PASSWORD OF DB USER}
```

If wanted, the driver and Hibernate dialect in ```application.properties``` can be replaced to use another DBMS.

Then, run the main function in ```src/main/java/com/starosti/springbookcatalogue/SpringBookCatalogueApplication.java```

# Example JSON Request Snippets
An example book defined in JSON:
```json
{
    "author": {
        "id":1
    },
    "genre": {
        "id":2
    },
    "length": 1500,
    "name": "Introduction to Java"
}
```
An example author defined in JSON:
```json
{
  "name":"Starosti"
  "dateOfBirth": "1234-01-23"
}
```
An example genre defined in JSON:
```json
{
  "name":"Java Programming"
}
```

# Example JSON Response Snippets
An example book response defined in JSON:
```json
{
    "author": {
        "dateOfBirth": "1994-07-12",
        "id": 22,
        "name": "Starosti"
    },
    "genre": {
        "id": 24,
        "name": "Java"
    },
    "id": 23,
    "length": 5000,
    "name": "Mastering Spring Core and Spring Boot"
}
```
An example author defined in JSON:
```json
{
    "books": [
        {
            "genre": {
                "id": 24,
                "name": "Java"
            },
            "id": 23,
            "length": 5000,
            "name": "Mastering Spring Core and Spring Boot"
        },
        {
            "genre": {
                "id": 24,
                "name": "Java"
            },
            "id": 25,
            "length": 1500,
            "name": "Introduction to Java"
        }
    ],
    "dateOfBirth": "1994-07-12",
    "id": 22,
    "name": "Starosti"
}
```
An example genre defined in JSON:
```json
{
  "id": 24,
  "name":"Java"
}
```
