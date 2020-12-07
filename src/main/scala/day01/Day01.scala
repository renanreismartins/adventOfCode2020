package day01

import scala.annotation.tailrec
import scala.io.Source

object InputParser {
  def parse(filePath: String): Seq[Int] = {
    Source.fromURL(getClass.getResource(filePath)).getLines().map(_.toInt).toList // not sure if it is the best way to load a file in Scala.
  }
}

object ExpenseReport {
  @tailrec
  def find2EntriesThatSum2020(allEntries: Seq[Int]): Option[Int] = {
    if (allEntries.isEmpty) return None

    val maybeSumUp2020 = allEntries.find(e => (e + allEntries.head) == 2020)
    maybeSumUp2020 match {
      case None => find2EntriesThatSum2020(allEntries.tail)
      case Some(r) => Some(r * allEntries.head)
    }
  }

  def find3EntriesThatSum2020(allEntries: Seq[Int]): Option[Int] = {
    val result = for (x <- allEntries;
                      y <- allEntries;
                      z <- allEntries if x + y + z == 2020) yield x * y * z
    result.headOption
  }
}