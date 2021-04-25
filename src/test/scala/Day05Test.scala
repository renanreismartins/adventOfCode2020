import org.scalatest.flatspec.AnyFlatSpec

class Day05Test extends AnyFlatSpec {

  "walkLine" should "return the lower half region when step is 'F'" in {
    assert(Day05.walkLine('F', 0 to 127) == (0 to 63))
    assert(Day05.walkLine('F', 32 to 63) == (32 to 47))
  }

  it should "return the lower half region when step is 'F' and the range is only two positions" in {
    assert(Day05.walkLine('F', 44 to 45) == (44 to 44))
  }

  it should "return the upper half region when step is 'B'" in {
    assert(Day05.walkLine('B', 0 to 127) == (64 to 127))
    assert(Day05.walkLine('B', 0 to 63) == (32 to 63))
  }

  it should "return the upper half region when step is 'B' and the range is only two positions" in {
    assert(Day05.walkLine('B', 44 to 45) == (45 to 45))
  }


  "walkColumns" should "return the upper half columns when step is 'R'" in {
    assert(Day05.walkColumn('R', 0 to 7) == (4 to 7))
    assert(Day05.walkColumn('L', 4 to 7) == (4 to 5))
  }

  it should "return the upper half region when step is 'R' and the range is only two positions" in {
    assert(Day05.walkLine('R', 4 to 5) == (5 to 5))
  }

  "findLine" should "return the line number" in {
    assert(Day05.findLine("BFFFBBF".toCharArray.toSeq) == 70)
    assert(Day05.findLine("FFFBBBF".toCharArray.toSeq) == 14)
    assert(Day05.findLine("BBFFBBF".toCharArray.toSeq) == 102)
  }

  "findLine" should "return the column number" in {
    assert(Day05.findColumn("RRR".toCharArray.toSeq) == 7)
    assert(Day05.findColumn("RLL".toCharArray.toSeq) == 4)
  }

  "seatId" should "return the seat id" in {
    assert(Day05.seatId("BFFFBBFRRR".toCharArray.toSeq) == 567)
    assert(Day05.seatId("FFFBBBFRRR".toCharArray.toSeq) == 119)
    assert(Day05.seatId("BBFFBBFRLL".toCharArray.toSeq) == 820)
  }

}