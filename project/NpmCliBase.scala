import sbt._
import sbt.complete.Parser

trait NpmCliBase {
  val nodeBin = file("node_modules/.bin/")

  val srcDir = file("src")
  def srcMarkdowns = srcDir.listFiles("*.md")

  val bookBuildDir = file("gitbook")
  val compiledSrcDir = bookBuildDir / "generated_src"

  val testDir = file("test")

  protected def rawStringArg(argLabel: String = "<arg>"): Parser[String] = {
    Def.spaceDelimited(argLabel).map(_.mkString(" "))
  }

  def printRun(p: ProcessBuilder) : Unit = {
    p.lines foreach println
  }
}
