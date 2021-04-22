package Excercises



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
  //Used for Part 2
/**
  trait MyPredicate[-A]{
    def test(element:A):Boolean
  }
  trait MyTransformer[-A,B]{
    def transform(element: A): B
  }
  **/
/**
  class EvenPredicate extends MyPredicate[Int]{
    override def test(element: Int): Boolean = if(element%2==0) true else false
  }
  class intAndNegative extends MyTransformer[Int,myList[Int]]{
    override def transform(element: Int): myList[Int] = new Cons (element,new Cons(-1*element,emptyList))
  }
**/
  val list = Cons[Int](1,Cons[Int](2,Cons[Int](3,Cons[Int](4,emptyList))))
  val stringList =  Cons[String]("9", Cons[String]("8",Cons[String]("5",emptyList)))

  //val myEvenPredicate = new EvenPredicate
  println(list.map(_*(-1)).toString) // x=>x*(-1)
  println(list.filter(_%2==0))// x=> x%2==0
  println((list ++ stringList ).toString)
  println(list.flatMap(element => Cons (element,Cons(-1*element,emptyList))))

}
