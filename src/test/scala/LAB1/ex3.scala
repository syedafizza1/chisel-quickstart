package LAB1
import org.scalatest._
import chiseltest._
import chisel3._

class counter3test extends FreeSpec with ChiselScalatestTester {

  "LAB 1 EX-3" in {
    test(new counter3(8,255)) { c =>
      c.clock.step(1)
    }
  }
}
