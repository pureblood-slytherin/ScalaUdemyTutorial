package Lectures.part2OOP

object Objects {

  // SCALA does not have CLASS level Functionality
  class Car(val brand: String) { // Regular instance
    val color = "Pink"

  }

  // println(Car.color) does not work
  object Car { // Object and class Car are called Companions // Singleton instance
    // "Static" class  level functionality
    val color = "Pink"

    //factory method
    def apply(name: String): Car = new Car(name)
  }

  def main(args: Array[String]): Unit = { // inplace of extends App, the main method where applications are
    // The whole code will be either in object or in class
    println(Car.color) // This works
    // Object is a singleton object, its only instance of its type
    val Honda = Car
    val Maruti = Car
    println(Honda == Maruti) // It is true because both Honda and Maruti points to a same singleton object
    val Mercedez = new Car("Class S")
    val BMW = new Car("Z5")
    println(Mercedez == BMW)
    val newCar = Car("Mahindra")
    println(newCar.brand)
  }
}


