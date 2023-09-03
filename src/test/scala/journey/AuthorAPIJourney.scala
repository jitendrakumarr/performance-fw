package journey

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
    //feed(Feeder.phonePrepaid)
    randomSwitch(
      50.0 ->
        exec(
          http("/Authors")
            .get(baseUrl + "/Authors")
            .header("accept", "text/plain; v=1.0")
            .check(status is 200)
        ),
      50.0 ->
        exec(
          http("/Authors")
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
    )
  }
}
