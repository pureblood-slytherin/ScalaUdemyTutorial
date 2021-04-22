package Lectures.part3functionalProgramming

object Options extends App{
  // Why options? To catch the exceptions, to avoid unnnesarry codes
  def unSafeMethod() :String =null
  // val result = None(unSafeMethod()) : WRONG, Never use that never manually check None/Some let the Option do it
  val result = Option(unSafeMethod())
  println(result)
  // Chained Method
  // Priority 1 method is unsafe, Priority 2 is backup
  def backUpMethod():String ="It works"
  val chainedResult = Option(unSafeMethod()).orElse(Option(backUpMethod()))
  // A better way of doing it is to define your APIs with options

  def myUnsafeMethod(): Option[String] = None
  def myBackupMethod() :Option[String]=Some("This one works")
  val myCHainedResult = myUnsafeMethod().orElse(myBackupMethod())


}
