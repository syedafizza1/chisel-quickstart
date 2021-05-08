package LAB4

import chisel3 . _
import chisel3 . util._
import org.scalatest._
import chiseltest._
import scala . util . Random

class task1Tests extends FreeSpec with ChiselScalatestTester {

  "Lab 4 Task 1" in {
    test(new task1()) { c =>
      val array_funct3 = Array(0,1,4,6,5,7)
      for ( i <- 0 until 100) {
            val a = Random . nextLong () & 0xFFFFFFFFL
            val b = Random . nextLong () & 0xFFFFFFFFL
            val branch = Random.nextBoolean()
            val ff = Random . nextInt (6)
            val funct3 = array_funct3(ff)
            val result = funct3 match {
              case 0 => if (a == b) 1 else 0
              case 1 => if (a != b) 1 else 0
              case 4 => if (a < b) 1 else 0
              case 6 => if (a < b) 1 else 0
              case 5 => if (a >= b) 1 else 0
              case 7 => if (a >= b) 1 else 0
              case _ => 0
            }

        c.io.arg_x.poke(a.U)
        c.io.arg_y.poke(b.U)
        c.io.fnct3.poke(funct3.U)
        c.io.branch.poke(branch.B)
        c.clock.step(1)
        if (branch) c.io.br_taken.expect(result.B)
        else c.io.br_taken.expect(0.B)

        println("FUNC3 = ",funct3)
        println("a = ",a)
        println("b = ",b)
        println("BRANCH = ",branch)
        println("THE FINAL RESULT IS = ",result)
        

      }
    }
  }
}

