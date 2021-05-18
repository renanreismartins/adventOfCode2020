import scala.io.Source

object Day06 {

  def main(args: Array[String]): Unit = {
    /*val input =
      """abc
        |
        |a
        |b
        |c
        |
        |ab
        |ac
        |
        |a
        |a
        |a
        |a
        |
        |b
        |""".stripMargin*/

    val input = Source.fromFile("src/test/resources/input06.txt").mkString

    val split: Array[String] = input.split("\n\n")
    val groupedLetters: Array[Array[String]] = split.map(_.split("").filter(_ != "\n"))
    val groups: Seq[Map[String, Int]] = groupedLetters.foldLeft(Seq[Map[String, Int]]())((maps, letters) => maps :+ lettersToMap(letters))

    val part1 = groups
      .flatten
      .groupMapReduce(_._1)(_._2)(_ + _)
      .values
      .sum

    println(s"part 1: $part1")
  }

  def lettersToMap(letters: Array[String]): Map[String, Int] = {
    letters.foldLeft(Map[String, Int]())((map, letter) => map + (letter -> 1))
  }
}