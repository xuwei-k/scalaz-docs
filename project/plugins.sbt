addSbtPlugin("org.scalameta" % "sbt-mdoc" % "2.2.22")

fullResolvers ~= {_.filterNot(_.name == "jcenter")}

addSbtPlugin("com.github.xuwei-k" % "sbt-class-diagram" % "0.2.1")
