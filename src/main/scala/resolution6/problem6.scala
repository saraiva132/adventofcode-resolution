package resolution6

/**
 * Created by saraiva on 12/8/15.
 */
object problem6 {

  def applyOperation(cur : Boolean, op : Int) : Boolean = op match{
    case 0 => false
    case 1 => true
    case 2 => !cur
    case _ => false
  }

  def findOperation(line : String) : (Int,String) = line match{
    case s if s.startsWith("turn off") => (0, s.stripPrefix("turn off "))
    case s if s.startsWith("turn on") => (1, s.stripPrefix("turn on "))
    case s if s.startsWith("toggle") => (2, s.stripPrefix("toggle "))
    case _ => (3,line)
  }

  def parseInstruction(lightMatrix: Array[Array[Boolean]], line : String ) = {
    val op = findOperation(line)
    val args = op._2.split(" ")
    val pos1 = args(0).split(",")
    val pos2 = args(2).split(",")

    for{
      a <- pos1(0).toInt to pos2(0).toInt
      b <- pos1(1).toInt to pos2(1).toInt
    } lightMatrix(a)(b) = applyOperation(lightMatrix(a)(b), op._1)
    lightMatrix
  }

  def part1(lines : List[String]) = {
    var lightMatrix = Array.ofDim[Boolean](1000,1000)
    lines.foreach( line => lightMatrix = parseInstruction(lightMatrix,line))
    lightMatrix.foldLeft(0) {(z,x) => z + x.count(_ equals true)}
  }

  def applyBrightness(cur : Int, op : Int) : Int = op match{
    case 0 => if(cur equals 0) 0 else cur - 1
    case 1 => cur + 1
    case 2 => cur + 2
    case _ => cur
  }

  def parseInstructionPart2(lightMatrix: Array[Array[Int]], line : String ) = {
    val op = findOperation(line)
    val args = op._2.split(" ")
    val pos1 = args(0).split(",")
    val pos2 = args(2).split(",")

    for{
      a <- pos1(0).toInt to pos2(0).toInt
      b <- pos1(1).toInt to pos2(1).toInt
    } lightMatrix(a)(b) = applyBrightness(lightMatrix(a)(b), op._1)
    lightMatrix
  }

  def part2(lines : List[String]) = {
    var lightMatrix = Array.ofDim[Int](1000,1000)
    lines.foreach( line => lightMatrix = parseInstructionPart2(lightMatrix,line))
    lightMatrix.foldLeft(0) {(z,x) => z + x.sum}
  }

}
