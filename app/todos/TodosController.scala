package todos


import javax.inject.Inject
import play.api._
import play.api.mvc._
import play.api.libs.json.Json
import scala.util.Try
import play.api.data.Form
import play.api.data.Forms._
import scala.concurrent.Future
import java.time.LocalDateTime
import play.api.libs.json.Format


final case class TodoForm(description: String, isDone: Boolean, dueDate: Option[LocalDateTime], orderId: Option[Int])
object TodoForm {
    implicit val format: Format[TodoForm] = Json.format
}

class TodosController @Inject()(val controllerComponents: ControllerComponents) 
    extends BaseController 
    with play.api.i18n.I18nSupport {

    val logger = Logger(this.getClass())
    val form = Form(
        mapping(
            "description" -> nonEmptyText,
            "isDone" -> boolean,
            "dueDate" -> optional(localDateTime("yyyy-MM-dd HH:mm:ss")),
            "orderId" -> optional(number)
        )(TodoForm.apply)(TodoForm.unapply)
    )

    def getAll = Action { implicit request: Request[AnyContent] => 
        logger.debug("Get all todos")
        Ok(Json.toJson(Todo.all()))
    }

    def getById(id: Int) = Action { implicit request: Request[AnyContent] => 
        logger.debug(s"Get todo by $id")
        Ok(Json.toJson(Todo.getById(id)))
    }

    def add = Action { implicit request: Request[AnyContent] => 
        form.bindFromRequest().fold(
            errors => BadRequest(errors.errorsAsJson),
            formData => {
                val todo = Todo.add(formData)
                logger.debug(s"New todo created: ${todo.toString()}")
                Ok(Json.toJson(todo))
            }
        )
    }
    
    def update(id: Int) = Action { implicit request: Request[AnyContent] => 
        form.bindFromRequest().fold(
            errors => BadRequest(errors.errorsAsJson),
            formData => {
                val todoToUpdate = Todo(id, formData.description, formData.isDone, formData.dueDate, formData.orderId.getOrElse(0))
                logger.debug(s"New todo created: ${todoToUpdate.toString()}")
                Ok(Json.toJson(Todo.update(todoToUpdate)))
            }
        )
    }

    def delete(id: Int) = Action { implicit request: Request[AnyContent] => 
        logger.debug(s"Delete todo by $id")
        Ok(Json.toJson(Todo.delete(id)))
    }


}
