package scala_96_problems

import java.util.Random

object NRandomFromList {

  extension [T](list: List[T])
    def except(index: Int): List[T] = {
      if list.isEmpty then list
      else {
        val leftSide = list.take(index)
        val rightSide = list.takeRight(list.length - index - 1)
        leftSide ++ rightSide
      }
    }
  
  def takeNRandomElements[T](n: Int, list: List[T]): Option[List[T]] = {
    if (n > list.length) None
    if (n == list.length) Some(list)
    else {
      def iterate(howManyToGo: Int = n, src: List[T] = list, acc: List[T] = List()): Option[List[T]] = {
        if (howManyToGo == 0) Some(acc)
        else {
          val random = new Random()
          val index = random.nextInt(src.length)
          
          iterate(howManyToGo - 1, src.except(index), acc :+ src(index))
        }
      }
      iterate()
    }
  }
  
  
  def main(args: Array[String]): Unit = {
    
    val emptyList: List[String] = List()
    val list: List[Int] = List(1, 2, 3, 4, 5, 6)
    
    println(takeNRandomElements(4, list))
  }
  
}
