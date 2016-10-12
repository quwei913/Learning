import com.sun.istack.internal.NotNull
import org.w3c.dom.Entity

import scala.beans.BeanProperty
import scala.util.control.TailCalls._

/**
  * Created by quwei on 16/10/5.
  */

/*@Entity class Credentials {
  @BeanProperty var username : String = _
  @BeanProperty var password : String = _
}*/

object notation extends App {
  def evenLength(@NotNull xs: Seq[Int]): TailRec[Boolean] =
    if (xs.isEmpty) done(true) else tailcall(oddLength(xs.tail))
  def oddLength(xs: Seq[Int]): TailRec[Boolean] =
    if (xs.isEmpty) done(false) else tailcall(evenLength(xs.tail))

  println(evenLength(1 to 10000).result)

  def allDifferent[@specialized(Long, Double) T] (x: T, y: T, z: T) = x != y && x !=z && y != z
}