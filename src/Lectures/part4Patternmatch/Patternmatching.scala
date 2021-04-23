package Lectures.part4Patternmatch

import scala.util.Random

object Patternmatching extends App{

  /*
    1. cases are matched in order
    2. what if no cases match? MatchError
    3. type of the PM expressoion? unified type of all the types in all the cases
    4. PM works really well with case classes*

   */

  val random = new Random()
  val x = random.nextInt(10)
  val myCase = x match {
    case 1 => "Philosophers Stone"
    case 2 => "Chamber of secrets"
    case 3 => "Prisoner of Azkaban"
    case _=> "Rest other movies were shit, read the books"
  }
  println(x)
  println(myCase)

  // Decompose value
  case class Person(name:String,age:Int)
  val Jim = Person("Jim",43)
   val matchPerson = Jim match {
     case Person(name,age) if age > 40 => s"His name is $name and he is old"
     case Person(name,age)=> s"His name is $name and he is $age"
     case _=> "He's some other person"
   }
  println(matchPerson)

  // Pattern macthing for sealed classes

  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Terra Nova")
  animal match {
    case Dog(someBreed) => println(s"Matched a dog of the $someBreed breed")
  }
  // DONOT use MATCH FOR TRUE and FALSE KIND OF RESULTS, stick to the basics

  //1. Excercise
  trait Expres
  case class Number(E: Int) extends Expres
  case class Sum( E1: Expres,E2: Expres) extends Expres
  case class Product( E1: Expres,E2: Expres) extends Expres

  def show(e: Expres):String= e match{
    case Number(num) => s"$num"
    case Sum(e1, e2) => show(e1) + " + " + show(e2)
    case Product(e1,e2)=> {
      def showParenthesis(ex :Expres)= ex match{
        case Product(_,_) => show(ex)
        case Number(_) => show(ex)
        case _ => " ( " + show(ex) + " ) "
      }
      showParenthesis(e1) +" * "+ showParenthesis(e2)
    }
  }
  println(show(Sum(Number(2),Number(5))))
  val myExpress = Sum(Number(2),Number(5))
  val modifidExpres = Product(myExpress,Number(7))
  println(show(modifidExpres))
  println(show(Sum(modifidExpres,Sum(Number(1),Number(5)))))




}
