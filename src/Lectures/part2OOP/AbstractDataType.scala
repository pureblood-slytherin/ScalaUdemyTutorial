package Lectures.part2OOP

object AbstractDataType extends App{
  //abstract
  abstract class Actor { // Abstract class cannot be instantiated
    val name : String
    def tvShow : String
    // val bestMovie : String
  }
  /**val Carelle = new Actor {
    override val name: String = "Steve Carelle"
    override def tvShow: Unit = println("The Office")

    override val bestMovie: String = "Crazy Stupid Love"
  }**/

    class Michael extends Actor{
    override val name: String = "Carelle"
    override def tvShow : String = "The office" // override word is not compulsory
    //override val bestMovie: String = s"$bestMov"
  }

  //val Krainiski = new goodActors("John Krainiski",156,"A quite place")
  //Krainiski tvShow

  // trait
  trait alsomovies{
    val movie:String
    def bestshow(actor:Michael): Unit
  }

 class Krasinski extends Michael with alsomovies {
    override val name: String = "John"
    override def tvShow : String = "The office season 9"
    override val movie: String = "The quite place"
    def bestshow(actor: Michael): Unit = println(s"I am ${actor.name} and I worked in ${actor.tvShow}")
  }

  val michael = new Michael
  val john = new Krasinski
  john bestshow john

  // Abstract class and traits both can have abstract and non abstract members
  // traits do not have constructor parameter
  // Multiple trait but only once class can be inherited
  // traits == behaviour, class is a type




}
