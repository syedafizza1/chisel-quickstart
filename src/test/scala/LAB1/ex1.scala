package LAB1
import org.scalatest._
import chiseltest._
import chisel3._

class Countertest extends FreeSpec with ChiselScalatestTester {

  "lab1 (ex-1)" in {
    test(new counter(5.U)) { c => c.io.result.expect(0.B)
    }
  }
}