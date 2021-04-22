package Lectures.part3functionalProgramming

import scala.util.Random

object Sequences extends App{

  //Seq
  val Sequence = Seq(3,6,4,9,2,1)
  println(Sequence)
  println(Sequence(2))
  println(Sequence.reverse)
  println(Sequence.sorted)
  println(Sequence :+ 98)
  println(Sequence++Sequence)

  //Ranges
  val myRange = 1 to 10
  myRange.foreach(println)
  myRange.foreach(x=> println(Sequence(2)))

  // List
  // fill and mkstring
  val myList = List(1,3,4,5,6,8)
  println(myList.mkString("@"))
  val FillwithLetters = List.fill(4)("Letters")
  println(FillwithLetters)

  // Arrays
  val myArray = Array(0,5,4,2,1)
  val myArray1 = Array.ofDim(5)
  myArray1.foreach(println)
  // Mutation in array
  myArray(4) =99   // Actually a update function myArray.update(4,99)
  println(myArray.mkString(" "))

  // Arrays and Sequence
  val newSeq:Seq[Int]= myArray   // implicit conversion
  println(newSeq)

  // Vector
  val myVector = Vector(1,2,3,4)
  println(myVector)

  //Vector vs List

  val maxTime =1000
  val maxCapacity = 1000000
  def getComputationTime(collection: Seq[Int]):Double ={
  val r = new Random
    val times = for {
      it <- 1 to maxTime
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity),0)
      System.nanoTime()-currentTime
    }
    times.sum*1.0/ maxTime
    }

  val numberList = (1 to maxCapacity).toList
  val numberVector = (1 to maxCapacity).toVector
  println(getComputationTime(numberList))
  println(getComputationTime(numberVector))




}
