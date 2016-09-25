import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.io.Source

/**
  * Created by quwei on 16/9/25.
  */
object coll extends App {
  def digit(n: Int): Set[Int] =
    if (n < 0) digit(-n)
    else if (n < 10) Set(n)
    else digit(n / 10) + (n % 10)
  println(digit(10))
  val digits = List(4, 2)
  println(digits.tail, digits.head)
  println(9::digits)
  def sum(lst: List[Int]): Int =
    if (lst == Nil) 0 else lst.head + sum(lst.tail)

  def sum1(lst: List[Int]): Int = lst match {
    case Nil => 0
    case h :: t => h + sum1(t)
  }
  println("%d - %d - %d".format(sum(List(3, 4)), sum1(List(2, 9)), List(3, 19).sum))

  val lst = scala.collection.mutable.LinkedList(1, -2, 7, -9)
  var cur = lst
  while (cur != Nil) {
    if (cur.elem < 0) cur.elem = 0
    cur = cur.next
  }
  println(lst)
  cur = lst
  while(cur != Nil && cur.next != Nil) {
    cur.next = cur.next.next
    cur = cur.next
  }
  println(lst)

  val digi = Set(1, 7, 2, 9)
  println(digi contains 0)
  println(Set(1,2) subsetOf digi)
  val primes = Set(2, 3, 5, 7)
  println(digi ++ primes, digi union primes, digi -- primes, digi & primes)
  println(Vector(1, 2, 3) :+ 5)
  println(1 +: Vector(1, 2, 3))
  val numb = ArrayBuffer(1, 2, 3)
  numb += 5
  var num = Set(1, 2, 3)
  num += 5
  println(num)
  var numberVector = Vector(1, 2, 3)
  numberVector :+= 5
  println(numberVector)
  println(Set(1, 2, 3) - 2)

  val names = List("Peter", "Paul", "Mary")
  println(names.map(_.toUpperCase))
  println(for(n <- names) yield n.toUpperCase)
  def ulcase(s: String) = Vector(s.toUpperCase(), s.toLowerCase())
  println(names.map(ulcase))
  println(names.flatMap(ulcase))
  println("-3+4".collect { case '+' =>1; case '-' => -1 })
  names.foreach(println)
  println(List(1, 7, 2, 9).reduceLeft(_ - _))
  println(List(1, 7, 2, 9).reduceRight(_ - _))
  println(List(1, 7, 2, 9).foldLeft(0)(_ - _))
  //same with foldLeft
  (0 /: List(1, 7, 2, 9))(_ - _)
  println(List(1, 7, 2, 9).foldRight(0)(_ - _))
  val freq = scala.collection.mutable.Map[Char, Int]()
  for (c <- "Mississippi") freq(c) = freq.getOrElse(c, 0) + 1
  println(freq)
  println((Map[Char, Int]() /: "Mississippi") {
    (m, c) => m + (c -> (m.getOrElse(c, 0) + 1))
  })
  println((1 to 10).scanLeft(0)(_ + _))
  val prices = List(5.0, 20.0, 9.95)
  val quantities = List(10, 2, 1)
  println(prices zip quantities)
  println((prices zip quantities) map {p => p._1 * p._2})
  println(List(5.0, 20.0, 9.95).zipAll(List(10, 2), 0.0, 1))
  println("Wei Qu".zipWithIndex)
  println("Wei Qu".zipWithIndex.max)
  println("Wei Qu".zipWithIndex.max._2)

  def numsFrom(n: BigInt): Stream[BigInt] = n #:: numsFrom(n + 1)
  val tenOrMore = numsFrom(10)
  println(tenOrMore)
  println(tenOrMore.tail.tail.tail)
  val squares = numsFrom(1).map(x => x * x)
  println(squares)
  println(tenOrMore.tail.tail)
  println(squares.take(5).force)
  val words = Source.fromFile("src/myFile.txt").getLines.toStream
  println(words)
  println(words(2))
  println(words)
  val powers = (0 until 1000).view.map(Math.pow(10, _))
  println(powers(10))
  println(powers)
  println(powers.force)
  println((0 to 10).map(Math.pow(10, _)).map(1 / _))
  println((0 to 10).view.map(Math.pow(10, _)).map(1 / _).force)
  import scala.collection.JavaConversions._
  val props: scala.collection.mutable.Map[String, String] = System.getProperties()
  println(props)
  props("com.horstmann.scala") = "impatient"
  println(props)
  val scores = new mutable.HashMap[String, Int] with
    scala.collection.mutable.SynchronizedMap[String, Int]

  println(List(1, 2, 3).par.sum)
  println(List(1, 2, 3).par.count(_ % 2 == 0))
  println(for (i <- (0 until 10).par) yield  i + " ")
}
