package Lectures.part2OOP

import Excercises.{Cons => Mylist, emptyList}// Aliaces are used if we have to import more than one class of same name from different packages

object Packaging_Imports extends App{
  val myWriter = new Author("Agatha","Cristie",1851) // We can use any public class within the package

  val myCons = new Mylist(2,emptyList) // by importing the other package we can use its classes also
  // or we can use fully qualified name also, i.e. Excercises.Cons

  // packages are in hirerchy
  //matching folder structure

  // package object
  println(UltimateAnswer) // can be used just like that withing the whole package



}
