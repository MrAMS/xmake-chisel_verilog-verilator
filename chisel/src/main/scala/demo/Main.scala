package demo

import chisel3._
import chisel3.util._ 
import _root_.circt.stage._

object Main extends App {
    val build_dir = "./build"
    def exportVerilog(core: () => chisel3.RawModule): Unit = {
        println("Export Verilog Started")
        val chiselStageOption = Seq(
            chisel3.stage.ChiselGeneratorAnnotation(() => core()),
            CIRCTTargetAnnotation(CIRCTTarget.Verilog)
        )
        val firtoolOptions = Seq(
            // FirtoolOption("--lowering-options=disallowLocalVariables,locationInfoStyle=wrapInAtSquareBracket,noAlwaysComb"),
            FirtoolOption("--lowering-options=disallowLocalVariables,disallowPackedArrays,locationInfoStyle=wrapInAtSquareBracket,noAlwaysComb"),

            FirtoolOption("--split-verilog"),
            FirtoolOption("-o=" + build_dir),
            FirtoolOption("--disable-all-randomization"),
        )
        val executeOptions = chiselStageOption ++ firtoolOptions
        val executeArgs = Array("-td", build_dir)
        (new ChiselStage).execute(executeArgs, executeOptions)
    }
    exportVerilog(() => new Demo)
}