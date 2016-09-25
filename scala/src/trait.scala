/**
  * Created by quwei on 16/9/23.
  */
package com.scala.demo
trait Logger {
  def log(msg: String) { }
}

class ConsoleLogger extends Logger with Cloneable with Serializable {
  override def log(msg: String) {
    println("consolelogger:: %s".format(msg))
  }
}

trait cLogger extends Logger {
  override def log(msg: String) {
    super.log("cLogger:: %s".format(msg))
  }
}

trait myLogger extends Logger {
  override def log(msg: String) {println(msg)}
}

class SavingAccount(val i: Int, val bal: Double) extends Account(i, bal) with cLogger {
  def withDraw(amount: Double): Unit = {
    if (amount > balance) log("Insufficient funds")
    else balance -= amount
  }
}

trait lg extends Logger {
  override def log(msg: String) {
    super.log("logger: %s".format(msg))
  }
}

trait Logged {
  def log(msg: String)
  def info(msg: String) {println("INFO: " + msg)}
}

trait l extends Logged {
  abstract override def log(msg: String): Unit = {
    super.log("l: %s".format(msg))
  }
}

trait flog extends Logged {
  val name:String
  lazy val time:String = name.hashCode.toString  //another inefficient way
  override def log(msg: String): Unit = {
    println(msg)
  }
}

trait LoggedException extends Logged {
  //can only be mixed with Exception's trait
  this: Exception =>
    def log() { log(getMessage()) }
}

trait LoggerException extends Logged {
  //can only be mixed with trait which has method getMessage()
  this: { def getMessage(): String } =>
  def log() { log(getMessage()) }
}

object trt extends App {
  val acct = new SavingAccount(1, 1)
  acct.withDraw(2)
  /* why the order doesn't differentiate???? */
  val acc = new SavingAccount(2, 2) with myLogger with lg
  acc.withDraw(3)
  val ac = new SavingAccount(3, 3) with lg with myLogger
  ac.withDraw(4)
  val a = new {
    val name = "out.log"
  } with flog
}
