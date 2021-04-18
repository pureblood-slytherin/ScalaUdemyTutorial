package Lectures.partbasics

object Expressions extends App{
  // mathematical operations follow BODMAS
  //everything in SCALA is an expression
  // an expression is something that has a value
  val myInt = 1+2+4
  val myValue = println(myInt) // println method also is an expression that returns ()
  print(myValue)


  // side effects: println(), while, reassigning
  var myVariable =2
  myVariable+=3
  println("myVariable = "+ myVariable)

  // In Scala we have EXPRESSIONS( Values) other language we have INSTRUCTIONS (Do)
  val myFirstCodeBlock ={
    val x = 1
    val y = 3
    if(x==y) "Equal" else "Unequal"  // The CodeBlock type will be string , here if() is also returning an expression
  }
  // x & y are only defined inside codeBlock
  println(1==myInt) // 1==myInt is also an expression
  println(if (2==3) 4 else 5)

  // CRIME IN SCALA " Using Loops"
  var i=0
  while(i<5){
    println(i)
    i+=1
  }
  // First and last time




}
