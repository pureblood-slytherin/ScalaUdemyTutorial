package Lectures.partbasics

import scala.annotation.tailrec
import scala.math.sqrt

object Reccursion extends App{
  def factorial(n:Int):BigInt={
    if(n<=1) 1
    else factorial(n-1)*n
  }
  //println(factorial(100000))

  // Tail Recursive
  def advanceFactorial(n:Int): BigInt ={
    @tailrec
  def multiplier(a:Int,multi:BigInt):BigInt={
    if(a<=1) multi
    else multiplier(a-1,a*multi)
  }
    multiplier(n,1)
  }
  //println(advanceFactorial(100)) // Can run even 100000! :O
  //@tailrec for checking a tail recursion
  // When we need loop, use tail recursion
  // Task
  // 1. Tail recursive string concatenate, fibbonaci and isPrime
  // Tail Recursive String Concatenate
  def TailRecursiveStringConcatenate(aString :String, n: Int): String = {
    @tailrec
    def bigStringMake(a :Int,givenString : String,bigString: String):String={
      if(a<1) bigString
      else bigStringMake(a-1,givenString,givenString+bigString)
    }
    bigStringMake(n,aString,"")
  }
  println(TailRecursiveStringConcatenate("Harry",5))



  // Tail Recursive Fibonacci

  def TailRecursiveFibonacci(n:Int): Int ={
    @tailrec
    def keepSum(incremental:Int,a :Int, sum:Int): Int ={
      if(incremental==n-1) sum
      else keepSum(incremental+1,sum,sum+a)
    }
    keepSum(0,0,1)
  }

  println(TailRecursiveFibonacci(8)) // 1 1 2 3 5 8 13 21 44

  // Tail Recursive isPrime
  def TailRecursiveisPrime(n:Int):Boolean={
    @tailrec
    def checkandEnd(divisor: Int, acumulator:Boolean): Boolean={
      if(n <= 1) true
      else if (divisor ==1) acumulator
      else checkandEnd(divisor-1,n%divisor!=0 && acumulator)
    }
    checkandEnd(n/2,true)
  }
  println(TailRecursiveisPrime(1029))

}
