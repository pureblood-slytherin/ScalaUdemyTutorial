package Excercises
// Basic Int type
/**
abstract class myList {
  def head: Int
  def tail : myList
  def isEmpty: Boolean
  def add(n:Int) : myList
  def print: String
  override def toString: String = "[" + print +"]"
}
object emptyList extends myList{
  def head: Int = throw new NoSuchElementException
  def tail : myList= throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(n:Int) : myList = new Cons(n,emptyList)
  def print : String=" "
  //def toString : "String"
}
class Cons(h : Int ,t : myList) extends myList{
  def head: Int = h
  def tail : myList= t
  def isEmpty: Boolean= false
  def add(n:Int) : myList= new Cons(n,this)
  def print:String ={
    if(t.isEmpty) " " + h
    else h+ " " + t.print
  }
}
object ListTest extends App{
  val myFirstList = new Cons(2,new Cons(3,new Cons(7,emptyList)))
  println(myFirstList.tail.head) // should print 3 (head of the tail
  println(myFirstList.add(5).head)
  println(myFirstList.toString)
}
**/
// Generic type
abstract class myList[+A] {
  def head: A
  def tail : myList[A]
  def isEmpty: Boolean
  def add[B>: A](element:B) : myList[B]
  def print: String
  override def toString: String = "[" + print +"]"
}
object emptyList extends myList[Nothing]{
  def head: Nothing = throw new NoSuchElementException
  def tail : Nothing = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B>: Nothing](n:B) : myList[B] = new Cons(n,emptyList)
  def print : String=" "
  //def toString : "String"
}
class Cons[+A](h : A ,t : myList[A]) extends myList[A]{
  def head: A = h
  def tail : myList[A]= t
  def isEmpty: Boolean= false
  def add[B>:A](n : B) : myList[B]= new Cons(n,this)
  def print:String ={
    if(t.isEmpty) " " + h
    else h+ " " + t.print
  }
}

object ListTest extends App{
  val myStringList = new Cons("Gryffindor", new Cons("Slytherin",new Cons("Hufflepuff", new Cons("Ravenclaw",emptyList))))
  println(myStringList.toString)
}

