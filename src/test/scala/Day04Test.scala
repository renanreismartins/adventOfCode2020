import org.scalatest.flatspec.AnyFlatSpec

class Day04Test extends AnyFlatSpec {

  val input =
    """ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
      |byr:1937 iyr:2017 cid:147 hgt:183cm
      |
      |iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884
      |hcl:#cfa07d byr:1929
      |
      |hcl:#ae17e1 iyr:2013
      |eyr:2024
      |ecl:brn pid:760753108 byr:1931
      |hgt:179cm
      |
      |hcl:#cfa07d eyr:2025 pid:166559648
      |iyr:2011 ecl:brn hgt:59in"""
      .stripMargin

  "splitFromEmptyLines" should "split the input to 4 strings representing a passport string each" in {
    val passports = Seq(
      "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd\nbyr:1937 iyr:2017 cid:147 hgt:183cm",
      "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884\nhcl:#cfa07d byr:1929",
      "hcl:#ae17e1 iyr:2013\neyr:2024\necl:brn pid:760753108 byr:1931\nhgt:179cm",
      "hcl:#cfa07d eyr:2025 pid:166559648\niyr:2011 ecl:brn hgt:59in"
    )
    assert(Day04.splitFromEmptyLines(input) == passports)
  }

  "parsePassport" should "parse the passport into a map" in {
    val passport = Map(
      "ecl" -> "gry",
      "pid" -> "860033327",
      "eyr" -> "2020",
      "hcl" -> "#fffffd",
      "byr" -> "1937",
      "iyr" -> "2017",
      "cid" -> "147",
      "hgt" -> "183cm"
    )
    assert(Day04.parsePassport("ecl:gry pid:860033327 eyr:2020 hcl:#fffffd\nbyr:1937 iyr:2017 cid:147 hgt:183cm") == passport)
  }

  "parsePassports" should "parse all passports from the input into maps" in {
    val passports = Seq(
      Map(
        "ecl" -> "gry",
        "pid" -> "860033327",
        "eyr" -> "2020",
        "hcl" -> "#fffffd",
        "byr" -> "1937",
        "iyr" -> "2017",
        "cid" -> "147",
        "hgt" -> "183cm"
      ),
      Map(
        "iyr" -> "2013",
        "ecl" -> "amb",
        "cid" -> "350",
        "eyr" -> "2023",
        "pid" -> "028048884",
        "hcl" -> "#cfa07d",
        "byr" -> "1929"
      ),
      Map(
        "hcl" -> "#ae17e1",
        "iyr" -> "2013",
        "eyr" -> "2024",
        "ecl" -> "brn",
        "pid" -> "760753108",
        "byr" -> "1931",
        "hgt" -> "179cm"
      ),
      Map(
        "hcl" -> "#cfa07d",
        "eyr" -> "2025",
        "pid" -> "166559648",
        "ecl" -> "brn",
        "iyr" -> "2011",
        "hgt" -> "59in"
      )
    )
    assert(Day04.parsePassports(input) == passports)
  }

  "isValid" should "should be true for a passport that contains all fields" in {
    val passport =
      Map(
        "ecl" -> "gry",
        "pid" -> "860033327",
        "eyr" -> "2020",
        "hcl" -> "#fffffd",
        "byr" -> "1937",
        "iyr" -> "2017",
        "cid" -> "147",
        "hgt" -> "183cm"
      )

    assert(Day04.isValid(passport) == true)
  }

  "isValid" should "should be true for a passport that contains all fields except cid" in {
    val passport =
      Map(
        "ecl" -> "gry",
        "pid" -> "860033327",
        "eyr" -> "2020",
        "hcl" -> "#fffffd",
        "byr" -> "1937",
        "iyr" -> "2017",
        "hgt" -> "183cm"
      )

    assert(Day04.isValid(passport) == true)
  }

  "isValid" should "should be false for a passport missing hgt field" in {
    val passport =
      Map(
        "ecl" -> "gry",
        "pid" -> "860033327",
        "eyr" -> "2020",
        "hcl" -> "#fffffd",
        "byr" -> "1937",
        "iyr" -> "2017",
        "cid" -> "147"
      )

    assert(Day04.isValid(passport) == false)
  }
}
