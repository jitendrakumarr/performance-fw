package simulations

import io.gatling.core.scenario.Simulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import journey.AuthorAPIJourney

import scala.concurrent.duration._

class AuthorsSimulation extends Simulation {

  val httpConf = http

  val author_journey = scenario("Authors API Performance")
    .exec(AuthorAPIJourney.authors_journey)


  var testSetup =
    setUp(
      author_journey.inject(
        constantConcurrentUsers(1) during (1), //Constant 1 user for 1 seconds
      )
    ).protocols(httpConf)

  /*
  Other Thread load options.
  constantConcurrentUsers(100) during (1 minutes),  //Constant 100 user for 1 minute
  constantConcurrentUsers(250) during (1 minutes), //Constant 250 user for next 1 minute
  rampConcurrentUsers(500) to (2000) during (5 minutes), //Rampup 500-2000 in given minutes user.
  constantConcurrentUsers(2000) during (1 minutes), // Holding 2000 Users for 1 minute
  rampConcurrentUsers(2000) to (0) during (15 seconds) // Rampup 2000-0 in given minutes user.
*/

}