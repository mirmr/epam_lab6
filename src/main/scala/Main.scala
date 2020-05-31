import scala.annotation.tailrec

object Main {
  @tailrec
  def foldl[A, B](f: (B,A) => B,a: B,c: List[A]): B = c match{
    case Nil => a
    case r :: rest => foldl(f, f(a, r), rest)
  }

  def to_set[A](in: List[A]): List[A] =
    foldl[A, List[A]] ((list, x) => if (!List.contains (x)) list.appended (x) else list, List(), in)

  def main(args: Array[String]): Unit = {
    println( to_set(List[String](elems = "hello", "world", "hello", "world")))
  }

}
