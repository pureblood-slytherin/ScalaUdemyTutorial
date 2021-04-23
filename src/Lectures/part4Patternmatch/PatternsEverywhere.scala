package Lectures.part4Patternmatch

object PatternsEverywhere extends App{

  // 1. catches are also a type of MATCH
  try {
    // some code
  } catch {
    case e: RuntimeException => "runtime"
    case npe: NullPointerException => "npe"
    case _ => "something else"
  }

  // what it actually does is
  /**
   * try{ code
   * } cathc erroor{
   * error match {
   * case error : RTE
   * case error : NPE etc etc
   * }
   *}

   * */

  // Multiple value definations
  val myTuple = ("Harry", "Ron","Hermoine")
  val (a,b,c) = myTuple
  println(c)

  val numList =List(3,4,5,6,7,7)
  val head :: tail = numList
  println(tail)

  // generators are also based on PATTERN MATCHING  :  Did not under stood
  // Will think with a fresh mind





  // partial function based on PATTERN MATCHING
  val mappedlist = numList.map{
    case v if v%2==0 => "Even number"
    case v if v%2!=0 => "Odd Number"
    case _=> "Non integer"
  }
  print(mappedlist)
  println("\n")

  // what actually compiler does is map(x=> x match { case 1 => ......}
  val mappedList2 = numList.map { x => x match {
    case v if v%2==0 => "Even number"
    case v if v%2!=0 => "Odd Number"
    case _=> "Non integer"
  }
  }
  println(mappedList2)

}
