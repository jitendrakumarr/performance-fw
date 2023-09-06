package utils

import com.typesafe.config.ConfigFactory


/*
* @Author Jitendra Kumar
* @Date 31/08/23 14:24 PM
* this class is used to read and set config values at run time as per the environment selection.
* */
object Config {
  // -D params from mvn test command
  var environment = System.getProperty("env")

  // Load our own config values from the default location, src/test/resources/ -> <env>.conf
  var conf = ConfigFactory.load(environment.toLowerCase() + ".conf");

/*these config keys are used for adding baseUrl to the requests as per environment selection.*/
  def getHost(): String = {
    return conf.getString("host")
  }

  def getVersion(): String = {
    return conf.getString("version")
  }

/*this method will be used if we need to fetch something from config file using the key*/
  def getKey(key:String): String = {
    return conf.getString(key)
  }

}
