package Lectures.part3functionalProgramming

object AnonymousFunction extends App {

  val squared: Function1[Int,Int] = new Function1[Int,Int] {
    override def apply(v1: Int): Int = v1*v1
  }
  // Anonymous Function (Lambda)
  val squared1 = (x:Int) => x*x
  println(squared1(8))
  val squared2: Int=>Int = x => x*x
  println(squared2(8))
  // multi parameters
  val adder:(Int,Int)=>Int = (z:Int,y:Int)=>z+y

  // No parameters
  val printing =() => "Did nothing"
  println(printing)
  println(printing()) // Use paranthesis for calling a lambda function with no parameters

  // curly brakets
  val ToString: Int=>String = { x => // sometimes preffered
    x.toString
  }
  // More syntactic sugar
  val doubler:Int=>Int = _*2 // _ is equivalent to x=>x
  val easyadder:(Int,Int) =>Int = _+_
  println(easyadder(9,6))

  // Rewrite the wierdfunction
  // Curried function
  val superadd = (x:Int) => (y:Int)=> x+y
println(superadd(3)(8))


}
