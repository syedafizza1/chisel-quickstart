package LAB1

import org.scalatest._
import chiseltest._
import chisel3._

class task2Tests extends FreeSpec with ChiselScalatestTester {

  "Task 2" in {
    test(new TASK2(8)) { c =>
      c.clock.step(1)
      c.io.reload.poke(0.B)
      c.io.out.expect(0.B)
    }
  }
}