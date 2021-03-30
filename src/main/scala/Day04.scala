import scala.io.Source

object Day04 {

  // Could have read line by line and accumulating the fields in the Map instead of splitting the whole input
  def parsePassports(input: String): Seq[Map[String, String]] = splitFromEmptyLines(input).map(parsePassport)

  def splitFromEmptyLines(input: String): Seq[String] = input.split("\n\n")

  def parsePassport(line: String): Map[String, String] = {
    println(line)
    splitPassport(line)
      .map(_.split(":"))
      .map {
        case Array(k, v) => (k, v)
      }
      .toMap
  }

  def splitPassport(line: String): Array[String] = line.split("\\s+")

  def isValid(passport: Map[String, String]): Boolean = Set("ecl", "pid", "eyr", "hcl", "byr", "iyr", "hgt").subsetOf(passport.keySet)

  def main(args: Array[String]): Unit = {
    // Add a space character in the end of a line to make it break
    // val input =
    //      """ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
    //        |byr:1937 iyr:2017 cid:147 hgt:183cm
    //        |
    //        |iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884
    //        |hcl:#cfa07d byr:1929
    //        |
    //        |hcl:#ae17e1 iyr:2013
    //        |eyr:2024
    //        |ecl:brn pid:760753108 byr:1931
    //        |hgt:179cm
    //        |
    //        |hcl:#cfa07d eyr:2025 pid:166559648
    //        |iyr:2011 ecl:brn hgt:59in"""
    //        .stripMargin

    val input: String =
      Source
        .fromFile("src/test/resources/input04.txt")
        .getLines
        .mkString("\n")

    val part1 = parsePassports(input).count(isValid(_))
    println(s"Answer Part 1: $part1")

  }
}