package feeders

import io.gatling.core.Predef.{ _}

object Feeder {

  val contents = csv("data/test_data.csv").random.circular
}