package Excercises

object ExceptionsExercise extends App{
  /*
    1.  Crash your program with an OutOfMemoryError
    2.  Crash with SOError
    3.  PocketCalculator
        - add(x,y)
        - subtract(x,y)
        - multiply(x,y)
        - divide(x,y)

        Throw
          - OverflowException if add(x,y) exceeds Int.MAX_VALUE
          - UnderflowException if subtract(x,y) exceeds Int.MIN_VALUE
          - MathCalculationException for division by 0
   */
  //OutOfMemoryException
  //val myInfiniteArray = Array.ofDim(Int.MaxValue)
  //println(100^100)
  //val myInt = math.pow(1000,10000)
  //println(myInt)

  // StackOverFlow
  /**def Factorial(n:Int):Int ={
    if(n==1)1
    else Factorial(n*n-1)
  }
  println(Factorial(100))**/
  //def n :Int=n+1
  //println(n)
  // Pocket CalC
  class OverflowException extends Exception{

  }
  class UnderflowException extends Exception{

  }
  class MathCalculationException extends Exception{

  }

  object pocketCalculator{
    def add(a:Int,b:Int):Int = {
      if((a>0 && b>0 && a+b<0)) throw new OverflowException
      if(a<0 && b<0 && a+b>0) throw new UnderflowException
      else a+b
    }
    def subtract(a:Int,b:Int):Int = {
      if(a<0 && b>0 && a-b >0) throw new UnderflowException
      if((a<0 && b>0 && a-b<0)) throw new OverflowException
      else a - b
    }
    def divide(a:Int,b:Int):Double = {
      if(b==0) throw new MathCalculationException
      else a / b
    }
    def multiply(a:Int,b:Int):Int = {
      if((a>0 && b>0 && a*b<0)) throw new OverflowException
      if(a<0 && b<0 && a*b>0) throw new UnderflowException
      if(a<0 && b>0 && a*b >0) throw new UnderflowException
      if(a>0 && b<0 && a*b >0) throw new UnderflowException
      else a * b
    }
  }
  //println(pocketCalculator.add(-2147483600,-45678903))
  //println(pocketCalculator.add(Int.MaxValue, 10))
  //println(pocketCalculator.divide(2, 0))


}
