package Lectures.part2OOP

object MethodNotation extends App{
  //1. Infix, 2. Prefix, 3.Postfix, 4. Apply
  //Infix
  class Person(val name:String,val age:Int,val Favmovie: String){
    def likes(movie: String) = movie ==Favmovie
    def loves(name: Person):String = s"${this.name} really do love ${name.name}"
    def unary_! : String = "Nine Nine !!"
    def sucks= "That's not true!"
    def apply(n:Int)=s"${this.name} will do $n pushups"
    def +(nickname:String)=new Person(s"$name the $nickname",age =this.age,Favmovie)
    def unary_+ = new Person(name,age+1,Favmovie)
    def learns(lang: String) = s"$name learns $lang "
    def learnsScala = Person.this.learns("Scala") // this learns "Scala"
  }
  val Jake = new Person("Jake",27,"Die Hard")
  println(Jake.likes("Die Hard"))
  println(Jake likes "Die Hard") // Methods with one argument can be called like this
  val Amy = new Person("Amy", 26,"Chernobyl")
  println(Jake loves Amy)

  //Prefix unary_ only with +, -, !, ~
  println(!Jake)
  // Postfix
  println(Jake.sucks)
  println(Jake sucks)
  // Apply
  println(Jake.apply(1000))
  println(Jake(1000))

  // Assignment
  // + operator  Mary + "The rockstart" = Mary the rockstar
  println((Jake + "Donger")(1000))
  //+unary operator
  println(Amy.age)
  println((+(+Amy)).age)
  // learns
  println(Jake learns "Karate")
  println(Jake learnsScala)

}
