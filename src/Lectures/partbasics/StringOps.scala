package Lectures.partbasics

object StringOps extends App{
  val myString = "Welcome to Hogwarts"

  println(myString.charAt(3))
  println(myString.split(" ") .toList)
  println(myString.substring(4,7))
  println(myString.startsWith("Welc"))
  println((myString.replace("Hogwarts","Drumstrang")))
  println(myString.length)
  println(myString.toLowerCase())

  val myNumberstring = "45"
  val aNumber = myNumberstring.toInt
  println(5+aNumber)
  println(myNumberstring.reverse)
  println(myString.take(7))

  // s interpolation: already covered
  def myFunc(a:Int, name : String):String = s"my name is $name and I am $a years old"
  println(myFunc(23, "Abhijeet"))

  // F-Interpolators
  def BMI(height:Double,weight:Double)= weight/height
  val myBMI =BMI(1.7,65)
  println(s"My BMI is $myBMI")
  println(f"My BMI is = $myBMI%2.20f")
  //Raw interpolators
  println("my Name is \n abhi")
  println(raw"my Name is \n abhi")
}

