package Excercises

import Excercises.OOP_Practice.EvenPredicate

object OOP_Practice extends App{

  /*
    1.  Generic trait MyPredicate[-T] with a little method test(T) => Boolean
    2.  Generic trait MyTransformer[-A, B] with a method transform(A) => B
    3.  MyList:
        - map(transformer) => MyList
        - filter(predicate) => MyList
        - flatMap(transformer from A to MyList[B]) => MyList[B]

        class EvenPredicate extends MyPredicate[Int]
        class StringToIntTransformer extends MyTransformer[String, Int]

        [1,2,3].map(n * 2) = [2,4,6]
        [1,2,3,4].filter(n % 2) = [2,4]
        [1,2,3].flatMap(n => [n, n+1]) => [1,2,2,3,3,4]
   */

  trait MyPredicate[-A]{
    def test(element:A):Boolean
  }
  trait MyTransformer[-A,B]{
    def transform(element: A): B
  }
  class EvenPredicate extends MyPredicate[Int]{
    override def test(element: Int): Boolean = if(element%2==0) true else false
  }
  class intAndNegative extends MyTransformer[Int,myList[Int]]{
    override def transform(element: Int): myList[Int] = new Cons (element,new Cons(-1*element,emptyList))
  }
  val list = new Cons[Int](1,new Cons[Int](2,new Cons[Int](3,new Cons[Int](4,emptyList))))
  val stringList = new Cons[String]("9", new Cons[String]("8",new Cons[String]("5",emptyList)))

  val myEvenPredicate = new EvenPredicate
  println(list.map(new MyTransformer[Int,Int] {
    override def transform(element: Int): Int = element*element
  }).toString)
  println(list.filter(new EvenPredicate))
  println((list ++ stringList ).toString)
  println(list.flatMap(new intAndNegative))

}
