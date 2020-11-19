package other_algorithms

object ReverseWordsInAString extends App {
  
  /*
      https://leetcode.com/problems/reverse-words-in-a-string/
      input: "The sky is blue"
      output: "blue is sky The"
   */
  val inputString: String = "The sky is blue"
  def reverseString(input: String): String = {
    val words: List[String] = input.split(" ").toList
    def iterator(index: Int = 0, list: List[String] = words, acc: String = ""): String = {
      if(index >= words.length) acc
      else {
        if(list.tail.isEmpty) " " + list.head + acc
        else iterator(index + 1, list.tail, " " + list.head + acc)
      }
    }
    iterator()
  }
  
  println(reverseString(inputString))
}
