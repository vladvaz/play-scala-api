package todos

import play.api.libs.json.{ Format, Json }
import java.time.LocalDateTime


final case class Todo(id: Int, description: String, isDone: Boolean, dueDate: Option[LocalDateTime], orderId: Int)

object Todo {
    implicit val format: Format[Todo] = Json.format

    var i = 6
    var todos = Array(
            Todo(1, "Buy pizza", false, Some(LocalDateTime.now().plusDays(3)), 1),
            Todo(2, "Create a Rest API", false, Some(LocalDateTime.now().plusDays(2)), 2),
            Todo(3, "Don't forget to log works hours", true, Some(LocalDateTime.now().plusDays(7)), 4),
            Todo(4, "Build a todo app with Svelte", true, Some(LocalDateTime.now().plusDays(4)), 3),
            Todo(5, "Get train tickets", true, Some(LocalDateTime.now().plusDays(1)), 4),
            Todo(6, "Pay bills", false, Some(LocalDateTime.now().plusDays(6)), 4),
        )

    def all() = todos

    def getById(id: Int) = todos.filter(_.id == id)

    def add(todoForm: TodoForm) = {
        i = i + 1
        val todo = Todo(i, todoForm.description, todoForm.isDone, todoForm.dueDate, 0)
        todos = todos :+ todo
        todo
    }

    def update(updatedTodo: Todo) = {
        val index = todos.indexWhere(todo => todo.id == updatedTodo.id)
        index match {
            case -1 => 0
            case _ => {
                todos.update(index, updatedTodo)
                1
            }
        }
    }

    def delete(id: Int) = {
        todos = todos.filter(_.id != id)
        1
    }
    
}