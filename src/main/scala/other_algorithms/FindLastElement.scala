package other_algorithms

object FindLastElement extends App {
  // From 99 scala problems
  // input: List(1, 2, 3, 4, 5, 6, 7, 8) => 8
  // Not by using list.apply(list.length - 1), instead, use the functinoal approcach
  val input: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8)
  
  def last[T](list: List[T]): T = {
    if (list.isEmpty) throw new NullPointerException
    def iterate(src: List[T] = list): T = {
      if(src.tail.isEmpty) src.head
      else iterate(src.tail)
    }
    iterate()
  } 
  
  println(last(input))
  println(last(List("Amin")))
}
