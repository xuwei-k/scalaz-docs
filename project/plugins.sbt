addSbtPlugin("org.tpolecat" % "tut-plugin" % "0.6.13")

fullResolvers ~= {_.filterNot(_.name == "jcenter")}

addSbtPlugin("com.github.xuwei-k" % "sbt-class-diagram" % "0.2.1")
