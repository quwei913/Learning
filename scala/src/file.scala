/**
  * Created by wqu on 9/23/2016.
  */
import java.io.{File, FileInputStream, PrintWriter}

import com.sun.deploy.util.SyncFileAccess.FileInputStreamLock
import com.sun.xml.internal.ws.developer.Serialization

import scala.collection.mutable.ArrayBuffer
import scala.io.Source
object file extends App {
  val source = Source.fromFile("D:\\git_repository\\Learning\\scala\\src\\myFile.txt", "UTF-8")
  val lineIterator = source.getLines
  for (l <- lineIterator) println(l)
  val lines = source.getLines.toArray
  println(lines)
  val contents = source.mkString
  println(contents)
  source.close()
  val src = Source.fromFile("D:\\git_repository\\Learning\\scala\\src\\myFile.txt", "UTF-8")
  /*
  val iter = src.buffered
  while (iter.hasNext) {
    println(iter.head)
  }
  */
  for (c <- src) println(c)
  src.close()
  val file = new File("D:\\git_repository\\Learning\\scala\\src\\myFile.txt")
  val in = new FileInputStream(file)
  val bytes = new Array[Byte](file.length.toInt)
  in.read(bytes)
  in.close()
  val out = new PrintWriter("numbers.txt")
  for (i <- 1 to 100) out.println(i)
  out.close()

  def subdirs(dir: File): Iterator[File] = {
      val children = dir.listFiles.filter(_.isDirectory)
      children.toIterator ++ children.toIterator.flatMap(subdirs _)
  }
  /* access subdir like this
  import java.nio.file._
  for (d <- subdirs(dir)) println(d)
  implicit def makeFileVisitor(f: (Path) => Unit) = new SimpleFileVisitor[Path] {
    overrride def visitFile(p: Path, attrs: attribute.BasicFileAttributes) = {
      f(p)
      FileVisitResult.CONTINUE
    }
  }
  Files.walkFileTree(dir.toPath, (f: Path) => println(f))
  */
  @SerialVersionUID(42L) class Person extends Serializable {
    private val friends = new ArrayBuffer[Person]
  }
  var fred = new Person()
  import java.io._
  val o = new ObjectOutputStream(new FileOutputStream("test.obj"))
  o.writeObject(fred)
  o.close()
  val inf = new ObjectInputStream(new FileInputStream("test.obj"))
  val savedFred = inf.readObject().asInstanceOf[Person]
  import sys.process._
  "java -version" !
  /*val result:String = "java -version" !!
  "java -version" #| "findstr 1.8" !
  "java -version" #> new File("myFile.txt") !
  "java -version" #>> new File("myFile.txt") !
  "findstr wei" #< new File("myFile.txt") !
  "java -version" #> new URL("http://www.google.com") !
  "java -version" #&& "java" !
  val p = Process(cmd, new File(dirName), ("LANG", "en_US"))
  "echo 42" #| p !
  */
  val numPattern = "[0-9]+".r
  val wsnumwsPattern = """\s+[0-9]+\s+""".r
  for (matchString <- numPattern.findAllIn("99 bottles, 98 bottles")) println(matchString)
  val matches = numPattern.findAllIn("99 bottles, 98 bottles").toArray
  println(matches)
  val m1 = wsnumwsPattern.findFirstIn("99 bottles, 98 bottles")
  println(m1)
  println(numPattern.findPrefixOf("99 bottles, 98 bottles"))
  println(wsnumwsPattern.findPrefixOf("99 bottles, 98 bottles"))
  println(numPattern.replaceFirstIn("99 bottles, 98 bottles", "XX"))
  println(wsnumwsPattern.replaceAllIn("99 bottles, 98 bottles", "xx"))
  val numitemPattern = "([0-9]+) ([a-z]+)".r
  val numitemPattern(num, item) = "99 bottles"
  println(num, item)
  for (numitemPattern(num, item) <- numitemPattern.findAllIn("99 bottles, 98 bottles"))
    println(num, item)
}