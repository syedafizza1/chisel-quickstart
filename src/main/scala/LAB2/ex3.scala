package LAB2

import chisel3._
import chisel3.util._

class ex3 extends Module{
    val io = IO(new encoderIO)

    val sel = Cat(io.in1, io.in2, io.in3, io.in4)
    io.out1 := Mux1H(sel, Seq("b00".U, "b01".U, "b10".U, "b11".U))
}

class encoderIO extends Bundle{
    val in1 = Input(Bool())
    val in2 = Input(Bool())
    val in3 = Input(Bool())
    val in4 = Input(Bool())
    val out1 = Output(UInt(2.W))

}