package Lectures.part3functionalProgramming

object MapFlatMapFilterFor extends App{

  val list =List(1,2,3,4,5)
  val doubleList = list.map(_*2)
  val evenList = list.filter(_%2==0)
  val pairSquares =list.flatMap(x=> List(x,x*x))
  println(doubleList)
  println(evenList)
  println(pairSquares)
  list.foreach(println)
  val chars =List('a','e','i')
  val colors =List("Green","Blue")
  // 2 Loops
  val combination = list.flatMap((x=>chars.map(y=>""+x+y)))
  // 3 Loops
  val superCombination = list.flatMap(x=>chars.flatMap(char=>colors.map(color=> ""+x+char+color)))
  println(combination)
  println(superCombination)

  // For-Yield
  val superCombination1 = for{
    n <- list if(n%2==0)
    c <-chars
    colo <- colors
  } yield ""+n+c+colo
  println(superCombination1)

  for{
    colo <- colors
  } yield println(colo)



}
