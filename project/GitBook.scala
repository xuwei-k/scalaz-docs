import sbt._
import tut.Plugin._

object GitBook extends NpmCliBase {
  val gitbookBin = nodeBin / "gitbook"

  sealed trait Format {def command: String}
  object Format {
    case object Html extends Format { def command = "build" }
    case object Epub extends Format { def command = "epub" }
    case object Pdf extends Format { def command = "pdf" }
  }

  def buildBook(format: Format) = Def.inputTask[Int] {
    val options = rawStringArg("<gitbook command>").parsed
    printRun(Process(s"$gitbookBin ${format.command} $bookBuildDir --gitbook=2.6.7 $options"))

    if(format == Format.Html) {
      val cssPath = s"$bookBuildDir/_book/gitbook/style.css"
      val src = IO.read(file(cssPath))
      val modified = src.replace("text-rendering:optimizeLegibility;", "")
      assert(src.length != modified.length, "CSSの削除に失敗？ " + src.length)
      IO.write(file(cssPath), modified)
    }
    0
  }

  lazy val pluginInstall = taskKey[Seq[String]]("install GitBook plugin")
  lazy val helpGitBook = taskKey[Seq[String]]("help GitBook")
  lazy val build = taskKey[Int]("build GitBook to html (an alias of html)")
  lazy val pdf = taskKey[Int]("build GitBook to pdf")
  lazy val html = inputKey[Int]("build GitBook to html")
  lazy val epub = inputKey[Int]("build GitBook to epub")
  lazy val buildAll = taskKey[Int]("build GitBook to all format")

  val settings = Seq(
    pluginInstall := printRun(Process(s"$gitbookBin install")),
    helpGitBook := printRun(Process(s"$gitbookBin help")),
    html := buildBook(Format.Html).dependsOn(tut).evaluated,
    build := html.toTask("").value,
    epub := buildBook(Format.Epub).dependsOn(tut).evaluated,
    pdf := buildBook(Format.Pdf).dependsOn(tut).toTask("").value,
    buildAll := epub.toTask("").dependsOn(html.toTask("")).value
  )
}
