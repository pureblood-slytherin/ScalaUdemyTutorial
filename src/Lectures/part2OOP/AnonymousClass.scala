package Lectures.part2OOP

object AnonymousClass extends App{
  abstract class Human{
    def intro:Unit = println("Hi, I am a human")
  }
  val Abhijeet = new Human{// parameters should be passed if the original class has them
    override def intro: Unit = println(s"Hi, I am Abhijeet")
  }
  println(Abhijeet.getClass)// prints class Lectures.part2OOP.AnonymousClass$$anon$1
  /**
   * What compiler actually does is create a new class named AnonymousClass$$anon$1 and Abhijeet is a new instance of that
   */
  // This also works for a trait
  trait eating{
    def eat:Unit = println("I eat everything")
  }
  val VegEat = new eating{
    override def eat: Unit = println("I eat only veg")
  }
  VegEat.eat

}
