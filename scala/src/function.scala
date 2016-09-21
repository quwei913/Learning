/**
  * Created by wqu on 9/21/2016.
  */
package com.scala.demo
object function {
  def abs(x: Double) = if (x >= 0) x else -x
  def sum(args: Int*) = {
    var result = 0
    for (arg <- args) result += arg
    result
  }

  def recursiveSum(args: Int*): Int = {
    if (args.length == 0) 0
    else args.head + recursiveSum(args.tail: _*)
  }

  def except(x: Int) = {
    if (x >= 0) {
      println(scala.math.sqrt(x))
    } else throw new IllegalArgumentException("x should be positive")
  }
  def main(args: Array[String]) {
    lazy val words = scala.io.Source.fromFile("/usr/share/dict/words").mkString
    val input = scala.io.StdIn.readDouble()
    println(abs(input))
    val in = scala.io.StdIn.readInt()
    try {
      except(in)
    }
    catch {
      case _: IllegalArgumentException => println("Negative value provided")
      case ex: Exception => ex.printStackTrace()
    }
    finally {
      println("Exception tested!")
    }
    println(sum(1 to 5: _*))
  }
}
