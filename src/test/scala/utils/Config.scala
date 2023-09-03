package utils

import com.typesafe.config.ConfigFactory

object Config {
  // -D params from mvn test command
  var environment = System.getProperty("env")
  print("Starting test on environment::" + environment +"\n")
  // Load our own config values from the default location, src/test/resources/ -> <env>.conf
  var conf = ConfigFactory.load(environment.toLowerCase() + ".conf");

  def getHost(): String = {
    return conf.getString("host")
  }
  def getVersion(): String = {
    return conf.getString("version")
  }

  def getKey(key:String): String = {
    return conf.getString(key)
  }

}
