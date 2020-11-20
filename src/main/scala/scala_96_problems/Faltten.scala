package scala_96_problems

object Faltten extends App {
  
  // flatten a nested list =>
  val a: List[Any] = List(List(1, 2), 2, List(3, 7)) // => List[1, 2, 2, 3, 7)
  
  implicit class ListOps(list: List[Any]) {
    def flattenIt(): List[Any] = {
      var result: List[Any] = List()
      list.map {
        case aList: List[_] => 
          aList.foreach(elem => result = result :+ elem)
        case elem => 
          result = result :+ elem
      }
      result
    }
  }
  
  val flattenA = a.flattenIt()
  println(flattenA)
  
}
