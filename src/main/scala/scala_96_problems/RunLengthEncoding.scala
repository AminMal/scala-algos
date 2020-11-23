package scala_96_problems

object RunLengthEncoding extends App {
  
  /*
      input: List('a', 'a', 'a', 'b', 'b', 'c')
      output: List(List('a', 3), List('b', 2), List('c', 1))
   */
  
  def runLengthEncoding(list: List[Char]): List[List[(Char, Int)]] = {
    def iterate(
               currentIndex: Int = 0,
               acc: Map[Char, Int] = Map()
               ): Map[Char, Int] = {
      if currentIndex >= list.length then acc
      else {
        val currentVal: Char = list(currentIndex)
        if acc.get(currentVal).isEmpty 
          iterate(currentIndex + 1, acc + (currentVal -> 1))
        else 
          val currentCount: Int = acc.get(currentVal).get
          iterate(currentIndex + 1, acc + (currentVal -> (currentCount + 1)))
      }
    }
    
    List(iterate().toList)
  }
  
  val source = List('a', 'a', 'a', 'b', 'b', 'c')
  println(runLengthEncoding(source))
  println("Just as expected")
}
