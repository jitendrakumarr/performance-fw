package simulations

import io.gatling.core.scenario.Simulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import journey.{AuthorAPIJourney, AuthorAPIJourneyRandomSwitch}

import scala.concurrent.duration._
import scala.language.postfixOps
/**
 * @Author Jitendra Kumar
 * @Date 31/08/23 14:24 PM
 *
 * this is our simulation class where we utilise our API journey and simulate the required load. */
class AuthorsSimulation extends Simulation {

  val httpConf = http
  // getting these values from mvn argument.
  val nbUsers = Integer.getInteger(System.getProperty("users"))
  val myRamp = java.lang.Long.getLong(System.getProperty("ramp"))

  // generating a scenario using our API journey.
  val author_journey = scenario("Authors API Performance")
    .exec(AuthorAPIJourney.authors_journey)

  // providing load to the scenario using rampUsers injectors.
  var testSetup =
    setUp(
      author_journey.inject(
        // using runtime params to generate required load, but if we have to generate a complex load we can also utilise other injectors in this block.
        rampUsers(nbUsers).during(myRamp seconds)
      )
    ).protocols(httpConf)
}