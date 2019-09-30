// TODO remove avoid_tpolecat_insecure_warn.sbt when update tut
// https://github.com/scalajp/scala_text/commit/5ef3b9e14eabd1dc68b28980f6d34b29b080400d
addSbtPlugin("org.tpolecat" % "tut-plugin" % "0.6.12")

fullResolvers ~= {_.filterNot(_.name == "jcenter")}

addSbtPlugin("com.github.xuwei-k" % "sbt-class-diagram" % "0.2.1")
