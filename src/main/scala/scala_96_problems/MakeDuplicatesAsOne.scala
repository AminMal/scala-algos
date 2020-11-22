package scala_96_problems

import scala.annotation.tailrec

object MakeDuplicatesAsOne extends App {
  
  // in: List(1, 1, 2, 3, 4, 4) => out: List(1, 2, 3, 4)
  
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
  
  def makeDuplicatesAsOne[T](list: List[T]): List[T] = {
    def iterate(
               src: List[T] = list,
               acc: List[T] = List()
               ): List[T] = {
      if (src.isEmpty) acc
      else {
        val head = src.head
        if(acc.has(head)) iterate(src.tail, acc)
        else iterate(src.tail, acc :+ head)
      }
    }
    iterate()
  }

  val duplicatedList: List[Int] = List(1, 1, 2, 3, 4, 4)
  
  println(s"original list: $duplicatedList")
  println(s"output: ${makeDuplicatesAsOne(duplicatedList)}")
}
