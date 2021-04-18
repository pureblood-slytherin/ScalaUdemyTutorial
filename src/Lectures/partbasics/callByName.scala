package Lectures.partbasics

object callByName extends App{

  def callbyValue(n:Long)={
    println("call by value " + n)
    println("call by value " + n)
  }
  def callbyName(n: =>Long) ={
    println("call by Name "+ n)
    println("call by Name "+ n)
  }
  println(callbyValue(System.nanoTime()))
  println(callbyName(System.nanoTime()))

  def infinity():Int  = infinity()+1
  def printFirst(n:Int,m: =>Int) = println(n) // if we call m by value than it will crash StackOverflow
  printFirst(2,infinity())
  // Call by value, first value is calculated and then used
  // Call by name, it is taken as it is and then evaluated every time when used

}
