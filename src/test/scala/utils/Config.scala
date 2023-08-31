package utils

import com.typesafe.config.ConfigFactory

object Config {
  // -D params from mvn test command
  var environment = System.getProperty("env")
  print("Starting test on environment::" + environment +"\n")
  // Load our own config values from the default location, src/test/resources/config -> <env>.conf
  var conf = ConfigFactory.load(environment.toLowerCase() + ".conf");

  def getHost(): String = {
    return conf.getString("host_url")
  }
  def getKey(key:String): String = {
    return conf.getString(key)
  }

}
