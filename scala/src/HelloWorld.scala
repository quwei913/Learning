/**
  * Created by wqu on 9/21/2016.
  */
package com.scala.demo
import scala.io.StdIn
object HelloWorld {
  def main(args: Array[String]) {
    val name =  StdIn.readLine("Your name: ")
    val age = StdIn.readInt()
    for (i <- 0 until name.length; j <- 1 to 3; from = 4 - j; j <- from to 5)
      println("letter: %s %s", name(i), name(j))
    val result = {for (c <- name; j <- 1 to 3; from = 4 - j; j <- from to 5 if from != j)
      yield(c + j).toChar}
    println(result)
    println("Hello world %s %d!", name, age)
  }
}
