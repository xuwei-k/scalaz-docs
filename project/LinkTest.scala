import sbt._
import scala.sys.process.Process

object LinkTest extends NpmCliBase {
  val eslintBin = nodeBin / "eslint"
  val mochaBin = nodeBin / "mocha"

  @transient
  lazy val eslint = taskKey[Unit]("lint js")
  @transient
  lazy val linkTest = taskKey[Unit]("verify links")

  val settings = Seq(
    eslint := printRun(Process(s"$eslintBin ${srcDir.listFiles("*.js")} ${testDir.listFiles("*.js")}")),
    linkTest := printRun(Process(s"$mochaBin"))
  )
}
