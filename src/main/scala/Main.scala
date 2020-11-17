
object Main {

  def search(elems: List[Int], target: Int): Boolean = {
    if (elems.length == 1) {
      if (elems(0) == target) true
      else false
    }
    else {
      val currentIndex: Int = elems.length / 2
      if (elems(currentIndex) == target) true
      else if (elems(currentIndex) > target) search(elems.slice(0, currentIndex), target)
      else search(elems.slice(currentIndex + 1, elems.length), target)
    }
  }
  
  def main(args: Array[String]): Unit = {
    val source: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val target: Int = 9
    
    search(source, target) match {
      case false =>
        println("No such element")
      case true =>
        println(s"Element $target exists")
    }
  }

}
