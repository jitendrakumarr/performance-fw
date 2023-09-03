package simulations

import io.gatling.core.scenario.Simulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import journey.{AuthorAPIJourney, AuthorAPIJourneyRandomSwitch}

import scala.concurrent.duration._
import scala.language.postfixOps

class AuthorsSimulation extends Simulation {

  val httpConf = http

  val author_journey = scenario("Authors API Performance")
    .exec(AuthorAPIJourney.authors_journey)


  var testSetup =
    setUp(
      author_journey.inject(
        constantConcurrentUsers(2) during (1 seconds), //Constant 1 user for 1 seconds
      )
    ).protocols(httpConf)
}