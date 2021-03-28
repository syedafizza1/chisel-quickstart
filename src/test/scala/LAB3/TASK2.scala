package LAB3

import org.scalatest._
import chiseltest._
import chisel3._

class ImmediateTests extends FreeSpec with ChiselScalatestTester {

  "lab3 task-2" in {
    test(new Immediate()) { c =>
      c.io.instr.poke("b11111111".U)
      c.io.pc.poke(1.U)
      c.io.immd_se.expect(1.U)
    }
  }
}