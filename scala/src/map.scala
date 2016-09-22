package com.scala.demo
import scala.collection.JavaConversions.mapAsScalaMap
import scala.collection.JavaConversions.propertiesAsScalaMap
import scala.collection.JavaConversions.mapAsJavaMap
import java.awt.font.TextAttribute._

object map {
  def main(args: Array[String]) {
    val s = Map(("Wei Qu" -> 10), ("Na He" -> 20))
    val sc = scala.collection.mutable.Map(("Frank Qu" -> 10), ("Sandy He" -> 20))
    val sco = new scala.collection.mutable.HashMap[String, Int]
    val scor = Map(("Austin Qu" -> 10), ("Na He" -> 20))
    val age = if (s.contains("Wei Qu")) s("Wei Qu") else 0
    val a = s.getOrElse("Na", 0)
    println(s)
    println(sc)
    println(sco)
    println(scor)
    println(age)
    println(a)
    sc += ("Betty Qu" -> 2)
    println(sc)
    sc -= "Sandy He"
    println(sc)
    for ((k, v) <- sc)
      println(k, v)

    for((i, j) <- for ((k, v) <- sc) yield (v, k))
      println(i, j)

    for (k <- sc.keySet) println(sc(k))
    for (v <- sc.values) println(v)

    val sort = scala.collection.immutable.SortedMap(("Wei Qu" -> 10), ("Sandy He" -> 20))
    println(sort)

    val scores: scala.collection.mutable.Map[String, Int] = new java.util.TreeMap[String, Int]
    println(scores)
    val props: scala.collection.Map[String, String] = System.getProperties()
    println(props)
    val attrs = Map(FAMILY -> "Serif", SIZE -> 12)
    println(attrs)
    val font = new java.awt.Font(attrs)
    println(font)
  }
}