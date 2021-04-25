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

    val maxSeatId = input.map(seatId).max

    println(s"answer: ${maxSeatId}")

  }

}