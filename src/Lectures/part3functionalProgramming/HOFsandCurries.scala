package Lectures.part3functionalProgramming

object HOFsandCurries extends App{
  // Higher order function: a Function that takes a function as parameter or returnsa function as result
  // Ex, Map,Flatmap,Filter
  // Try to apply f(f(f(x))) given, f, 3, x
  def nTimes(f: Int=>Int,n:Int,x:Int):Int ={
    if(n==1) f(x)
    else nTimes(f,n-1,f(x))
  }
  val square: Int=>Int = x=> x*x
  println(nTimes(square,3,2))
  // Try to make a nTimes function as a curry function
   def CurrynTimes(f :Int=>Int,n:Int): Int => Int ={
     if(n==1) (x:Int) => f(x)
     else (x:Int)=> CurrynTimes(f,n-1)(f(x))
   }
  println(CurrynTimes(square,2)(5))

  // functions with multiple parameters list // DID NOT UNDERSTAND CLEARLY WILL WAIT FOR NEXT LECTURE  ??
  //def multiParameterFunc(d:Double)(n:Int) : String = n +" " + d
  //val myMultiFunc:(Double =>String)= multiParameterFunc(10.3)
  //println(myMultiFunc(10.5))


  //Excercises
  /*
    1.  Expand MyList
        - foreach method A => Unit
          [1,2,3].foreach(x => println(x))

        - sort function ((A, A) => Int) => MyList
          [1,2,3].sort((x, y) => y - x) => [3,2,1]

        - zipWith (list, (A, A) => B) => MyList[B]
          [1,2,3].zipWith([4,5,6], x * y) => [1 * 4, 2 * 5, 3 * 6] = [4,10,18]

        - fold(start)(function) => a value
          [1,2,3].fold(0)(x + y) = 6

    2.  toCurry(f: (Int, Int) => Int) => (Int => Int => Int)
        fromCurry(f: (Int => Int => Int)) => (Int, Int) => Int

    3.  compose(f,g) => x => f(g(x))
        andThen(f,g) => x => g(f(x))
   */

  def toCurry(function: (Int,Int)=>Int): Int=>Int=>Int ={
    x=>y=>function(x,y)
  }
  def fromCurry(f: Int=>Int=>Int): (Int,Int)=>Int ={
    (x,y)=> f(x)(y)
  }
  def compose[A,B,K](f:A=>B,g :K=>A): K=> B =
    x=> f(g(x))
  def andThen[A,B,C](f:A=>B,g:B=>C): A=>C =
    x=> g(f(x))


  val myMultiplier: (Int,Int)=>Int = _*_
  val superAdder: Int=>Int=>Int = x=>y=>x+y
  val myToCurry = toCurry(myMultiplier)
  println(myToCurry(3)(4))
  val myFromCurry = fromCurry(superAdder)
  println(myFromCurry(3,5))
  val double:(Int=>Int)=  _*2
  val increment:(Int=>Int)= _+1
  val myCompose =compose(double,increment)
  val mYAndThen =andThen(double,increment)
  println(myCompose(5))
  println(mYAndThen(5))
}
