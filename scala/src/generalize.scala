import javax.sql.rowset.FilteredRowSet

/**
  * Created by quwei on 16/10/6.
  */

class Pair[T, S](val first: T, val second: S)

class Pair1[T <: Comparable[T]](val first: T, val second: T) {
  def smaller = if (first.compareTo(second) < 0) first else second
  //def replaceFirst[R >: T](newFirst: R) = new Pair1[R](newFirst, second)
  def firstLast[A, C](it: C)(implicit ev: C <:< Iterable[A]) = (it.head, it.last)
}

class Pair2[T <% Ordered[T] <% String /*with Cloneable*/](val first: T, val second: T) {
  def smaller = if (first < second) first else second

  def makePair[T: Manifest : Ordering](first: T, second: T) {
    val r = new Array[T](2); r(0) = first; r(1) = second; r
  }

  def firstLast[A, C <: Iterable[A]](it: C) = (it.head, it.last)
}

class Pair3[T](val first: T, val second: T) {
  def smaller(implicit ev: T <:< Ordered[T]) =
    if (first < second) first else second
}

class Pair4[+T](val first: T, val second: T)

trait Friend[-T] {
  def befriend(someone: T)
  def makeFriendWith(s: Student, f: Friend[Student]) { f.befriend(s) }
}

abstract class List[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Node[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

class Empty[T] extends List[T] {
  def isEmpty = true
  def head = throw new UnsupportedOperationException
  def tail = throw new UnsupportedOperationException
}

object generalize {
  def main(args: Array[String]): Unit = {
    val p = new Pair(42, "String")
    val p2 = new Pair[Any, Any](42, "String")
  }
  def getMiddle[T](a: Array[T]) = a(a.length / 2)
  println(getMiddle(Array(22, 11, 3, 4)))
  val f = getMiddle[String] _
  println(f(Array("Mary", "had", "a", "little", "lamb")))
  val p1 = new Pair1("Fred", "Brooks")
  println(p1.smaller)
  val p2 = new Pair2("22", "33")
  println(p2.smaller)
  println(p2.makePair(13, 22))
  val friends = Map("Fred" -> "Barney", "Wei" -> "Qu")
  val friendOpt = friends.get("Wilma")
  val friendOrNull = friendOpt.orNull
  println(friendOrNull)
  println(p1.firstLast(List(1,2,3)))
  //println(p2.firstLast(List("1","2","3")))
}