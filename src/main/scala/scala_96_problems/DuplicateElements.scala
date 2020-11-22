package scala_96_problems

object DuplicateElements extends App {
  
  // input: List(1, 2, 3) => List(1, 1, 2, 2, 3, 3)
  def duplicate[T](list: List[T]): List[T] = 
    list.flatMap(e => List(e, e))
    
  // This is one possible soloution which is just so simple
  // So i implement my own flatMap
  
  
  extension [T](list: List[T]) def myFlatMap(f: T => List[T]): List[T] = {
    if(list.tail.isEmpty) f(list.head)
    else f(list.head) ++ list.tail.myFlatMap(f)
  }
  
  val intList: List[Int] = List(1, 2, 3, 4)
  // first approach which sucks of course
  println(duplicate(intList))
  // second approach
  println(intList.myFlatMap(e => List(e, e)))
  
  val stringList: List[String] = List("one", "two", "three")
  // first approach
  println(duplicate(stringList))
  // second
  println(stringList.myFlatMap(str => List(str, str)))
  
  
}
