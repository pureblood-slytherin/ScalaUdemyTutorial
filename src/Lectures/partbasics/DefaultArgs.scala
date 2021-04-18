package Lectures.partbasics

object DefaultArgs extends App{
  def Factorial(n:Int,acumulator:Int =1):Int ={
    if(n<= 1) acumulator
    else (Factorial(n-1,n*acumulator))
  }
  //println(Factorial(5,1)) // but it doesn't look good, so we can give 1st time default value in the function
  println(Factorial(10))

  def BMICalculator(name: String = "Abhijeet", height:Double =1.6, weight:Double): Double = weight/height
  println(BMICalculator(weight=65))

}
