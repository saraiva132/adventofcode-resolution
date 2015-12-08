/**
 * Created by saraiva on 12/5/15.
 */

import org.scalatest.junit.JUnitSuite
import org.junit._
import resolution2._

class test2 extends JUnitSuite {

  var lines : List[String] = _

  @Before def initialize() {
    val PATH = new java.io.File( "." ).getCanonicalPath + "/src/test/resources/input2.txt"
    val source = scala.io.Source.fromFile(PATH)
    lines = try source.getLines.toList finally source.close()
  }

  @Test def testPart1Dummy(): Unit = {
    assert(problem2.calcWrappingPaper(List("3x4x5","1x2x3")) equals 130)
  }

  @Test def testPart2Dummy(): Unit = {
    assert(problem2.calcRibbon(List("3x4x5","1x2x3")) equals 86)
  }

  @Test def testProblem2Part1(): Unit = {
    assert(problem2.calcWrappingPaper(lines) equals 1588178)
  }

  @Test def testProblem2Part2(): Unit = {
    assert(problem2.calcRibbon(lines) equals 3783758)
  }


}
