package LAB3

import org.scalatest._
import chiseltest._
import chisel3._

class branchingTests extends FreeSpec with ChiselScalatestTester {

  "lab3 task-1" in {
    test(new branching()) { c =>
      c.io.arg_x.poke(20.U)
      c.io.arg_y.poke(20.U)
      c.io.fnct3.poke("b000".U)
      c.io.branch.poke(1.B)
      c.io.br_taken.expect(1.B)
    }
  }
}