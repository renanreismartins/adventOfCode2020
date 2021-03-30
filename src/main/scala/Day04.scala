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

  def isValidHeight(hgt: String): Boolean =
    hgt.takeRight(2) match {
      case "cm" => (150 to 193) contains hgt.split('c')(0).toInt
      case "in" => (59 to 76) contains hgt.split('i')(0).toInt
      case _ => false
    }

  def isValidHairColor(hcl: String): Boolean = {
    "#".equals(hcl.take(1)) &&
      7.equals(hcl.size) &&
      hcl
        .drop(1)
        .filter(c => (c >= '0' && c <= '9') || (c >= 'a' && c <= 'f')).size == 6
  }

  def isValidEyeColor(ecl: String): Boolean = ecl match {
    case "amb" | "blu" | "brn" | "gry" | "grn" | "hzl" | "oth" => true
    case _ => false
  }

  def isValid(passport: Map[String, String]): Boolean = {
    Set("ecl", "pid", "eyr", "hcl", "byr", "iyr", "hgt").subsetOf(passport.keySet) &&
      (1920 to 2002).contains(getKeyOrEmpty(passport, "byr").toInt) &&
      (2010 to 2020).contains(getKeyOrEmpty(passport, "iyr").toInt) &&
      (getKeyOrEmpty(passport, "eyr").size == 4 && (2020 to 2030).contains(getKeyOrEmpty(passport, "eyr").toInt)) &&
      isValidHeight(getKeyOrEmpty(passport, "hgt")) &&
      isValidHairColor(getKeyOrEmpty(passport, "hcl")) &&
      isValidEyeColor(getKeyOrEmpty(passport, "ecl")) &&
      (getKeyOrEmpty(passport, "pid").size == 9 && getKeyOrEmpty(passport, "pid").forall(_.isDigit))
  }

  private def getKeyOrEmpty(passport: Map[String, String], key: String): String = {
    passport.getOrElse(key, "")
  }

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