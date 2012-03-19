name := "futuretest"

version := "0.9.1"

organization := "com.holden"

crossScalaVersions := Seq("2.9.1")

libraryDependencies <++= (scalaVersion) { scalaVersion =>
  val specsVersion = scalaVersion match {
    case "2.8.0" => "1.6.5"
    case "2.9.1" => "1.6.9"
    case _       => "1.6.8"
  }
  val scalaCheckVersion = scalaVersion match {
    case "2.8.0" => "1.8"
    case "2.8.1" => "1.8"
    case _ => "1.9"
  }
  Seq(
    "org.scala-tools.testing" %% "scalacheck"         % scalaCheckVersion   % "test",
    "junit"                    % "junit"               % "[4.8.2,)"        % "test",
    "com.novocode"             % "junit-interface"     % "[0.7,)"        % "test" ,
    "org.scala-tools.testing" %% "specs"               % specsVersion % "test",
    "org.scala-tools.testing" %% "scalacheck"         % scalaCheckVersion   % "test",
    "com.twitter"             % "util-core"             % "1.12.9"  % "compile",
    "com.twitter"             % "util-eval"             % "1.12.9"  % "compile",
    "com.twitter"             % "util-codec"             % "1.12.9"  % "compile",
    "com.twitter"             % "util-collection"             % "1.12.9"  % "compile",
    "com.twitter"             % "util-reflect"             % "1.12.9"  % "compile",
    "com.twitter"             % "util-logging"             % "1.12.9"  % "compile",
    "com.twitter"             % "util-hashing"             % "1.12.9"  % "compile",
    "com.twitter"             % "util-zk"             % "1.12.9"  % "compile",
    "org.scalaj"              %% "scalaj-collection" % "1.2"
  )
}

resolvers += "Bryan J Swift Repository" at "http://repos.bryanjswift.com/maven2/"

resolvers += "twitter maven repo" at "http://maven.twttr.com/"

resolvers += "codehaus maven repo" at "http://repository.codehaus.org/"

resolvers += "sonatype maven repo" at "http://oss.sonatype.org/content/repositories/releases/"

resolvers <++= (version) { v =>
  if (v.endsWith("-SNAPSHOT"))
    Seq(ScalaToolsSnapshots)
  else
    Seq()
}

scalacOptions ++= Seq("-deprecation", "-unchecked")

testFrameworks += new TestFramework("com.novocode.junit.JUnitFrameworkNoMarker")

ivyXML := (
<dependencies>
 <exclude module="jmxtools"/>
 <exclude module="jmxri"/>
 <exclude module="jms"/>
 <exclude org="com.codahale" name="jerkson_2.8.1"/>
 <exclude org="bouncycastle" name="bcprov-jdk14"/>
 <exclude org="bouncycastle" name="bcmail-jdk14"/>
</dependencies>
)
