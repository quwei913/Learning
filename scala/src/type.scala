import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.io.Source

/**
  * Created by quwei on 16/10/12.
  */
object Title
class Document {
  private var useNextArgAs: Any = null
  def setTitle(title: String): this.type = { println("set title in Document " + title); this }
  def set(obj: Title.type): this.type = { useNextArgAs = obj; this }
  def setAuthor(author: String) = { println("set author in Document " + author); this }
}

class Book extends Document {
  def addChapter(chapter: String) = { println("add chatper " + chapter); this }
  import scala.collection.mutable._
  //you can use Book.index
  type index = HashMap[String, (Int, Int)]
  def appendLines(target: { def append(str: String): Any },
                  lines: mutable.Iterable[String]) {
                  for(l <- lines) { target.append(l); target.append("\n") }
                  }
}

class Network {
  class Member(val name: String) {
    val contacts = new ArrayBuffer[Member]
  }
  //can accept Member from other Network instances
  private val members = new ArrayBuffer[Network#Member]
  def join(name: String) = {
    val m = new Member(name)
    members += m
    m
  }
  //only accept member from same network
  def process[M <: n.Member forSome { val n: Network }](m1: M, m2: M) = (m1, m2)
}

trait lgd {
  def log(msg: String)
}

trait Reader {
  type Contents
  def read(fileName: String): Contents
}

class StringReader extends Reader {
  type Contents = String
  def read(fileName: String) = Source.fromFile(fileName, "UTF-8").mkString
}

class ImageReader extends Reader {
  type Contents = BufferedImage
  def read(fileName: String) = ImageIO.read(new File(fileName))
}

trait LoggedException extends lgd {
  //can only be mixed into class which extends Exception. won't be inherited
  this: Exception =>
  def log() { log(getMessage()) }
}

object typeO extends App {
  val book = new Book()
  book.setTitle("Wei Qu").addChapter("chapter 1")
  val image = new ArrayBuffer[java.awt.Shape with java.io.Serializable]
  type |[A, B] = (A, B)
}