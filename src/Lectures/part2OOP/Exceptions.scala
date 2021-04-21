package Lectures.part2OOP


object Exceptions extends App{
  val myString:String = null
  // myString.length This will throw a NullPointExceptions
  //1. How to throw an exception

  lazy val myException = throw new NullPointerException  // This will also throw a NPE if we remove "lazy"
  // we are actually creating an instance of a throwable class
  // Exception and Error are the major Throwable Subtype

  //2. Catch an Exception
  def exceptionGenerate(n:Boolean):String={
    if(n) throw new RuntimeException("Lets throw RTE")
    else "42"
  }

  val myExpression = try {
  //Code that can throw an exception
    exceptionGenerate(true)
  }catch {
    case e:RuntimeException => "We have catched a RTE"
  }finally {
    // This CodeBlock will run no matter what
    // This codeblock does not influence try: Return Type
    // Should be used only for side effects
    println("This will always be printed")
  }
  println(myExpression)
  // How to define our own exceptions
  class myExceptions extends Exception
  val exception = new myExceptions
  throw exception


}
