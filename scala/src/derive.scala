import scala.collection.mutable.ArrayBuffer

/**
  * Created by wqu on 9/23/2016.
  */

class Person(val name:String = "") {
  override def toString = getClass.getName + "[name=" + name + "]"
}

class Employee(override val name:String, private var salary:Int = 1000) extends Person(name) {
  override def toString = super.toString + this.getClass.getName + "[Salary=" + salary + "]"
  final override def equals (other:Any) = {
    val that = other.asInstanceOf[Employee]
    if (that == null) false
    else name == that.name && salary == that.salary
  }
}

class Square(x: Int, y: Int, width: Int) extends java.awt.Rectangle(x, y, width, width)

abstract class P {
  def id: Int
}
class Student extends P {
  def id = 111
}

class T {
  val size:Int = 10
  val s: Array[Int] = new Array[Int](size)
}

class sT extends {
  override val size = 2
} with T

class sT1 extends T {
  override val size = 2
}

object derive {
  def main(args: Array[String]): Unit = {
    val p:Employee = new Employee("Wei")
    if (p.isInstanceOf[Person]) {
      println("Instance of person")
      println(p)
      val s = p.asInstanceOf[Employee]
      println(s.getClass)
      println(classOf[Person])
      println(s)
    }
    val alien = new Person("Fred") {
      def greeting = "Greetings, Earthling! My name is Fred."
    }
    def meet(p: Person{def greeting: String}): Unit = {
      println("%s says:%s".format(p.name, p.greeting))
    }
    def printAny(x: Any) { println(x) }
    def printUnit(x: Unit) { println(x) }
    printAny("aa")
    printUnit("aa")
    val s1 = new sT
    val s2 = new sT1
    println("%d, %d".format(s1.s.length, s2.s.length))
  }
}