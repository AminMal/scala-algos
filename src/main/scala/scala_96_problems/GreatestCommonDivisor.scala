package scala_96_problems

object GreatestCommonDivisor {

  def gcd(a: Int, b: Int): Int =
    if b == 0 then a else gcd(b, a % b)

  def main(args: Array[String]): Unit = {
    println(gcd(4, 7))
    println(gcd(4, 8))
  }
}
