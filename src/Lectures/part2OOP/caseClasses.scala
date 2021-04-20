package Lectures.part2OOP

object caseClasses extends App{

  // 1. Parameters are field
  case class City(name:String, area: Int)
  val Vizag = new City("Vizag",1000)
  println(Vizag.name)

  //2. Sensible .toString
  println(Vizag) // equivalent to Vizag.toString

  // 3. equals and hascode implemented
  val Visakhapatnam = new City("Vizag",1000)
  println(Vizag==Visakhapatnam)
  //4. Easy copy method

  val Kolkata = Vizag.copy("Kolkata")
  println(Kolkata)

  // 5. Default Companion objects
  val Delhi = City
  val Pune = City("Pune",1500)

  //6.  CCs are serializable "To be discussed later"
  // 7. CCs have extractor patterns = CCs can be used in PATTERN MATCHING "To be discussed later"
  //8. There are case objects also, with all the same features
}
