package Lectures.part2OOP

object BasicOOP extends App{
  val myPerson = new Person("Harry",11)
  println(myPerson.name)
  println(myPerson.Aadhar_card)
  println(myPerson.collegename("Hogwarts"))
  println(myPerson.collegename)

  //Author and Novel
  val myAuthor =new Author("JK","Rowling",1965)
  println(myAuthor.fullName)
  val mYNovel = new Novel("Harry Potter", 1997, myAuthor)
  println(mYNovel.authorAge)
  println(mYNovel.isWrittenby(myAuthor))

  //Counter Class
  val myCounter = new Counter(10)
  myCounter.inc.inc.inc.print
  myCounter.inc(7).print

}

class Person(val name: String,age:Int) { // class parameters and Fields are different, to make a parameter put val
  val Aadhar_card = "8850000"
  def collegename(name: String="hi"): String = s"${this.name}'s college name is $name" // this. is used for telling to use main parameter
  def collegename:String = "Next college"

// Author
}
class Author(firstName: String, surName: String,val year:Int){
  def fullName: String= firstName+" "+ surName
}
//Novel
class Novel(name: String, year: Int, author: Author){
  def authorAge:Int = year - author.year
  def isWrittenby(author : Author ):Boolean = if(author == this.author) true else false
  def copy(newYear :Int) = new Novel(name, newYear,author)
}
//Counter class
class Counter(val count:Int=0){
  def inc :Counter = {
    println("Incrementing")
    new Counter(count+1)
  }
  def dec :Counter ={
    println("Decrementing")
    new Counter(count-1)
  }
  def inc(n:Int): Counter={
    if(n<=0) this   // this is used for introducing current object for a class, auxiliary methods,
    else inc.inc(n-1)
  }
  def dec(n:Int): Counter={
    if(n<=0) this
    else dec.dec(n-1)
  }
  def print = println(count)
}
