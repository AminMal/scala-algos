package other_algorithms


// mutable
trait MyStack[T] {
  def push(elem: T): MyStack[T]
  def pop(): T
  override def toString(): String
}

class MyStackImpl[T](var elems: List[T]) extends MyStack[T] {
  override def push(elem: T): MyStack[T] = MyStack((elems :+ elem).toSeq: _*)

  override def pop(): T = {
    if (elems.isEmpty) throw new NoSuchElementException
    else {
      val value = elems(elems.length - 1)
      elems = elems.slice(0, elems.length - 1)
      value
    }
  }
  override def toString: String = "MyStack" + elems.mkString("(", ", ", ")")
}

object MyStack {
  def apply[T](elems: T*): MyStack[T] = new MyStackImpl[T](elems.toList)
}

object Try extends App {
  println(MyStack(1, 2, 3, 4))
}