package resolution3

/**
 * Created by saraiva on 12/5/15.
 */
object problem3 {

    private[this] implicit class TuppleAdd(t: (Int, Int)) {
      def +(p: (Int, Int)) = (p._1 + t._1, p._2 + t._2)
    }

    private[this] def moveSanta(direction : Char, p : (Int,Int)) = direction match {
      case '^' => (0,1)
      case '<' => (-1,0)
      case '>' => (1,0)
      case 'v' => (0,-1)
      case _ => (0,0)
    }

    //houses gone by santa alone
    def houses(lines : String ) =
      lines.scanLeft((0,0)) {(z,x) => z + moveSanta(x,z)}.distinct.length

    def housesByBoth(lines: String) = {
      //Santa goes one way
      def santahouses(lines: String) =
        lines.grouped(2).map(_.head).toList.scanLeft((0, 0)) { (z, x) => z + moveSanta(x, z) }
      //Robot goes the other
      def robothouses(lines: String) =
        lines.drop(1).grouped(2).map(_.head).toList.scanLeft((0, 0)) { (z, x) => z + moveSanta(x, z) }

      (santahouses(lines) ++ robothouses(lines)).distinct.length
    }
}

