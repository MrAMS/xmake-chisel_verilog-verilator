// import Mill dependency
import mill._
import mill.define.Sources
import mill.modules.Util
import mill.scalalib.TestModule.ScalaTest
import scalalib._
// support BSP
import mill.bsp._

import os.Path

trait base extends SbtModule { m =>
    override def millSourcePath = os.pwd
    override def scalaVersion = "2.13.12"
    override def scalacOptions = Seq(
        "-language:reflectiveCalls",
        "-deprecation",
        "-feature",
        "-Xcheckinit",
    )
    override def ivyDeps = Agg(
        ivy"org.chipsalliance::chisel:5.1.0",
    )
    override def scalacPluginIvyDeps = Agg(
        ivy"org.chipsalliance:::chisel-plugin:5.1.0",
    )
}

trait testable extends SbtModule { m =>
    object test extends SbtModuleTests with TestModule.ScalaTest {
        override def ivyDeps = m.ivyDeps() ++ Agg(
            ivy"edu.berkeley.cs::chiseltest:5.0.2"
        )
    }
}

object demo extends base with testable
