import scala.io.Source

object Day05 {
  def seatId(steps: Seq[Char]): Int = (findLine(steps.take(7)) * 8) + findColumn(steps.takeRight(3))

  def findLine(steps: Seq[Char]): Int = steps.foldLeft(0 to 127: Range)((region, step) => walkLine(step, region)).start

  def walkLine(step: Char, region: Range): Range = {
    val splitRegion = region.splitAt(region.length / 2)
    if (step == 'F') splitRegion._1 else splitRegion._2
  }


  def findColumn(steps: Seq[Char]): Int = steps.foldLeft(0 to 7: Range)((region, step) => walkColumn(step, region)).start

  // walkColumn and walkLine can be generalised later
  // Maybe the return should be an Either[Range, Int]
  def walkColumn(step: Char, columns: Range): Range = {
    val splitColumns = columns.splitAt(columns.length / 2)
    if (step == 'L') splitColumns._1 else splitColumns._2
  }

  def main(args: Array[String]): Unit = {
    val input: Seq[Seq[Char]] = Source.fromFile("src/test/resources/input05.txt")
      .getLines()
      .map(_.toCharArray.toSeq)
      .toSeq

    val seats = input.map(seatId)
    val maxSeatId = seats.max


    val mySeat: Option[Int] = seats.foldLeft(Option.empty[Int]) {
      case (None, id) if !seats.contains(id + 1) && seats.contains(id + 2) => Some(id + 1)
      case (acc, _) => acc
    }

    val mySeat2 = seats
      .sorted
      .sliding(2)
      .filter(e => e(0) + 1 != e(1))
      .map {
        case Seq(a, _) => Some(a + 1)
        case _ => None
      }
      .next()


    println(seats.filter(s => s == 90))
    println(s"answer: $maxSeatId")
    println(s"answer 2: $mySeat2")

  }

}