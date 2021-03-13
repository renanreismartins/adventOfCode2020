import scala.io.Source

object Day03 {
//  def countTrees(lines: Seq[String], stepsToRight: Int = 3, stepsDown: Int = 1) = {
//    val lineWidth = lines(0).size
//    lines
//      .zipWithIndex
//      .count {
//        case (line, index) =>
//          isTree(line, (index * stepsToRight) % lineWidth)
//      }
//  }
//
//  def isTree(line: String, x: Int) = line.charAt(x) == '#'

  def countTrees(lines: Seq[String], stepsX: Int, stepsY: Int): Int = {
    def isTree(lines: Seq[String], x: Int, y: Int) = lines(x).charAt(y % lines(x).size) == '#'

    def walk(lines: Seq[String], x: Int, y: Int, treeCounter: Int = 0): Int = {
      if (x >= lines.length) return treeCounter
      if (isTree(lines, x, y)) walk(lines, x + stepsX, y + stepsY, treeCounter + 1) else walk(lines, x + stepsX, y + stepsY, treeCounter)
    }

    walk(lines, 0, 0)
  }

  def main(args: Array[String]): Unit = {
    val input: Seq[String] =
      Source
        .fromFile("src/test/resources/input03.txt")
        .getLines
        .toSeq

    println(s"Answer Part 1: ${countTrees(input, 1, 3)}")


    val resPart2 = countTrees(input, 1, 1) *
      countTrees(input, 1, 3) *
      countTrees(input, 1, 5) *
      countTrees(input, 1, 7) *
      countTrees(input, 2, 1)
    println(s"Answer Part 2: ${resPart2}")
  }
}