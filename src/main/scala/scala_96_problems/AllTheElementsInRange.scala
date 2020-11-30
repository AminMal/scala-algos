package scala_96_problems

object AllTheElementsInRange {
  
  // As simple as that :)
  def createListInTheGivenRange(lowerBound: Int, higherBound: Int): List[Int] = {
    List((lowerBound to higherBound): _*)
  }
  
  def createList(lower: Int, higher: Int): List[Int] = {
    val result = for {
      i <- lower to higher
    } yield i
    result.toList
  }
  
  def createList2(lower: Int, higher: Int): List[Int] = {
    def iterate(currentlyAt: Int = lower, acc: List[Int] = List()): List[Int] = {
      if (currentlyAt > higher) acc
      else iterate(currentlyAt + 1, acc :+ currentlyAt)
    }
    iterate()
  }

  def main(args: Array[String]): Unit = {
    println(createListInTheGivenRange(3, 9))
    println(createList(3, 9))
    println(createList2(3, 9))
    println("All of them just as expected")
  }
}
