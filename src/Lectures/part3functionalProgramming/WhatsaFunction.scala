package Lectures.part3functionalProgramming

object WhatsaFunction extends App{
  // Use functions as first class elements

  val squared = new Function1[Int,Int]{
    override def apply(v1: Int): Int = v1*v1
  }
  println(squared(9))
  // Function1,2,3,4,....21  (The number indicates the number of arguments it can take
  // String to Int
  val stringToInt = new Function[String,Int] {
    override def apply(v1: String): Int = v1.toInt
  }
  println(stringToInt("5")+9)
  // ALL SCALA FUNCTION ARE OBJECTS

  // Excercise
  /*
    1.  a function which takes 2 strings and concatenates them
    2.  transform the MyPredicate and MyTransformer into function types
    3.  define a function which takes an int and returns another function which takes an int and returns an int
        - what's the type of this function
        - how to do it
   */
  val stringConcatenator = new Function2[String,String,String] {
    override def apply(v1: String, v2: String): String = v1+v2
  }
  println(stringConcatenator("The answer to the ultimate question was, ","42 : said the Deep Thoughts"))

  // Function that return a function
  // Curried Function
  val myWierdFunc: Int => Function1[Int,Int] = new Function1[Int,Function1[Int,Int]] {
    override def apply(x: Int): Function1[Int,Int] = new Function1[Int,Int]{
      override def apply(y: Int): Int = x+y}
  }
  println(myWierdFunc(9)(7))



}
