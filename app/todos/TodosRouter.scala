package todos

import javax.inject.Inject

import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter
import play.api.routing.sird._

/**
  * Routes and URLs to the PostResource controller.
  */
class TodosRouter @Inject()(controller: TodosController) extends SimpleRouter {

  override def routes: Routes = {
    case GET(p"/") =>
        controller.getAll
      
    case GET(p"/${int(id)}") =>
        controller.getById(id)

    case POST(p"/") =>
        controller.add

    case PUT(p"/${int(id)}") =>
        controller.update(id)

    case DELETE(p"/${int(id)}") =>
        controller.delete(id)
  }

}

