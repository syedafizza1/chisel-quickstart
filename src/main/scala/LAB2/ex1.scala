package LAB2

import chisel3._
import chisel3.util._
import chisel3.core


class Mux2to1_IO extends Bundle {
    val in_A = Input ( UInt (32. W ) )
    val in_B = Input ( UInt (32. W ) )
    val select = Input ( Bool () )
    val out = Output ( UInt () )
}
// 2 to 1 Mux implementation
class ex1 extends Module {
    val io = IO ( new Mux2to1_IO )
    when (io.select === 1.U){io.out := io.in_A}
    .otherwise{io.out := io.in_B}
}