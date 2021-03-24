package LAB2

import org.scalatest._
import chiseltest._
import chisel3._

class ex3Tests extends FreeSpec with ChiselScalatestTester {

  "Exercise 3 Lab 2" in {
    test(new ex3()) { c =>
      c.io.in1.poke(0.B)
      c.io.in2.poke(1.B)
      c.io.in3.poke(0.B)
      c.io.in4.poke(0.B)
      c.io.out1.expect(0.U)
    }
  }
}