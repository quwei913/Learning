/**
  * Created by wqu on 9/23/2016.
  */
import java.awt.Color._
import java.util.{ArrayList, HashSet => JavaHashSet, HashMap => _, _}
import scala.collection.mutable._
package com {
  package horstmann {
    object Utils {
      def percentof(value: Double, rate: Double) = value * rate / 100
    }
    package impatient {
      package object people {
        val defaultName = "Wei Qu"
      }
      package people {
        class Person {
          var name = defaultName
          private[people] def description = "Can be seen in the package only"
          private[impatient] def desc = "Can be seen in the parent package"
        }
      }
      class Manager {
        val subordinates = new _root_.scala.collection.mutable.ArrayBuffer[Employee]
      }
      class Employee(private var salary:Double = 0) {
        def giveRaise(rate: Double) {
          salary += Utils.percentof(salary, rate)
        }
      }
    }
  }
}
object pkg extends App {
  val c1 = RED
  val c2 = decode("#ff0000")
}
