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

  // Range does not express exactly what is needed to this function: two positions, maybe two Ints or a type Positions, too late now ;)
  def isValidForTwoPositionsPolicy(range: Range.Inclusive, char: Char, pass: String): Boolean = {
    val respectsFirstPosition = pass.charAt(range.start - 1) == char
    val respectsSecondPosition = pass.charAt(range.end- 1) == char

    respectsFirstPosition != respectsSecondPosition
  }

  def countValidPasswords(f: (Range.Inclusive, Char, String) => Boolean): Int =
    input.count(t => f(t._1, t._2, t._3))

  def main(args: Array[String]): Unit = {
    println(s"Answer Part 1: ${countValidPasswords(isValid)}")
    println(s"Answer Part 2: ${countValidPasswords(isValidForTwoPositionsPolicy)}")
  }
}