addSbtPlugin("org.scalameta" % "sbt-mdoc" % "2.3.4")

fullResolvers ~= {_.filterNot(_.name == "jcenter")}

addSbtPlugin("com.github.xuwei-k" % "sbt-class-diagram" % "0.2.1")
