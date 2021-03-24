package LAB1
import org.scalatest._
import chiseltest._
import chisel3._

class counter3test extends FreeSpec with ChiselScalatestTester {

  "LAB 1 ex-3" in {
    test(new counter3(2,40))
    }
}
