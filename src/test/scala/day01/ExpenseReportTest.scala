package day01

import day01.ExpenseReport.findEntryThatSum2020
import org.scalatest.flatspec.AnyFlatSpec

class ExpenseReportTest extends AnyFlatSpec {
  "The expense report" should "return None if there is just one entry in the list" in {
    assert(ExpenseReport.findEntryThatSum2020(Seq(2020)) == None)

  }
  it should "return None if there are no entries in the list" in {
    assert(ExpenseReport.findEntryThatSum2020(Seq()) == None)
  }

  it should "return None if there are no entries in the list that sum up to 2020" in {
    assert(ExpenseReport.findEntryThatSum2020(Seq(1, 2)) == None)
    assert(ExpenseReport.findEntryThatSum2020(Seq(2020, 1)) == None)
  }

  it should "return the  multiplications of the numbers that sums up to 2020" in {
    assert(ExpenseReport.findEntryThatSum2020(Seq(2019, 2, 1)) == Some(2019))
    assert(ExpenseReport.findEntryThatSum2020(Seq(2000, 20, 1)) == Some(40000))
  }

  it should "return the multiplications of the numbers that sums up to 2020" in {
    assert(findEntryThatSum2020(InputParser.parse("/day01/input.txt")) == Some(731731))
  }
}
