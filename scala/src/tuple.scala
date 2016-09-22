package com.scala.demo

object tuple {
  def main(args: Array[String]) {
    val t = (1, 3.14, "Wei Qu")
    println(t)
    val second = t._2
    println(second)
    val (a, b, c) = t
    println(a, b, c)
    val (a1, b1, _) = t
    println(a1, b1)
    println("New York".partition(_.isUpper))
    val symbols = Array("<", "=", ">")
    val counts = Array(1, 2, 3)
    val pairs = symbols.zip(counts)
    println(pairs)
    println(pairs.toMap)
    for ((s, n) <- pairs) Console.print(s * n)
  }
}