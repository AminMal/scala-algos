package other_algorithms

object FindKthElement extends App  {
  
  // of course, not using apply method 
  implicit class ListOps[T](list: List[T]) {
    def getAt(index: Int): Option[T] = {
      if (index < 0) None
      
      def iterate(at: Int = 0, src: List[T] = list): Option[T] = {
        if (at == index) Some(src.head)
        else {
          val tail = src.tail
          if(tail.isEmpty) None
          else iterate(at + 1, tail)
        }
      }
      iterate()
    }
  }
  val source: List[Int] = List(0, 1, 2, 3, 4, 5, 6, 7) // make tracking easier
  println(source.getAt(4)) // Some(4)
  println(source.getAt(-1)) // None
  println(source.getAt(99)) // None
}
