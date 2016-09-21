import scala.collection.mutable.ArrayBuffer

/**
  * Created by wqu on 9/21/2016.
  */
object array {
  def main(args: Array[String]) {
    val name = new Array[String](10)
    val age = Array(13,20,33)
    for (i <- age; j <- name) {
      println(i)
      println(j)
    }
    val input = ArrayBuffer[Int]()
    println(input)
    input += 2
    println(input)
    input += (2,3,4,5)
    println(input)
    input ++= Array(55, 66, 77)
    println(input)
    input.trimEnd(2)
    println(input)
    input.insert(2, 88)
    println(input)
    input.insert(3, 100, 101, 122)
    println(input)
    input.remove(4, 4)
    println(input)
    input.trimStart(2)
    println(input)
    println(input.toArray)
    println(name.toBuffer)
    for (i <- input.toArray)
      println(i)
    for (i <- (0 until input.length).reverse)
      println(input(i))
    for (i <- for (j <- input) yield 2 * j)
      println(i)
    for (i <- for (j <- input.toArray if j % 2 == 0) yield 2 * j)
      println(i)
  }
}