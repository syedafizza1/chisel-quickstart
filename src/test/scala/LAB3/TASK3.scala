package LAB3
import org.scalatest._
import chiseltest._
import chisel3._

class valid_interfaceTests extends FreeSpec with ChiselScalatestTester {

  "lab3 task-3" in {

    test(new valid_interface()) { c =>
        c.io.in.poke("b10".U)
        c.clock.step(10)
        c.io.out.valid.expect(1.B)
        c.io.out.bits.expect("b0100".U)
    }
  }
}