/**
 * Created by saraiva on 12/5/15.
 */
/**
 * Created by saraiva on 12/5/15.
 */

import org.scalatest.junit.JUnitSuite
import org.junit._
import resolution4._

class test4 extends JUnitSuite {

  var line : String = _

  @Before def initialize() {
    val PATH = new java.io.File( "." ).getCanonicalPath + "/src/test/resources/input4.txt"
    val source = scala.io.Source.fromFile(PATH)
    line = try source.mkString finally source.close()
  }

  @Test def testProblem4Part1(): Unit = {
    assert(problem4.lowestPositiveNumber(line,"00000") == 282749)
  }

  @Test def testProblem4Part2(): Unit = {
    assert(problem4.lowestPositiveNumber(line,"000000") == 9962624)
  }

}


