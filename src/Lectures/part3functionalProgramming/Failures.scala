package Lectures.part3functionalProgramming

//import com.sun.net.httpserver.Authenticator.Success

import scala.util.{Failure, Random, Success, Try}

object Failures extends App{

  // Success and Failures
  val mySuccess =Success(3)
  val myFailure = Failure(new RuntimeException("This is a failure"))
  println(myFailure)
  println(mySuccess)

  def unSafeMethod():String = throw new RuntimeException("This can crash the program")
  val StoreTheRiskyResult = Try{
    unSafeMethod()
  }
  println(StoreTheRiskyResult)

  // utilities
  println(StoreTheRiskyResult.isFailure)
  //orElse
  def myBackUpMethod():String ="This one is good"
  val myOutput = Try(unSafeMethod()).orElse(Try(myBackUpMethod()))
  // Better way of doing

  def myRisk(): Try[String]= Failure(new RuntimeException("This is a problem!"))
  def myBackup(): Try[String]= Success("This is Okay!")
  val myResults = myRisk() orElse myBackup()
  println(myResults)
  // map, flatmat and filter

  println(mySuccess.map(_*20))
  println(mySuccess.flatMap(x=> Success(x+11)))
  println(mySuccess.filter(x=> x>10))

  // Excercise
  val host ="176.20.198.30"
  val port ="8080"
  def renderHTML(page: String) = println(page)

  class Collection{
    def get(url:String):String ={
      val random = new Random(System.nanoTime())
      if(random.nextBoolean()) ("<html>.....</html>")
      else throw new RuntimeException("No URL available")
    }
    // add a safe function as the above one can lead to run exception
    def getSafeURL(url:String): Try[String]= Try(get(url))
  }

  object HttpService{
    val random = new Random(System.nanoTime())

    def getServer(port: String, host:String):Collection={
      if(random.nextBoolean()) new Collection
      else throw new RuntimeException("Server not connected")
    }
    // As the above method will throw an exception if server not connected
    def SafegetServer(port: String, host: String): Try[Collection]= Try(getServer(port,host))
  }

  val returnHttpSrver = HttpService.SafegetServer(host,port)
  val FinalUrl = returnHttpSrver.flatMap(x=> x.getSafeURL("fb.com"))
  FinalUrl.foreach(println)
  println(FinalUrl)

  // for Comprehension

  val myUrl = for {
    httpConnection <- HttpService.SafegetServer(host,port)
    myURL <- httpConnection.getSafeURL("fb.com")
  } yield renderHTML(myURL)



}
