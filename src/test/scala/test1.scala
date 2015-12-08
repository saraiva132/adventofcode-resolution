/**
 * Created by saraiva on 12/5/15.
 */

import org.scalatest.junit.JUnitSuite
import org.junit._
import resolution1._

class test1 extends JUnitSuite {

  var lines : String = _

  @Before def initialize() {
    val PATH = new java.io.File( "." ).getCanonicalPath + "/src/test/resources/input1.txt"
    val source = scala.io.Source.fromFile(PATH)
    lines = try source.mkString finally source.close()
  }

  @Test def testPart1Dummy(): Unit = {
    assert(problem1.countFloors("(())") equals 0)
  }

  @Test def testPart2Dummy(): Unit = {
    assert(problem1.findCharacter("(())))(") equals 5)
  }

  @Test def testProblem1Part1(): Unit = {
    assert(problem1.countFloors(lines) equals 280)
  }

  @Test def testProblem1Part2(): Unit = {
    assert(problem1.findCharacter(lines) equals 1797)
  }
}
