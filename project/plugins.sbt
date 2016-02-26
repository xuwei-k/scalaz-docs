addSbtPlugin("org.tpolecat" % "tut-plugin" % "0.4.2")

fullResolvers ~= {_.filterNot(_.name == "jcenter")}

addSbtPlugin("com.github.xuwei-k" % "sbt-class-diagram" % "0.1.7")
