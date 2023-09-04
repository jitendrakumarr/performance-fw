package utils
import java.security.SecureRandom

object RandomUtil {
  private val random = new SecureRandom

  def generateRandomString(length: Int): String = {
    val text = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
    val sb = new StringBuilder(length)
    for (i <- 0 until length) {
      sb.append(text.charAt(random.nextInt(text.length)))
    }
    sb.toString
  }
}