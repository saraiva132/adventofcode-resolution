package resolution1

/**
 * Created by Rafael Saraiva on 12/1/15.
 */
object problem1 {

  //Modular approach. This allows complex pattern matching
  private[this] def processChar(c: Char): Int = c match {
    case '(' => +1
    case ')' => -1
    case _ => 0
  }

  def countFloors(lines: String) = {
    lines.count(it => it equals '(') - lines.count(it => it equals ')')
  }

  def findCharacter(lines: String) =
    lines.
      scanLeft(0)((z, x) => z + processChar(x)).
      takeWhile(_ != -1).
      length

  implicit private[this] def StringToCharArray(lines: String): Array[Char] = lines.toCharArray
}
