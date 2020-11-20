package other_algorithms

object Palindromes extends App {
  
  implicit class RichInt(value: Int) {
    def isEven: Boolean = value % 2 == 0
  }
  
  // find out whether a list is palindrome 
  // (1, 2, 3, 2, 1) => true
  
  def isPalindrome(list: List[Int]): Boolean = {
    val length = list.length
    
    def checkEquality(aIndex: Int, lastIndex: Int): Boolean = {
      if (aIndex == -1) true
      else {
        if (list(aIndex) == list(lastIndex)) checkEquality(aIndex - 1, lastIndex + 1)
        else false
      }
    }
    
    if (length.isEven) false
    else {
      val middleOneIndex: Int = length / 2 // ( 5 / 2 ) = 2 correct
      checkEquality(middleOneIndex - 1, middleOneIndex + 1)
    }
  }
  
  val aPalindrome: List[Int] = List(1, 2, 3, 4, 3, 2, 1)
  val aNonPalindrome: List[Int] = List(1, 2, 3, 4, 5, 2, 1)
  
  println(s"First one is palindrome: ${isPalindrome(aPalindrome)}")
  println(s"second one is palindrome: ${isPalindrome(aNonPalindrome)}")
}
