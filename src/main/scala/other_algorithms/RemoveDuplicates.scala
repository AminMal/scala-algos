package other_algorithms

import scala.annotation.tailrec

object RemoveDuplicates extends App {

  val source: List[Int] = List(2, 2, 4, 5, 7, 7, 8)
  // Remove the duplicated elements and return distinnct ones
  // output => [4, 5, 8]
  /**
   * functional approach
   */
  // first i need an exists(elem) function on list which does not suck!
  extension [T](list: List[T]) def has(element: T): Boolean = {
    @tailrec
    def iterate(index: Int = 0): Boolean = {
      if (index >= list.length) false
      else {
        if (list(index) == element) true
        else iterate(index + 1)
      }
    }
    iterate()
  }

  def removeDuplicates(input: List[Int]): List[Int] = {
    def iterator(
                index: Int = 0,
                whole: List[Int] = input,
                extras: List[Int] = List(),
                acc: List[Int] = List()
                ): List[Int] = {
      if (whole.isEmpty) acc
      else {
        val currentVal = whole.head
        if (extras.has(currentVal) || whole.tail.has(currentVal)) iterator(
          index + 1, whole.tail, extras :+ currentVal, acc)
        
        else iterator(index + 1, whole.tail, extras, acc :+ currentVal)
      }
    }
    iterator()
  }
  
  val removed = removeDuplicates(source)
  println(removed)
}
