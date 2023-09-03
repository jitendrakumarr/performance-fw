package feeders

import io.gatling.core.Predef.{ _}

object Feeder {

  val test_data = csv("data/test_data.csv").random.circular
}