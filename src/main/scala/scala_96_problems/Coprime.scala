package scala_96_problems
import GreatestCommonDivisor._

object Coprime {
  
  extension (num: Int)
    def isCoprimeTo(anotherNum: Int): Boolean = gcd(num, anotherNum) == 1

  def main(args: Array[String]): Unit = {
    println(29.isCoprimeTo(3))
  }
}
