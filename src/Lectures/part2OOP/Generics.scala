package Lectures.part2OOP

object Generics extends App{
  class myList[+A]{
    def add[B >:A](element:B): myList[B]  = ???  // If covariant class, we add two different subclasses of a super class turn the type to its superclss
  }
  val myIntList = new myList[Int]
  val myStringList = new myList[String]

  // traits can be type parameterised
  // objects can't be type parameterised
  object myList{
    def empty[A]:myList[A]= ???
  }
  val listofInt = myList.empty[Int]
  println(listofInt)
  // VARIANCE
  class Animal
  class Cat extends Animal
  class Dog extends Animal
  // The ultimate question: Can List[Cat] extends to List[Animal]
  // 1. If Yes: ""It is called COVARIANCE"
  class covarincelist[+A]
  val covariantanimal: covarincelist[Animal] = new covarincelist[Cat]
  // AnimalList.add(Dog):  Think??
  // 2. If No: It is called INVARIANCE
  class invariancelist[A]
  val invariantAnimal: invariancelist[Cat] = new invariancelist[Cat]
  //3. Absolutely No: It is called CONTRAVARIANCE
  class contravariance[-A]
  val contravariantAnimal:contravariance[Cat]= new contravariance[Animal]
  //trainer for making sense
  class trainer[-A]
  val AnimalTrainer:trainer[Cat]=new trainer[Animal]

  // bounded types
  class cage[A <: Animal](animal:A) // It means that it can only types that are subtype (<:) of Animals
  val SteelCage= new cage(new Cat)

}
