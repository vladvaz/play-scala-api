# play-scala-api

## Simple REST API using Play Framework and Scala.


This API was done as a learning exercise, to learn more about Play Framework and Scala.

The API allows CRUD operations to access a todo list data.

The endpoints are:

- Get all todos: **GET** `http:localhost:9000/todos`
- Get todo by id: **GET** `http:localhost:9000/todos/id` (Note: id must be an integer)
- Create a new todo: **POST** `http:localhost:9000/todos`

  passing a json in the body:
  ```json
  {
    "description": "New Todo",
    "dueDate": "2022-06-07 00:00:00" //optional
  }
  ```
- **PUT** todo by id: GET `http:localhost:9000/todos/id` (Note: id must be an integer)

  passing a json in the body:
  ```json
  {
    "description": "Updated todo",
    "isDone": true,
    "dueDate": "2022-06-10 00:00:00"
  }
  ```
- Delete todo by id: **DELETE** `http:localhost:9000/todos/id` (Note: id must be an integer)


# Run the API

## Pre-requisites
- Java 8 or 11
- sbt

This page has information on how to install the tools needed: https://docs.scala-lang.org/getting-started/index.html

## Start the API

In the terminal run the following command:

```bash
sbt run
```

You can test the API using curl or another tool like Postman.