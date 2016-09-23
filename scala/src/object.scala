/**
  * Created by wqu on 9/23/2016.
  */
package com.scala.demo

abstract class UndoableAction(val description: String) {
  def undo(): Unit
  def redo(): Unit
}

object DoNothingAction extends UndoableAction("Do nothing") {
  override def undo() {}
  override def redo() {}
}

class Account private (val id: Int, initialBalance: Double) {
  private var balance = initialBalance
  def deposit(amount: Double) {balance += amount}
}

object Account {
  private var lastNumber = 0
  private def newUniqueNumber() = {lastNumber += 1; lastNumber}
  def apply(initialBalance: Double) = new Account(newUniqueNumber(), initialBalance)
}

object TrafficLightColor extends Enumeration {
  type TrafficLightColor = Value
  val Red, Yellow, Green = Value
}

object obj extends App{
  if (args.length > 0)
    println(args(0))
  else
    println("No args")
  val acct = Account(1000.0)
  println(acct)
  val actions = Map("open" -> DoNothingAction, "save" -> DoNothingAction)
}
