package com.scala.demo
import scala.beans.BeanProperty
import scala.collection.mutable.ArrayBuffer
class Counter {
  //val will not generate setter
  private var value = 0
  //no setter/getter for private[this], cannot be accessed by other objects
  private[this] val test = 0
  @BeanProperty var name: String = _
  def increment() {value += 1}
  def current() = value
  def v = value
  def v_=(newVal: Int): Unit = {
    if (newVal > value) value = newVal
  }
  def Test(other: Counter): Unit = {
    println(other.value)
  }
}

class Person private (@BeanProperty var name: String = "", private val age: Int) { outer =>
  println("created an instance")
  def this(name: String) {
    this(name, 0)
  }
  class Friend(val name: String) {
    val contacts = new ArrayBuffer[Friend]
    println("In object %s %s", Person.this.name, outer.name)
  }
  private val friends = new ArrayBuffer[Friend]
  def join(name: String) = {
    val m = new Friend(name)
    friends += m
    m
  }
}

object cls {
  def main(args: Array[String]) {
    val counter = new Counter
    counter.increment()
    println(counter.current())
    counter.increment
    println(counter.current)
    counter.v = 20
    println(counter.v)
    counter.v = 10
    println(counter.v)
    val cnt = new Counter
    counter.Test(cnt)
    println(counter.name)
    counter.name = "Wei"
    println(counter.name)

    val one = new Person("Wei")
    val two = new Person("Qu")
    println(one, two)
    val oneF = one.join("Sandy")
    val oneF1 = one.join("Austin")
    val twoF = two.join("Chuanbo")
    oneF.contacts += oneF1
    /* won't work
    twoF.contacts += oneF
    */
  }
}