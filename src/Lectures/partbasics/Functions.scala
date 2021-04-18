package Lectures.partbasics

object Functions extends App{
  def myFirstFunction(a: String, b:Int)= a+ " " +b
  println(myFirstFunction("Abhijeet",23))

  // Recursive Function
  def myRecursiveFunction(aString: String,n:Int) : String ={
    if (n==1) aString
    else myRecursiveFunction(aString,n-1)+" "+ aString
  }
  println(myRecursiveFunction("Harry",5))

  // IF LOOPS COMES IN MIND CHOOSE RECURSION
  // AS A GOOD PRACTICE USE TYPE IN RECURSIVE FUNCTION

  //Auxiliary function
  def bigFunction(n:Int): Int ={
    def smallFunction(a:Int,b:Int)=a+b //Defining a function inside a function and then using it
    smallFunction(n,n-1)
  }
  println(bigFunction(7))  // 7+(7-1)

  // Tasks
  def GreetingFunction(name:String,age:Int):String = s"My name is $name & I'm $age years old"
  println(GreetingFunction("Harry",11))
  // Factorial Function
  def Factorial(n:Int):Long= {
    if(n==1) 1
    else Factorial(n-1)*n
  }
  println("Factorial of 10 = "+ Factorial(10))
  // Fibonacci
  def printFibonacci(n:Int): Int= {
    if(n<=2) 1
    else (printFibonacci(n-1)+printFibonacci(n-2))
  }
  println(printFibonacci(8))
  //Test if prime
  def isPrimeFunction(n:Int):Boolean={
    def checktillOne(a:Int): Boolean={
      if(a==1) true
      else n%a!=0 && checktillOne(a-1)
    }
    checktillOne(n/2)
  }
  println(isPrimeFunction(2))
  println(isPrimeFunction(38973))
  println(isPrimeFunction(43))
}
