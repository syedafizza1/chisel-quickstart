package LAB1
import org.scalatest._
import chiseltest._
import chisel3._

class addrtest extends FreeSpec with ChiselScalatestTester{
    "hello kya haal hen" in {
        test(new addr) {c=>
        c.io.a.poke(1.U)
        c.io.b.poke(1.U)
        c.io.c.expect(2.U)}
    }
}