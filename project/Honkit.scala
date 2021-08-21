import sbt._
import scala.sys.process.Process
import mdoc.MdocPlugin.autoImport.mdoc

object Honkit extends NpmCliBase {
  val honkitBin = nodeBin / "honkit"

  sealed trait Format {def command: String}
  object Format {
    case object Html extends Format { def command = "build" }
    case object Epub extends Format { def command = "epub" }
    case object Pdf extends Format { def command = "pdf" }
  }

  def buildBook(format: Format) = Def.inputTask[Int] {
    val options = rawStringArg("<honkit command>").parsed
    val command = s"$honkitBin ${format.command} $bookBuildDir $options"
    printRun(Process(command))
    0
  }

  lazy val helpHonkit = taskKey[Seq[String]]("help Honkit")
  lazy val build = taskKey[Int]("build Honkit to html (an alias of html)")
  lazy val pdf = taskKey[Int]("build Honkit to pdf")
  lazy val html = inputKey[Int]("build Honkit to html")
  lazy val epub = inputKey[Int]("build Honkit to epub")
  lazy val buildAll = taskKey[Int]("build Honkit to all format")

  private[this] val mdocTask = mdoc.toTask("")

  val settings = Seq(
    helpHonkit := printRun(Process(s"$honkitBin help")),
    html := buildBook(Format.Html).dependsOn(mdocTask).evaluated,
    build := html.toTask("").value,
    epub := buildBook(Format.Epub).dependsOn(mdocTask).evaluated,
    pdf := buildBook(Format.Pdf).dependsOn(mdocTask).toTask("").value,
    buildAll := epub.toTask("").dependsOn(html.toTask("")).value
  )
}
