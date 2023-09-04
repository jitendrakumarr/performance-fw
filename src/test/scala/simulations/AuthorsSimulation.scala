package simulations

import io.gatling.core.scenario.Simulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import journey.{AuthorAPIJourney, AuthorAPIJourneyRandomSwitch}

import scala.concurrent.duration._
import scala.language.postfixOps

class AuthorsSimulation extends Simulation {

  val httpConf = http
  val nbUsers = Integer.getInteger("users", 1)
  val myRamp = java.lang.Long.getLong("ramp", 0)

  val author_journey = scenario("Authors API Performance")
    .exec(AuthorAPIJourneyRandomSwitch.authors_journey)

  var testSetup =
    setUp(
      author_journey.inject(
        rampUsers(nbUsers).during(myRamp)
      )
    ).protocols(httpConf)
}