package resolution5

/**
 * Created by saraiva on 12/8/15.
 */
object problem5 {
    private def expression(pattern : String) : String => Boolean = pattern.r.unanchored.findFirstIn(_).isDefined

    private val threeVowels : String => Boolean = expression("""([aeiou].*){3}""")
    private val repeatedOne : String => Boolean = expression("""(\w)\1+""")
    private val notContains : String => Boolean = expression("""(ab|cd|pq|xy)""").andThen(!_)

    def part1(lines : List[String]) = {
      def validateFirst(line: String) = threeVowels(line) && repeatedOne(line) && notContains(line)
      lines.count(validateFirst(_))
    }

    private val anyPair : String => Boolean = expression("""(\w)(\w).*\1\2""")
    private val repeatedOneMiddle : String => Boolean = expression("""(\w)\w\1""")

    def part2(lines : List[String]) = {
      def validateSecond(line: String) = anyPair(line) && repeatedOneMiddle(line)
      lines.count(validateSecond(_))
    }
}
