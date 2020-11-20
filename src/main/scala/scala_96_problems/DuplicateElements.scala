package scala_96_problems

object DuplicateElements extends App {
  
  // input: List(1, 2, 3) => List(1, 1, 2, 2, 3, 3)
  def duplicate[T](list: List[T]): List[T] = 
    list.flatMap(e => List(e, e))
    
  // This is one possible soloution which is just so simple
  // So i implement my own flatMap
  
  implicit class ListOps[T](list: List[T]) {
    def myFlatMap(f: T => List[T]): List[T] = {
      if (this.list.tail.isEmpty) f(this.list.head)
      else f(this.list.head) ++ this.list.tail.myFlatMap(f) 
    } 
  }
  
  val list: List[Int] = List(1, 2, 3, 4)
  println(duplicate(list))
  println(list.myFlatMap(e => List(e, e)))
  
}
