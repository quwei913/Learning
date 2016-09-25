/**
  * Created by quwei on 16/9/25.
  */

object Name {
  def unapply(input: String) = {
    val pos = input.indexOf(" ")
    if (pos == -1) None
    else Some((input.substring(0,pos), input.substring((pos + 1))))
  }
}

object Number {
  def unapply(input: String): Option[Int] =
    try {
      Some(Integer.parseInt(input.trim))
    } catch {
      case ex: NumberFormatException => None
    }
}

object text {
  //any length of the input
  def unapplySeq(input: String): Option[Seq[String]] =
    if (input.trim == "") None else Some(input.trim.split("\\s+"))
}

object op extends App {
  val scores = new scala.collection.mutable.HashMap[String, Int]
  scores.update("Bob" , 10)
  val bobScore = scores.apply("Bob")
  println(scores)
  println(bobScore)
  val author = "Cay Horstmann"
  val Name(first, last) = author
  println(first, last)
}