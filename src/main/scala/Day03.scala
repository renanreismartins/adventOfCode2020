import scala.io.Source

object Day03 {
  def countTrees(lines: Seq[String], stepsToRight: Int = 3) =
    lines
      .zipWithIndex
      .count {
        case (line, index) =>
          val lineWidth = 31
          isTree(line, (index * stepsToRight) % lineWidth)
      }

  def isTree(line: String, x: Int) = line.charAt(x) == '#'

  def main(args: Array[String]): Unit = {
    val input: Seq[String] =
      Source
        .fromFile("src/test/resources/input03.txt")
        .getLines
        .toSeq

    println(s"Answer Part 1: ${countTrees(input)}")
  }
}