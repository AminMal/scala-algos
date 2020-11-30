package scala_96_problems

object PrimeChecker {
  
  import scala.language.implicitConversions
  
  extension (number: Int)
    def isPrime: Boolean = {
      if (number < 1) false
      else {
        var result: Boolean = true
        (2 to Math.sqrt(number).intValue).map[Boolean](num => number % num != 0).map{
          case true =>
          case false => result = false
        }
        result
      }
    }

  def main(args: Array[String]): Unit = {
    println(7.isPrime)
    println(4.isPrime)
    println(91.isPrime) // 13 * 7
    println(97.isPrime) // true
  }
  
}
