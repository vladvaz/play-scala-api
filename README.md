# play-scala-api
Simple REST API using Play Framework and Scala


This API was done as a learning exercise, to learn more about Play Framework and Scala.

The API allows CRUD operations to access a todo list data.

The endpoints allowed are:

- Get all todos: GET `http:localhost:9000/todos`
- Get todo by id: GET `http:localhost:9000/todos/id`
- Create a new todo: POST `http:localhost:9000/todos`
  with a body content like this:
  ```json
  {
    "description": "New Todo",
    "dueDate": "2022-06-07 00:00:00" //optional
  }
  ```
- PUT todo by id: GET `http:localhost:9000/todos/id`
  with a body content like this:
  ```json
  {
    "description": "Updated todo",
    "isDone": true,
    "dueDate": "2022-06-10 00:00:00"
  }
  ```
- Delete todo by id: DELETE `http:localhost:9000/todos/id`
