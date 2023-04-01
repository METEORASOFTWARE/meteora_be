name := """meteora_be"""

version := "1.21.164.mb12" 

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

// Play core dependencies
libraryDependencies ++= Seq(
	jdbc,
	cache,
	ws,
	specs2 % Test
)

// Play external dependencies
libraryDependencies ++= Seq(
	"com.typesafe.play" %% "anorm" % "2.4.0"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
