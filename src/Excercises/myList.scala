package Excercises

//import Excercises.OOP_Practice.{MyPredicate, MyTransformer}
// Part 1. Basic Int type
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

/*
    1.  Expand MyList
        - foreach method A => Unit
          [1,2,3].foreach(x => println(x))

        - sort function ((A, A) => Int) => MyList
          [1,2,3].sort((x, y) => y - x) => [3,2,1]

        - zipWith (list, (A, A) => B) => MyList[B]
          [1,2,3].zipWith([4,5,6], x * y) => [1 * 4, 2 * 5, 3 * 6] = [4,10,18]

        - fold(start)(function) => a value
          [1,2,3].fold(0)(x + y) = 6

    2.  toCurry(f: (Int, Int) => Int) => (Int => Int => Int)
        fromCurry(f: (Int => Int => Int)) => (Int, Int) => Int

    3.  compose(f,g) => x => f(g(x))
        andThen(f,g) => x => g(f(x))
   */

// Part 2. Generic type

abstract class myList[+A] {
  def head: A
  def tail : myList[A]
  def isEmpty: Boolean
  def add[B>: A](element:B) : myList[B]
  def print: String
  override def toString: String = "[" + print +"]"

  def map[B](transform: A=>B) : myList[B]
  def flatMap[B](transform: A=> myList[B]): myList[B]
  def filter(element: A=>Boolean): myList[A]
  def ++[B>: A](list: myList[B]):myList[B]
  //HOFs
  def foreach(f: A=>Unit):Unit
  def sort(f: (A,A)=>Int): myList[A]
  def zipwith[B,C](list:myList[B],zip: (A,B)=>C):myList[C]
  def fold[B](start:B)(operator: (A,B)=>B):B
}
case object emptyList extends myList[Nothing]{
  def head: Nothing = throw new NoSuchElementException
  def tail : Nothing = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B>: Nothing](n:B) : myList[B] = new Cons(n,emptyList)
  def print : String=" "
  def map[B](transform: Nothing=> B): myList[B] = emptyList
  def flatMap[B](transform: Nothing=>myList[B]): myList[B] =emptyList
  def filter(element: Nothing=>Boolean):myList[Nothing]=emptyList
  def ++[B>:Nothing](list: myList[B]):myList[B] = list
  //HOFs
  def foreach(f: Nothing =>Unit):Unit = ()
  def sort(f: (Nothing,Nothing)=>Int): myList[Nothing]=emptyList
  def zipwith[B,C](list:myList[B],zip: (Nothing,B)=>C):myList[C] = {
    if(!list.isEmpty) throw new RuntimeException("Empty list cannot be zipped with non empty list")
    else emptyList
  }
  def fold[B](start:B)(operator: (Nothing,B)=>B):B= start
}
case class Cons[+A](h : A ,t : myList[A]) extends myList[A] {
  def head: A = h
  def tail: myList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](n: B): myList[B] = new Cons(n, this)
  def print: String = {
    if (t.isEmpty) " " + h
    else h + " " + t.print
  }
  def filter(element: A=>Boolean): myList[A] = {
    if (element(h)) new Cons(h, t.filter(element))
    else t.filter(element)
  }
  def map[B](transform: A=> B): myList[B] = {
    new Cons[B](transform(h), t.map(transform))
  }
  def flatMap[B](transform: A =>myList[B]): myList[B] = {
    transform.apply(h) ++ t.flatMap(transform)
  }
  def ++[B >: A](list: myList[B]): myList[B] = new Cons(h, t ++ list)

  //HOFs
  def foreach(f: A=>Unit):Unit = {
    f(h)
    t.foreach(f)
  }
  def sort(f: (A,A)=>Int): myList[A] = {
    def inserSort(x: A, sortedList: myList[A]):myList[A]={
      if(sortedList.isEmpty) Cons(x,emptyList)
      else if (f(x,sortedList.head) <= 0) Cons(x,sortedList)
      else Cons(sortedList.head, inserSort(x,sortedList.tail))
    }
    val sortedTail =t.sort(f)
    inserSort(h,sortedTail)
  }
  def zipwith[B,C](list:myList[B],zip: (A,B)=>C):myList[C]={
    if(list.isEmpty) throw new RuntimeException("List is empty")
    else Cons(zip(h,list.head),t.zipwith(list.tail,zip))
  }
  def fold[B](start:B)(operator: (A,B)=>B):B={
    t.fold(operator(h,start))(operator)
  }
}


/*
   head = first element of  the  list
   tail = remainder of the list
   isEmpty = is this list empty
   add(int) => new list with this element added
   toString => a string representation of the list
 */


object ListTest extends App{
  val myStringList = new Cons("Gryffindor", new Cons("Slytherin",new Cons("Hufflepuff", new Cons("Ravenclaw",emptyList))))
  println(myStringList.toString)
  val myInstList = Cons(7,Cons(8,Cons(9,Cons(6,emptyList))))
  val myInstList1 = Cons(9,Cons(11,Cons(3,Cons(4,emptyList))))

  println(myInstList.sort((x:Int,y:Int)=>(y-x)))
  println(myInstList.zipwith(myInstList1,(x:Int,y:Int)=>x*y))
  println(myStringList.zipwith[Int,String](myInstList1, _ +"-" + _ ))
  println(myInstList1.fold[Int](0)(_ + _))      // x:Int,y:Int)=>x+y

  val ForCheckInMYList = for{
    n1 <- myInstList
    houses <-myStringList
  } yield ""+n1+houses
  println(ForCheckInMYList)

}


