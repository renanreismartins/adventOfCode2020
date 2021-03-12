import org.scalatest.flatspec.AnyFlatSpec

class Day03Test extends AnyFlatSpec {
  "The tree validation" should "be true for a line with the starting position at the top left without a tree" in {
    assert(Day03.isTree("..##.........##.........##.........##.........##.........##.......", 0) == false)
  }

  it should "be true for a line with the starting position at the top left with a tree" in {
    assert(Day03.isTree("#.##.........##.........##.........##.........##.........##.......", 0) == true)
  }

  it should "be true for a line with the position 4 with a tree " in {
    assert(Day03.isTree("#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..", 4) == true)
  }

  "The number of trees" should "be 1 for one line with a tree in the index 0" in {
    assert(Day03.countTrees(Seq("#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..")) == 1)
  }

  it should "be 0 for one line with no tree in the index 0" in {
    assert(Day03.countTrees(Seq(".#....#..#..#....#..#..#....#..#..#....#..#..#....#..#..#....#..#.")) == 0)
  }

  it should "be 2 for two lines with trees in index 0 and sliding 3 positions to the right" in {
    val map = Seq(
      "#.##.........##.........##.........##.........##.........##.......",
      "#..##...#..#...#...#..#...#...#..#...#...#..#...#...#..#...#...#.."
    )

    assert(Day03.countTrees(map) == 2)
  }

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

  "The test input" should "count 7 trees when walking right 3, down 1" in {
    assert(Day03.countTrees(map) == 7)
  }

  it should "count 2 trees when walking right 1, down 1" in {
    assert(Day03.countTrees(map, 1) == 2)
  }

  it should "count 3 trees when walking right 5, down 1" in {
    assert(Day03.countTrees(map, 5) == 3)
  }

  it should "count 4 trees when walking right 7, down 1" in {
    assert(Day03.countTrees(map, 7) == 4)
  }
}