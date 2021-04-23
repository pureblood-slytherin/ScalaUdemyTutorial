package Lectures.part3functionalProgramming

import scala.util.Random

object Options extends App{
  // Why options? To catch the exceptions, to avoid unnnesarry codes
  def unSafeMethod() :String =null
  // val result = None(unSafeMethod()) : WRONG, Never use that never manually check None/Some let the Option do it
  val result = Option(unSafeMethod())
  //println(result)
  // Chained Method
  // Priority 1 method is unsafe, Priority 2 is backup
  def backUpMethod():String ="It works"
  val chainedResult = Option(unSafeMethod()).orElse(Option(backUpMethod()))
  // A better way of doing it is to define your APIs with options

  def myUnsafeMethod(): Option[String] = None
  def myBackupMethod() :Option[String]=Some("This one works")
  val myCHainedResult = myUnsafeMethod().orElse(myBackupMethod())

  // Connection Assignment


  val Config: Map[String, String] =Map(
    "Host"-> "123.54.20.90",
    "Port"->"8080"
  )
  class Connection {
    def connect = "Connected"
  }
  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] =
       Some(new Connection)
  }
  /**
  object Connection{
    val myRandom = new Random(System.nanoTime())
    def apply(host:String,port:String): Option[Connection] ={
      if(myRandom.nextBoolean()) Some(new Connection)
      else None
    }
  }**/

  val ConnectionBuild = Config.get("Host").flatMap(x => Config.get("Port").flatMap(y => Connection(x,y)))
  val ConnectionStatus = ConnectionBuild.map(c=>c.connect)
  ConnectionStatus.foreach(println)
  println(ConnectionStatus)
  //For Yield comprehension
  val myConnectionStatus = for{
    host <- Config.get("Host")
    port <- Config.get("Port")
    connection<- Connection(host,port)
  } yield connection.connect
  myConnectionStatus.foreach(println)
  println(myConnectionStatus)

}
