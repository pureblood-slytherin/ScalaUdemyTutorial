package Lectures.part3functionalProgramming

object TuplesAndMaps extends App{
  val myTuple = new Tuple2(2,"Kid") // Type: (Int,String)
  val myTuple2 = Tuple2(3,"Kid")
  val myTuple3 = (4,"Kid")

  println(myTuple._2)
  println(myTuple.swap)
  println(myTuple.copy(_1 =18, _2 = "Adult"))

  // Maps
  val rollno = Map(("Abhijeet",1),"Abhinav"->2,"Adarsh"->3,"Alok"->4).withDefaultValue("No such Person") // To avoid the exception, add default value
  println(rollno("Abhijeet"))
  println(rollno.contains("Alok"))
  println(rollno("Anshul"))
  val newStudent = "Anshul"->5
  val updatedRollNo = rollno+ newStudent
  println(updatedRollNo)
  //Functions on Map
  val trueRolls = updatedRollNo.map(pair => pair._1 -> ("15CH1000"+ pair._2))
  println(trueRolls)
  //println(updatedRollNo.filterKeys(x => x.endsWith("h")))
  //println(updatedRollNo.mapValues())

  //Conversion of collection
  println(trueRolls.toList)
  val aList = List("John",4)
  println(List(("John",4)).toMap)
  //groupby
  val Names = List("Harry","Hermoine","Ron","Nevelle","Luna","Ginny","Fred","George","Romilda")
  println(Names.groupBy(x=> x.charAt(0)))
  //println(trueRolls.groupBy(pair=>pair._1.length))


  /*
    1.  What would happen if I had two original entries "Jim" -> 555 and "JIM" -> 900

        !!! careful with mapping keys.

    2.  Overly simplified social network based on maps
        Person = String
        - add a person to the network
        - remove
        - friend (mutual)
        - unfriend

        - number of friends of a person
        - person with most friends
        - how many people have NO friends
        - if there is a social connection between two people (direct or not)
   */

  //1.
  val exercise1 = Map(("Jim",998),"JIM"->867)
  println(exercise1)
  println(exercise1("JIM"))
  //2. SOCIAL NETWORK

  def add(Network: Map[String,Set[String]],person:String): Map[String,Set[String]] =
    Network+ (person->Set())
  def friend(Network: Map[String,Set[String]],person1: String,person2:String):Map[String,Set[String]]= {
    val updatedlist1 = Network(person1) + person2
    val updatedlist2 = Network(person2) + person1
    Network + (person1->updatedlist1) + (person2->updatedlist2)
  }
  def unfriend(Network: Map[String,Set[String]],person1: String,person2:String):Map[String,Set[String]]={
    val updatedlist1 = Network(person1)
    val updatedlist2 = Network(person2)
    Network + (person1->(updatedlist1-person2)) + (person2->(updatedlist2-person1))
  }
  def remove(Network: Map[String,Set[String]],person:String): Map[String,Set[String]] ={
    // first unfriend that person from everyone
    def unfriendremoved(removedpersonlist: Set[String],NetworkAcc: Map[String,Set[String]]):Map[String,Set[String]]={
      if(removedpersonlist.isEmpty) NetworkAcc
      else unfriendremoved(removedpersonlist.tail,unfriend(NetworkAcc,person,removedpersonlist.head))
    }
    val newNetwork = unfriendremoved(Network(person),Network)
    newNetwork - person
  }

  def noOfFriend(network: Map[String,Set[String]], person :String):Int = {
    if(!network.contains(person)) 0
    network(person).size
  }

  def mostFriend(network: Map[String,Set[String]]):String={
    network.maxBy(pair=>pair._2.size)._1
  }

  def noFriendPeople(network: Map[String,Set[String]]):Int={
    network.filterKeys(pair=> network(pair).isEmpty).size
  }
  // To be thought with a fresh mind: Social COnnection
  // def

  val empty:Map[String,Set[String]]=Map()
  val myFacebook1 = add(add(add(add(add(add(empty,"Harry"),"Hermoine"),"Ron"),"Draco"),"Pansy"),"Sirius")
  // Build Friendship
  val myFacebook2 = friend(myFacebook1,"Harry","Hermoine")
  val myFacebook3 = friend(myFacebook2,"Harry","Ron")
  val myFacebook4 = friend(myFacebook3,"Ron","Hermoine")
  val myFacebook5 = friend(myFacebook4,"Harry","Sirius")
  val myFacebook6 = friend(myFacebook5,"Draco","Sirius")
  val myFacebook7 = friend(myFacebook6,"Draco","Pansy")
  println(myFacebook7)
  println(unfriend(myFacebook7,"Sirius","Draco"))
  println(remove(myFacebook7,"Sirius"))

  println(noOfFriend(myFacebook7,"Harry"))








}
