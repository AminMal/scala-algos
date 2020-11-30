package scala_96_problems

object InsertElemAtIndex {
  
  extension [T](list: List[T])
    def addAt(index: Int, element: T): List[T] = {
      if (index < 0 || index >= list.length) {
        throw new IndexOutOfBoundsException
      }
      else {
        val leftSide: List[T] = list.take(index)
        val rightSide: List[T] = list.takeRight(list.length - index)
        (leftSide :+ element) ++ rightSide
      }
    }

  def main(args: Array[String]): Unit = {
    
    val list: List[Int] = List(1, 2, 3, 4, 5, 6, 7)
    
    println(list.addAt(4, 8))
    println("Works fine")
    
  }
  
}
