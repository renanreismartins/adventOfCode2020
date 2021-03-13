import org.scalatest.flatspec.AnyFlatSpec

class Day03Test extends AnyFlatSpec {
  val map =
    """..##.........##.........##.........##.........##.........##.......
      |#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..
      |.#....#..#..#....#..#..#....#..#..#....#..#..#....#..#..#....#..#.
      |..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#
      |.#...##..#..#...##..#..#...##..#..#...##..#..#...##..#..#...##..#.
      |..#.##.......#.##.......#.##.......#.##.......#.##.......#.##.....
      |.#.#.#....#.#.#.#....#.#.#.#....#.#.#.#....#.#.#.#....#.#.#.#....#
      |.#........#.#........#.#........#.#........#.#........#.#........#
      |#.##...#...#.##...#...#.##...#...#.##...#...#.##...#...#.##...#...
      |#...##....##...##....##...##....##...##....##...##....##...##....#
      |.#..#...#.#.#..#...#.#.#..#...#.#.#..#...#.#.#..#...#.#.#..#...#.#
      |"""
      .stripMargin
      .split("\n")
      .toSeq

  "countTrees" should "count 0 trees for a map with one line and no tree in the most top left coordinate" in {
    assert(Day03.countTrees(Seq("..##.........##.........##.........##.........##.........##......."), 1, 1) == 0)
  }

  it should "count 1 tree for a map with one line and with a tree in the most top left coordinate" in {
    assert(Day03.countTrees(Seq("#.##.........##.........##.........##.........##.........##......."), 1, 1) == 1)
  }

  it should "count 1 tree on the coordinates walking 3 steps right and 1 down in a map with two lines and with a tree in the coordinate (2,1)" in {
    val map = Seq(
      "#.##.........##.........##.........##.........##.........##.......",
      "#..##...#..#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..")
    assert(Day03.countTrees(map, 3, 1) == 1)
  }

  it should "count 7 trees when walking right 3, down 1" in {
    assert(Day03.countTrees(map, 1, 3) == 7)
  }

}