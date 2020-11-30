package scala_96_problems

object GreatestCommonDivisor {

  def gcd(a: Int, b: Int): Int = 
    if b == 0 then a else gcd(b, a % b)
  
}
