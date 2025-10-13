addSbtPlugin("org.scalameta" % "sbt-mdoc" % "2.8.0")

fullResolvers ~= {_.filterNot(_.name == "jcenter")}

addSbtPlugin("com.github.xuwei-k" % "sbt-class-diagram" % "0.3.1")
