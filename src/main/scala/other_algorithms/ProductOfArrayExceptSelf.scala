package other_algorithms

import scala.annotation.tailrec

object ProductOfArrayExceptSelf extends App {
  
  // without division, O(n)
  val input: Array[Int] = Array(1, 2, 3, 4) // => output should be [24, 12, 8, 6]
  
  // So I'm going to do it in two ways, first one is going to use a for loop
  // The other one is going to use recursion
  val length = input.length
  var output: Array[Int] = new Array[Int](_length = input.length)
  for (i <- 0 to length - 1) {
    var rightSide: Array[Int] = input.slice(i + 1, length)
    var leftSide: Array[Int] = input.slice(1, i)
    
    output(i) = rightSide.fold(1)(_ * _) * leftSide.fold(1)(_ * _)
  }
  
  println("First approach:")
  println(output.mkString("(", ",", ")"))
  println("******************************")
  
  // Second approach - recursive function
  println("Second approach, recursive function")
  def recurCalculator(input: Array[Int]): Array[Int] = {
    @tailrec
    def calculateExcept(index: Int = 0, acc: Array[Int] = Array()): Array[Int] = {
      if (index >= input.length) acc
      else {
        val rightSideProd: Int = input.slice(index + 1, length).fold(1)(_ * _)
        val leftSideProd: Int = input.slice(1, index).fold(1)(_ * _)
        calculateExcept(index + 1, acc :+ rightSideProd * leftSideProd)
      }
    }
    calculateExcept()
  }

  println(recurCalculator(input).mkString("(", ",", ")"))
}
