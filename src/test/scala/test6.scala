/**
 * Created by saraiva on 12/8/15.
 */
import org.scalatest.junit.JUnitSuite
import org.junit._
import resolution6._

class test6 extends JUnitSuite {

  var line : List[String] = _

  @Before def initialize() {
    val PATH = new java.io.File( "." ).getCanonicalPath + "/src/test/resources/input6.txt"
    val source = scala.io.Source.fromFile(PATH)
    line = try source.getLines.toList finally source.close()
  }

  @Test def testProblem6Part1(): Unit = {
    assert(problem6.part1(line) == 569999)
  }

  @Test def testProblem6Part2(): Unit = {
    assert(problem6.part2(line) == 17836115)
  }
}


