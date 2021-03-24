package LAB1
import org.scalatest._
import chiseltest._
import chisel3._

class countertest extends FreeSpec with ChiselScalatestTester {

  "LAB 1 EX-1" in {
    test(new counter(2.U)) { c =>
      c.clock.step(10)
      c.io.result.expect(0.B)
    }
  }
}