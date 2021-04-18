package Lectures.partbasics

object VariableTypes extends App{
  // val are immutable
  var myFirstNumber = 34 // No need for type value
  // different types of val
  val myString= "Hurray"
  val myDouble= 0.345
  val myFloat = 0.5567f
  val myLong= 456777894948L
  val myChar = 'c' // Single quotes for char
  val myBoolean = false

  // variables var || Side effects
  var myFirstVariable: Int = 45
  myFirstVariable = 56

}
