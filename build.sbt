name := "proto_wrap"

version := "1.0"

scalaVersion := "2.11.8"

PB.targets in Compile := Seq(
  PB.gens.java -> (sourceManaged in Compile).value,
  scalapb.gen(javaConversions=true) -> (sourceManaged in Compile).value
)

libraryDependencies ++= Seq(
  "com.trueaccord.scalapb" %% "scalapb-runtime" % com.trueaccord.scalapb.compiler.Version.scalapbVersion % "protobuf",
  "com.google.protobuf" % "protobuf-java-util" % com.trueaccord.scalapb.compiler.Version.protobufVersion
)
