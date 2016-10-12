import com.scala.demo.SavingAccount

/**
  * Created by quwei on 16/9/26.
  */

object pattern {

  def main(args: Array[String]): Unit = {
    var sign = 0
    var ch: Char = '-'
    ch match {
      case '+' => sign = 1
      case '-' => sign = -1
      case _ => sign = 0
    }
    println(sign)
    ch = '9'
    var digit:Int = 0
    ch match {
      case '+' => 1
      case '-' => -1
      case ch if Character.isDigit(ch) => digit = Character.digit(ch, 10)
      case _ => sign = 0
    }
    println(sign)
    /*
    o match {
      case x: Int => x
      case s: String => Integer.parseInt(s)
      case m: Map[String, Int] => ...
      case _: BigInt => Int.MaxValue
      case _ => 0
    }
    */
    val arr: Array[Int] = Array(1 ,2, 3)
    arr match {
      case Array(0) => "0"
      case Array(x, y) => x + " " + y
      case Array(0, _*) => "0 ..."
      case _ => "something else"
    }
    val lst: List[Int] = List(1 ,2, 3, 4)
    println(lst match {
      case 0 :: Nil => "0"
      case x :: y :: Nil => x + " " + y
      case 0 :: tail => "0 ..."
      case _ => "something else"
    })
    val pair: (Int, Int) = (11, 1)
    pair match {
      case (0, _) => "0 ..."
      case (y, 0) => y + " 0"
      case _ => "neither is 0"
    }
    val (q, r) = scala.math.BigInt(10) /% 3
    println(q, r)
    val Array(first, second, _*) = arr
    println(first, second)
    /*for ((k, v) <- System.getProperties())
      println(k + " -> " + v)
    for ((k, "") <- System.getProperties())
      println(k)*/
    abstract class Amount
    case class Dollar(value: Double) extends Amount
    case class Currency(value: Double, unit: String) extends Amount
    case object Nothing extends Amount
    val amt: Amount = new Dollar(4)
    amt match {
      case Dollar(v) => "$" + v
      case Currency(_, u) => "Oh noes, I got " + u
      case Nothing => ""
    }
    val a = Currency(1.0, "EUR")
    val p = a.copy()
    val price = a.copy(unit = "CHF")
    //sealed means all child classes should be defined in the parent's file
    sealed abstract class Item
    case class Article(description: String, price: Double) extends Item
    case class Bundle(description: String, discount: Double, items: Item*) extends Item
    val b =Bundle("Father's day special", 20.0,
      Article("Scala for the Impatient", 39.95),
      Bundle("Anchor Distillery Sampler", 10.0,
        Article("Old Potrero Straight Rye Whisky", 79.95),
        Article("Junipero Gin", 32.95)))

    b match {
      case Bundle(_, _, Article(descr, _), _*) => "first"
      case Bundle(_, _, art @ Article(_, _), rest@_*) => "second"
    }
    /*
    def price(it: Item): Double = it match {
      case Article(_, p) => p
      case Bundle(_, disc, its @ _*) => its.map(price _).sum - disc
    }
    */
    sealed abstract class TrafficLight
    case object Red extends TrafficLight
    case object Yellow extends TrafficLight
    case object Green extends TrafficLight
    val color: TrafficLight = Red
    println(
      color match {
        case Red => "stop"
        case Yellow => "hurry up"
        case Green => "go"
      }
    )
    val scores:Map[String, Int] = Map(("Alce", 10), ("Wei", 20))
    scores.get("Alice") match {
      case Some(score) => println(score)
      case None => println("pattern No score")
    }
    val aliceScore = scores.get("Alice")
    if (aliceScore.isEmpty) println("No score")
    else println(aliceScore.get)
    println(aliceScore.getOrElse("getOrElse, No score"))
    println(scores.getOrElse("Alice", "Map no score"))
    for (score <- scores.get("Alice")) println(score)
    scores.get("Alice").foreach(println _)
    val f: PartialFunction[Char, Int] = { case '+' => 1 ; case '-' => -1 }
    println(f('-'))
    println(f.isDefinedAt('0'))
    println("-3+4".collect(f))
    try {
      f('0')
    } catch {
      case ex:Throwable => None
    }
  }
}