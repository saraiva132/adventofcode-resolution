package resolution4

import java.security.MessageDigest

/**
 * Created by saraiva on 12/5/15.
 */
object problem4 {

  def lowestPositiveNumber(line : String, pattern : String) = {
    def digest(in: String): String = MessageDigest.getInstance("MD5").digest(in.getBytes).map("%02x".format(_)).mkString
    Iterator.from(1).find(it => {
      digest(line + it.toString).startsWith(pattern)}).getOrElse(-1)
  }
}
