package feeders

import io.gatling.core.Predef.{ _}

/*
* @Author Jitendra Kumar
* @Date 31/08/23 14:24 PM
* this class is used to read and set feeder according to our requirement, we can create multiple feeders and utilise in our api journey.
* */

object Feeder {
// this is just an example feeder for the Authors api, we can also rename the file to some meaningful name.
  val test_data = csv("data/test_data.csv").random.circular
}