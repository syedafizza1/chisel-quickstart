package LAB1
import org.scalatest._
import chiseltest._
import chisel3._

class countingtest  extends FreeSpec with ChiselScalatestTester {

  "LAB 1 EX-2" in {
    test(new counting (5.U)) { c =>
      c.clock.step(50)
      c.io.result.expect(0.B)

    }
  }
}