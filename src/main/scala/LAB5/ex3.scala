package LAB5

import chisel3._
import chisel3.util._

class ex3 [ T <: Data ]( n : Int , generic : T ) ( op : (T , T ) => T ) extends Module {
    require ( n > 0) // " reduce only wrok on Vectors that arent empty"
    val io = IO (new Bundle {
        val in = Input ( Vec (n , generic ) )
        val out = Output ( Vec(n, generic ))
    })

    for (i <- 0 until n){
        io.out(i) := io.in.reduce(op)
    }

}
