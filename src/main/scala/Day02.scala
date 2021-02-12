import scala.io.Source

object Day02 {

  // OK, it is time to learn Regex.
  def parse(line: String): (Range.Inclusive, Char, String) = {
    val lineSplit: Array[String] = line.split(' ')

    val rangeSplit = lineSplit(0).split('-')
    val range = Range.inclusive(rangeSplit(0).toInt, rangeSplit(1).toInt)
    val char = lineSplit(1).replace(":", "").toCharArray()(0)
    val pass = lineSplit(2)

    (range, char, pass)
  }


  val input: List[(Range.Inclusive, Char, String)] =
    Source
      .fromFile("src/test/resources/input02.txt")
      .getLines
      .map(parse(_))
      .toList

  def isValid(range: Range.Inclusive, char: Char, pass: String): Boolean = {
    range.contains(pass.count(_ == char))
  }

  // Could make isValid receive a tuple or a type or some sort of partial technique?
  def countValidPasswords(): Int =
    input
      .map(t => isValid(t._1, t._2, t._3))
      .filter(_ == true)
      .length

  def main(args: Array[String]): Unit = {
    println(s"Answer: ${countValidPasswords}")
  }
}