libraryDependencies ++= Seq(
  "net.databinder" %% "dispatch-http" % "0.8.3",
  "net.databinder" %% "dispatch-lift-json" % "0.8.3",
  "com.github.scopt" %% "scopt" % "1.1.1",
  // launcher *not* "provided", so app can run without
  "org.scala-tools.sbt" % "launcher-interface" % "0.10.0"
)

seq(ProguardPlugin.proguardSettings :_*)

proguardOptions ++= Seq(
  "-keep class conscript.* { *; }",
  "-keep class org.apache.commons.logging.impl.LogFactoryImpl { *; }",
  "-keep class org.apache.commons.logging.impl.Jdk14Logger { *; }"
)

minJarPath <<= (target, version) { (t,v) =>
  t / ("conscript-" + v + ".jar")
}