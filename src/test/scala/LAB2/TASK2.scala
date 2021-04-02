package LAB2

import org.scalatest._
import chiseltest._
import chisel3._

class task2Tests extends FreeSpec with ChiselScalatestTester {

  "Task2 Lab 2" in {
    test(new task2()) { c =>
    c.io.in(0).poke(1.B)
    c.io.in(1).poke(0.B)
    c.io.in(2).poke(1.B)
    c.io.in(3).poke(0.B)
    c.io.sel(0).poke(0.B)
    c.io.sel(0).poke(0.B)
      c.clock.step(1)
    c.io.out(0).expect(0.B)
    }
  }
}