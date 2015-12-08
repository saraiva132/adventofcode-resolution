/**
 * Created by saraiva on 12/5/15.
 */

import org.scalatest.junit.JUnitSuite
import org.junit._
import resolution3._

class test3 extends JUnitSuite {

  var lines : String = _

  @Before def initialize() {
    val PATH = new java.io.File( "." ).getCanonicalPath + "/src/test/resources/input3.txt"
    val source = scala.io.Source.fromFile(PATH)
    lines = try source.mkString finally source.close()
  }

  @Test def testPart1Dummy(): Unit = {
    assert(problem3.houses("<^<^") == 5)
  }

  @Test def testPart2Dummy(): Unit = {
    assert(problem3.housesByBoth("<><><>") == 7)
  }

  @Test def testProblem3Part1(): Unit = {
    assert(problem3.houses(lines) == 2565)
  }

  @Test def testProblem3Part2(): Unit = {
    assert(problem3.housesByBoth(lines) == 2639)
  }

}

