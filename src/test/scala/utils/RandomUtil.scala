package utils
import java.security.SecureRandom

/*
* @Author Jitendra Kumar
* @Date 5/09/23 14:24 PM
* this class is used to generate random string in our API requests.
* */
object RandomUtil {
  private val random = new SecureRandom

  /* this method will generate and return a random string of given length */
  def generateRandomString(length: Int): String = {
    val text = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
    val sb = new StringBuilder(length)
    for (i <- 0 until length) {
      sb.append(text.charAt(random.nextInt(text.length)))
    }
    sb.toString
  }
}