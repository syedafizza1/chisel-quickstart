package LAB1
import chisel3._

class addr extends Module {
    val io=IO(new Bundle {
        val a=Input(UInt(2.W))
        val b=Input(UInt(2.W))
        val c=Output(UInt(2.W))
    })

    io.c:=io.a+io.b
} 
