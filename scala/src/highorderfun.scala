/**
  * Created by quwei on 16/9/25.
  */
import java.awt.event.{ActionEvent, ActionListener}
import javax.swing.JButton

import scala.math._
object highOrder extends App {
  val num = 3.14
  val fun = ceil _
  println(Array(3.14, 1.42, 2.0).map(fun))
  var triple = (x: Double) => 3 * x
  println(Array(3.14, 1.42, 2.0).map((x: Double) => 3 * x))
  def valueAtOneQuarter(f: (Double) => Double) = f(0.25)
  println(valueAtOneQuarter(ceil _))
  def mulBy(factor: Double) = (x: Double) => factor * x
  val quintuple = mulBy(5)
  println(quintuple(20))
  println(valueAtOneQuarter(3 * _))
  (1 to 9).map("*" * _).foreach(println _)
  (1 to 9).filter(_ % 2 == 0).foreach(println _)
  println((1 to 9).reduceLeft(_ * _))
  println("Wei QU is father of Austin Qu".split(" ").sortWith(_.length < _.length).toBuffer)
  var counter = 0
  val button = new JButton("Increment")
  button.addActionListener(new ActionListener {
    override def actionPerformed(event: ActionEvent): Unit = {
      counter += 1
    }
  })
  implicit def makeAction(action: (ActionEvent) => Unit) =
    new ActionListener {
      override def actionPerformed(event: ActionEvent) { action(event) }
    }

  def mulOneAtATime(x: Int)(y: Int) = x * y
  println(3 * 7)
  val a = Array("Hello", "World")
  val b = Array("hello", "world")
  println(a.corresponds(b)(_.equalsIgnoreCase(_)))

  def runInThread(block: () => Unit): Unit = {
    new Thread {
      override def run() { block() }
    }.start()
  }
  runInThread { () => println("Hi"); Thread.sleep(1000); println("Bye") }
  def runThread(block: => Unit): Unit = {
    new Thread {
      override def run() { block }
    }.start()
  }
  runThread { println("Hi, Wei"); Thread.sleep(1000); println("Bye, Wei") }

  def until(condition: => Boolean) (block: => Unit): Unit = {
    if (!condition) {
      block
      until(condition)(block)
    }
  }
  var x = 10
  until(x == 0) {
    x -= 1
    println(x)
  }

  def indexOf(str: String, ch: Char): Int = {
    var i = 0
    until (i == str.length) {
      if (str(i) == ch) return i
      i += 1
    }
    return -1
  }
}