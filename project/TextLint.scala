import sbt._

import scala.util.control.NonFatal

object TextLint extends NpmCliBase {
  val textlintBin = nodeBin / "textlint"

  lazy val textlint = inputKey[Unit]("lint text")

  val settings = Seq(
    textlint := {
      val args = rawStringArg(srcMarkdowns.mkString("\n")).parsed
      val options = if(args.isEmpty) s"$srcDir" else args

      try {
        printRun(Process(s"$textlintBin $options"))
      } catch {
        case NonFatal(e) =>
      }
    }
  )
}
