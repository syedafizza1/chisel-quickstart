package LAB3
import org.scalatest._
import chiseltest._
import chisel3._

class Encoder4to2Tests extends FreeSpec with ChiselScalatestTester {

  "lab3 ex-1" in {
    test(new Encoder4to2()) { c =>
      c.io.in1.poke(0.B)
      c.io.in2.poke(0.B)
      c.io.in3.poke(1.B)
      c.io.in4.poke(0.B)
      c.io.out.expect(1.U)
    }
  }
}

// 0001 -> 00 -> 1
// 0010 -> 01 -> 2
//0100 -> 10 -> 4
// 1000 -> 11 ->8