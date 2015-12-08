package resolution2

/**
 * Created by Rafael Saraiva on 12/2/15.
 */
object problem2 {

  def calcWrappingPaper(lines : List[String]) = {
    def WrappingPaper(line: String) = {
      def smallestArea(values: List[Array[Int]]) = values.map(it => it.foldLeft(1) { (z, x) => z * x }).min
      val Array(l, w, h) = line.split("x").map(_.toInt)
      (2 * l * w) + (2 * w * h) + (2 * h * l) + smallestArea(Array(l, w, h).combinations(2).toList)
    }
    lines.foldLeft(0){ (z,x) => z + WrappingPaper(x)}
  }

  def calcRibbon(lines : List[String]) = {
    def Ribbon(line: String) = {
      def smallestPerimeter(values: List[Array[Int]]) = values.map(it => it.foldLeft(0) { (z, x) => z + (2 * x) }).min
      val Array(l, w, h) = line.split("x").map(_.toInt)
      (l * w * h) + smallestPerimeter(Array(l, w, h).combinations(2).toList)
    }
    lines.foldLeft(0){ (z,x) => z + Ribbon(x)}
  }

}

