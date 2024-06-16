package demo

import chisel3._
import chisel3.util._

class Demo extends Module {
  val io = IO(new Bundle {
    val out = Output(UInt(3.W))
  })

  val reg = RegInit(0.U(3.W))
  reg := reg + 1.U
  io.out := reg
}