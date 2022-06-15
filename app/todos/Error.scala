package todos

import play.api.libs.json.{ Format, Json }

final case class Error(message: String)

object Error {
    implicit val format: Format[Error] = Json.format
}
