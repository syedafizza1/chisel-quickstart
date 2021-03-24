package LAB1
import org.scalatest._
import chiseltest._
import chisel3._
class countingtest extends FreeSpec with ChiselScalatestTester {

  "LAB1 ex-2" in {
    test(new counting(1.U))
    
  }
}