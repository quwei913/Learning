package com.scala.demo

import java.io.File

import scala.io.Source

object impcv extends App {
  class RichFile(val from: File) {
    def read = Source.fromFile(from.getPath).mkString
  }
  implicit def file2RichFile(from: File) = new RichFile(from)
  case class Delimiters(left: String, right: String)
  def quote(what: String)(implicit delims: Delimiters) =
    delims.left + what + delims.right
  quote("Bonjour le monde") (Delimiters("<<", ">>"))

  def smaller[T](a: T, b: T) (implicit order: T => Ordered[T])
  = if (order(a) < b) a else b

  def firstLast[A, C](it: C)(implicit ev: C <:< Iterable[A]) =
    (it.head, it.last)
}

