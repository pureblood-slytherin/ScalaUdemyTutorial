package Lectures.part4Patternmatch

import Excercises.{Cons, emptyList, myList}

object AllThePatterns extends App{
  // Lets list all the different kind of patterns
  //1. Constant
  val myConstant:Any = 67
  val myConstantMatch = myConstant match {
    case 67 => "Sixty seven"
    case "Sixty seven" => 67
    case true => "It is a number"
    case _=> "Nothing"
  }
  // 2. Match anything Default value
  val myDefaultValue = myConstant match {
    case _=> "This ssignifies default value"
  }

  //2.2 Utilising the variable
  val myName = "Harry"
  val myVariablematch = myName match {
    case name => s"His name is $name"
    case _=> "You know who!"
  }
  //3. Tuples
  val house = ("Harry","Gryffindor")
  val tuplematch = house match {
    case (_,house)=> s"$house people are the worst"
    case _=> "Slytherin is best!"
  }
  println(tuplematch)
  // Nested Tuples
  val house_Age = ("Harry",("Gryffindor",11))
  val nestedTuple = house_Age match {
    case (_,(_,age))=> s"One joins Hogwarts when they are $age"
    case _=> "Nothing"
  }
  println(nestedTuple)

  // 4. Case classes- constructor patter and PMs can be nested with CCs as well
  val mylist: myList[Int]= Cons(3,Cons(4,emptyList))
  val matchCase = mylist match {
    case Cons(_,Cons(head,_)) => s"Head of the tails is $head"
    case emptyList => "Empty List"
  }
  println(matchCase)

  //5. List Patterns
  val listNumbers = List(2,3,4,5)
  val listPattern = listNumbers match {
    case List(_,2,_,_) => "List with 2 at index 1"
    case List(2,_*) => "list that starts with 2 and arbitrary length"
    case 1 :: List(_) => "List starts with 1 "// infix pattern
    case List(_*) :+ 5 => "List ends with 5" // Infix pattern
  }
// 6. Type specifiers
  val unknown: Any = 2
  val unknownMatch = unknown match {
    case list: List[Int] => // explicit type specifier
    case _ => "Type doesn't match"
  }
  // 7. Name binders
  val nameBinderMatch = mylist match {
    case NameOfmyList @ Cons(_,_) => "Now we can use this name here"
    case Cons(_,tailedlist @ Cons(_,_)) => "We have named the tail"
  }

  //8. Multi patterns: OR in PM
  val multipatter = listNumbers match{
    case List(3,_*) | List(_,3,_*) => "It will check both the patterns it acts as OR"
    case _=> "Some default value for list"
  }
  println(multipatter)

  //9. If gaurd : AND in PM
  val ifGaurd = listNumbers match{
    case List(_,3,_*) if true => "It will check both the patterns and acts as AND"
    case _=> "Some default value for list"
  }
  println(ifGaurd)

  // Point to remember ****


  val numbers = List(1,2,3)
  val numbersMatch = numbers match {
    case listOfStrings: List[String] => "a list of strings"
    case listOfNumbers: List[Int] => "a list of numbers"
    case _ => ""
  }

  println(numbersMatch)
  // JVM will erase the abstract type after reading




}
