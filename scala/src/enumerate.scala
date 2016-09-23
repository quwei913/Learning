package com.scala.demo

import com.scala.demo.TrafficLightColor.TrafficLightColor

object enumerate {
  def main(args: Array[String]) {
    def doWhat(color: TrafficLightColor):String = {
      if (color == TrafficLightColor.Red) "stop"
      else if (color == TrafficLightColor.Yellow) "hurry up"
      else "go"
    }
    val light:TrafficLightColor = TrafficLightColor.Red
    println(doWhat(light))
    val c:TrafficLightColor = TrafficLightColor.withName("Green")
    println(doWhat(c))
    for (co <- TrafficLightColor.values)
      println(doWhat(co))
  }
}