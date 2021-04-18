package Lectures.part2OOP

object Inheritance extends App{

  class vehicle{
    val carType = "Racing"
    def brand = println("BMW")
  }
  class Car extends vehicle{  // single class inheritance, only can be extended to one class
    def subBrand={
      brand               // methods from super class can be used directly
      println("Mercedes")
    }
  }
  class Bikes extends vehicle{
    def suBbrand: Unit = {
      super.brand
      println("Royal Enfield")
    }
  }
  val Bike = new Bikes
  println("Bike.brand = ")
  Bike.suBbrand
  val car = new Car
  println("Sub brand prints " )
  car.subBrand


  // constructors
  class Person(name:String,val age:Int){
    def this(name:String) = this(name,0) // reducing the
    def canAct_? : Boolean = false
    val home: String = "Anywhere in the world"
  }

  class Friends(name: String,agenew:Int, surName: String) extends Person("Rachel"){
    override def canAct_? : Boolean = true      // overriding a method in extended class
    override val age: Int = agenew
    override val home: String = "NewYork NewYork"
  }

  val Monica = new Friends("Monica",27,"Geller")
  println(Monica canAct_?)
  println((Monica.age))

  val Ross:Person = new Friends("Ross",30,"Geller")
  println(Ross canAct_?)   // eventhough the type of Ross is Person, but the canAct_? will be called the most recent
  println(Ross.home)
  println(Ross.home)

  // Overridding : changing the value or a method in an extended class
  // Super
  // How to prevent override

  // Final on member, final on entire class, the respective thing cannot be overridden or extended
  // Sealed class adn vals, can only be accessed in the main function





}
