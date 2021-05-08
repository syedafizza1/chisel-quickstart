package lab8

import chisel3 . _
import chisel3 . util . _


class TASK1 extends Module {
    val width : Int = 8
    val io = IO (new Bundle {
        val memory_out = Vec (4 , Output ( UInt (32. W ) ) )
        val requestor = Vec (4 , Flipped ( Decoupled ( UInt (32. W ) ) ) )
        val Readaddr = Input ( UInt (5. W ) )
        val Writeaddr = Input ( UInt (5. W ) )
    })
    val mem = SyncReadMem(1024,Vec(4,UInt(width.W)))
    val arbiter = Module(new Arbiter(UInt(), 4))
    
    val queue0 = Queue(io.requestor(0))
    val queue1 = Queue(io.requestor(1))
    val queue2 = Queue(io.requestor(2))
    val queue3 = Queue(io.requestor(3))

    arbiter.io.in(0) <> queue0
    arbiter.io.in(1) <> queue1
    arbiter.io.in(2) <> queue2
    arbiter.io.in(3) <> queue3


    arbiter.io.out.ready := 1.B
    when(io.requestor(0).valid === true.B){
        val vv = Reg(Vec(4, UInt()))
        vv(0) := arbiter.io.out.bits
        vv(1) := 0.U
        vv(2) := 0.U
        vv(3) := 0.U
        mem.write(io.Writeaddr, vv)
    }.elsewhen(io.requestor(1).valid === true.B){
        val vv = Reg(Vec(4, UInt()))
        vv(0) := 0.U
        vv(1) := arbiter.io.out.bits
        vv(2) := 0.U
        vv(3) := 0.U
        mem.write(io.Writeaddr, vv)
    }.elsewhen(io.requestor(2).valid === true.B){
        val vv = Reg(Vec(4, UInt()))
        vv(0) := 0.U
        vv(1) := 0.U
        vv(2) := arbiter.io.out.bits
        vv(3) := 0.U
        mem.write(io.Writeaddr, vv)
    }.elsewhen(io.requestor(3).valid === true.B){
        val vv = Reg(Vec(4, UInt()))
        vv(0) := 0.U
        vv(1) := 0.U
        vv(2) := 0.U
        vv(3) := arbiter.io.out.bits
        mem.write(io.Writeaddr, vv)
    }
    io.memory_out := mem.read(io.Readaddr)

}