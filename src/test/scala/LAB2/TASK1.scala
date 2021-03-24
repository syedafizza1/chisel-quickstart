package LAB2

import org.scalatest._
import chiseltest._
import chisel3._

class task1Tests extends FreeSpec with ChiselScalatestTester {

  "Exercise 3 Lab 2" in {
    test(new task1()) { c =>
      c.io.s0.poke(1.B)
      c.io.s1.poke(0.B)
      c.io.s2.poke(0.B)
      c.clock.step(1)
      c.io.out.expect(8.U)
    }
  }
}