import sbt._

object LinkTest extends NpmCliBase {
  val eslintBin = nodeBin / "eslint"
  val mochaBin = nodeBin / "mocha"

  lazy val eslint = taskKey[Unit]("lint js")
  lazy val linkTest = taskKey[Unit]("verify links")

  val settings = Seq(
    eslint := printRun(Process(s"$eslintBin ${srcDir.listFiles("*.js")} ${testDir.listFiles("*.js")}")),
    linkTest := printRun(Process(s"$mochaBin"))
  )
}
