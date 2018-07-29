# Description

The goal is to build a URL shortener service similar to the [Google](https://goo.gl/) or [Bitly](https://bitly.com/), using Java, Spring and JPA/Hibernate.

## Requirements

1. The service must have just one JPA entity called Url, backed by a single database table.
2. It must have two controllers:
  1. A CRUD one providing endpoints to create, retrieve, update and delete Url objects using JSON format. When a new Url object is created, the destination URL (e.g. http://www.dailymail.co.uk) will be provided in the request. The response will include the full Url object, including the short code used for the redirect, which must be generated automatically by the service and it's a read only property. How the short code is generated is up to you, but obviously the shorter the better, and there should be no chance of collision with other short codes.
  2. Another one with a single endpoint to perform the actual redirection.

## Sample requests/responses

### For CRUD controller:

#### Create

`POST /url {"url": "http://www.dailymail.co.uk"}` -> 201 with body `{"id": 123456, "url": "http://www.dailymail.co.uk", "shortCode": "W7E"}`

#### Retrieve

`GET /url/123456` -> 200 with body `{"id": 123456, "url": "http://www.dailymail.co.uk", "shortCode": "W7E"}`

#### Update

`PUT /url/123456 {"id": 123456, "url": "http://www.thisismoney.co.uk"}` -> 200  with body `{"id": 123456, "url": "http://www.thisismoney.co.uk", "shortCode": "W7E"}`

#### Delete

`DELETE /url/123456` -> 204

### For redirect controller:

`GET /redirect/W7E` -> 301 with header `Location: http://www.dailymail.co.uk`

## Instructions

A basic Spring Boot set up using Maven is provided. It spins up an H2 in-memory DB instance upon startup and sets up a JPA datasource for it. It's also configured to generate the DB structure out of the JPA/Hibernate entities provided, so no manual DDL statements are required. A `data.sql` file in the resources folder can be used to automatically populate the data upon startup if desired (not required). Created Url objects are not required to survive application restarts for this assignment.

In order to run the application just execute the class `challenge.Application`. You can run the `mvn clean compile exec:java -Dexec.mainClass="challenge.Application"` command if you end up using the provided Maven setup. The listen port is 8080. The H2 web console is available at [http://localhost:8080/h2](http://localhost:8080/h2) while the app is running, the JDBC URL is `jdbc:h2:mem:challenge`, username is `sa` and there's no password.

If you're not familiar with Spring Boot or Maven feel free to use any alternatives (like a non-Boot based Spring set up, Gradle or Ant instead of Maven, etc.). The project however must be written in Java and must use Spring and JPA/Hibernate. Any versions of Spring and Hibernate are acceptable. XML and annotation-based config are acceptable for both as well.

Unit tests must be also provided. You can use any testing framework you like and any helper library.

Clone or download this repository to get started. You can submit your code to your own repository that we can access or send it to us packaged in a single file using zip, tar or any other popular archiving format.
