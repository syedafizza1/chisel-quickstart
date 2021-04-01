package LAB3
import org.scalatest._
import chiseltest._
import chisel3._

class RISCVALUTests extends FreeSpec with ChiselScalatestTester {

  "lab3 ex-2" in {
    test(new RISCVALU()) { c =>
      c.io.in_A.poke(10.U)
      c.io.in_B.poke(20.U)
      c.io.alu_Op.poke(4.U)
      c.clock.step(1)
      c.io.sum.expect(30.U)
      c.io.out.expect(30.U)
    }
  }
}   