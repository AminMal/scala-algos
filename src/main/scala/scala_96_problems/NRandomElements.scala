package scala_96_problems

import java.util.Random

object NRandomElements {

  def createAList(amount: Int, upperBound: Int): List[Int] = {
    val random = new Random()
    def count(currentlyNTimes: Int = 0, acc: List[Int] = List()): List[Int] = {
      if (currentlyNTimes >= amount) acc
      else count(currentlyNTimes + 1, acc :+ random.nextInt(upperBound))
    }
    count()
  }

  def main(args: Array[String]): Unit = {
    println(createAList(6, 50))
    println("Works fine")
  }
}
