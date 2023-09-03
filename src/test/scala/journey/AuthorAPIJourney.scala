package journey

import feeders.Feeder
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.Config


/**
 * @Author Jitendra Kumar
 * @Date 31/08/23 14:24 PM
 */
object AuthorAPIJourney {

  var baseUrl = Config.getHost() + Config.getVersion()

  def authors_journey = {
    feed(Feeder.test_data)
      .exec(
        http("GET /Authors")
          .get(baseUrl + "/Authors")
          .header("accept", "text/plain; v=1.0")
          .check(status is 200)
      )
      .exec(
        http("POST /Authors")
          .post(baseUrl + "/Authors")
          .header("accept", "text/plain; v=1.0")
          .header("Content-Type", "application/json")
          .body(StringBody(
            """{
              |  "id": 0,
              |  "idBook": 0,
              |  "firstName": "string",
              |  "lastName": "string"
              |}""".stripMargin)).asJson
          .check(status is 200)
      )
      .exec(
        http("GET /Authors/authors/books/{book_id}")
          .get(baseUrl + "/Authors/authors/books{book_id}")
          .header("accept", "text/plain; v=1.0")
          .header("Content-Type", "application/json")
          .check(status is 200)
      )
      .exec(
        http("GET /Authors/{author_id}")
          .get(baseUrl + "/Authors/{author_id}")
          .header("accept", "text/plain; v=1.0")
          .header("Content-Type", "application/json")
          .check(status is 200)
      )
      .exec(
        http("PUT /Authors/{author_id}")
          .put(baseUrl + "/Authors/{author_id}")
          .header("accept", "text/plain; v=1.0")
          .header("Content-Type", "application/json")
          .body(StringBody(
            """{
              |  "id": 0,
              |  "idBook": 0,
              |  "firstName": "string",
              |  "lastName": "string"
              |}""".stripMargin)).asJson
          .check(status is 200)
      )
      .exec(
        http("Delete /Authors/{author_id}")
          .delete(baseUrl + "/Authors/{author_id}")
          .header("accept", "text/plain; v=1.0")
          .header("Content-Type", "application/json")
          .check(status is 200)
      )
  }
}
