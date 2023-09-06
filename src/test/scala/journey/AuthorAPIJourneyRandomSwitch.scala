package journey

import feeders.Feeder
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import utils.{Config, RandomUtil}

/**
 * @Author Jitendra Kumar
 * @Date 31/08/23 14:24 PM
 *
 * This is used to generate load with weightage to each API or set of API.
 */
object AuthorAPIJourneyRandomSwitch {

  var baseUrl = Config.getHost() + Config.getVersion()

  def authors_journey = {
    feed(Feeder.test_data)
    randomSwitch(

      10.0 ->
        exec(
          http("GET /Authors")
            .get(baseUrl + "/Authors")
            .header("accept", "text/plain; v=1.0")
            .check(status is 200)
        ),

      10.0 ->
        exec(
          http("POST /Authors")
            .post(baseUrl + "/Authors")
            .header("accept", "text/plain; v=1.0")
            .header("Content-Type", "application/json")
            .body(StringBody(
              s"""{
                |  "id": 0,
                |  "idBook": 0,
                |  "firstName": "${RandomUtil.generateRandomString(7)}",
                |  "lastName": "${RandomUtil.generateRandomString(7)}"
                |}""".stripMargin)).asJson
            .check(status is 200)
        ),

      10.0 ->
        exec(
          http("GET /Authors/authors/books/${book_id}")
            .get(baseUrl + "/Authors/authors/books/${book_id}")
            .header("accept", "text/plain; v=1.0")
            .header("Content-Type", "application/json")
            .check(status is 200)
        ),

      20.0 ->
        exec(
          http("GET /Authors/${author_id}")
            .get(baseUrl + "/Authors/${author_id}")
            .header("accept", "text/plain; v=1.0")
            .header("Content-Type", "application/json")
            .check(status is 200)
        ),

      20.0 ->
        exec(
          http("PUT /Authors/${author_id}")
            .put(baseUrl + "/Authors/${author_id}")
            .header("accept", "text/plain; v=1.0")
            .header("Content-Type", "application/json")
            .body(StringBody(
              s"""{
                |  "id": 0,
                |  "idBook": 0,
                | "firstName": "${RandomUtil.generateRandomString(7)}",
                |  "lastName": "${RandomUtil.generateRandomString(7)}"
                |}""".stripMargin)).asJson
            .check(status is 200)
        ),

      20.0 ->
        exec(
          http("Delete /Authors/${author_id}")
            .delete(baseUrl + "/Authors/${author_id}")
            .header("accept", "text/plain; v=1.0")
            .header("Content-Type", "application/json")
            .check(status is 200)
        )

    )
  }
}
