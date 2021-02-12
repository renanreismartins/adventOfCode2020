import org.scalatest.flatspec.AnyFlatSpec

class Day02Test extends AnyFlatSpec {
  "The password" should "be valid when it respects the start of the range" in {
    assert(Day02.isValid(1 to 3, 'a', "abcde") == true)
  }

  "The password" should "be valid when it respects the end of the range" in {
    assert(Day02.isValid(2 to 9, 'c', "ccccccccc") == true)
  }

  "The password" should "be valid when it does not respect the start of the range" in {
    assert(Day02.isValid(1 to 3, 'b', "cdefg") == false)
  }

  "The password" should "be invalid when it does not respect the end of the range" in {
    assert(Day02.isValid(1 to 2, 'b', "cccccccccc") == false)
  }

  "The parser" should "parse a line of the input" in {
    assert(Day02.parse("16-18 h: hhhhhhhhhhhhhhhhhh") == (16 to 18, 'h', "hhhhhhhhhhhhhhhhhh"))
  }



  // Second Policy

  "The password" should "be valid when it has the correct character placed only at the first position" in {
    assert(Day02.isValidForTwoPositionsPolicy(1 to 3, 'a', "abcde") == true)
  }

  "The password" should "be invalid when it hasn't the correct character placed at any position" in {
    assert(Day02.isValidForTwoPositionsPolicy(1 to 3, 'b', "cdefg") == false)
  }

  "The password" should "be invalid when it has the correct character placed at both positions" in {
    assert(Day02.isValidForTwoPositionsPolicy(2 to 9, 'c', "ccccccccc") == false)
  }

}