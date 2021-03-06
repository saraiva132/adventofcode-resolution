/**
 * Created by saraiva on 12/5/15.
 */

import org.scalatest.junit.JUnitSuite
import org.junit._
import resolution5._

class test5 extends JUnitSuite {

  var line : List[String] = _

  @Before def initialize() {
    val PATH = new java.io.File( "." ).getCanonicalPath + "/src/test/resources/input5.txt"
    val source = scala.io.Source.fromFile(PATH)
    line = try source.getLines.toList finally source.close()
  }

  @Test def testProblem5Part1(): Unit = {
    assert(problem5.part1(line) == 255)
  }

  @Test def testProblem5Part2(): Unit = {
    assert(problem5.part2(line) == 55)
  }
}


