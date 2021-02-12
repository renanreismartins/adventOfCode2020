import org.scalatest.flatspec.AnyFlatSpec

class Day02Test extends AnyFlatSpec {
  "The password" should "that respects the minimum of the range should be valid" in {
    assert(Day02.isValid(1 to 3, 'a', "abcde") == true)
  }

  "The password" should "that respects the maximum of the range should be valid" in {
    assert(Day02.isValid(2 to 9, 'c', "ccccccccc") == true)
  }

  "The password" should "that does not respect the minimum of the range should be invalid" in {
    assert(Day02.isValid(1 to 3, 'b', "cdefg") == false)
  }

  "The password" should "that does not respect the maximum of the range should be invalid" in {
    assert(Day02.isValid(1 to 2, 'b', "cccccccccc") == false)
  }

  "The parser" should "parse a line of the input" in {
    assert(Day02.parse("16-18 h: hhhhhhhhhhhhhhhhhh") == (16 to 18, 'h', "hhhhhhhhhhhhhhhhhh"))
  }


}