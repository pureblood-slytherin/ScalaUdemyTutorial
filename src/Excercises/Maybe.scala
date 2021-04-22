package Excercises

abstract class Maybe[+T] {
  def map[B](function: T=>B):Maybe[B]
  def flatmap[B](function: T=>Maybe[B]):Maybe[B]
  def filter(check: T=>Boolean):Maybe[T]
  def foreach(f: T=>Unit):Unit
}

case object MaybeNot extends Maybe [Nothing] {
  def map[B](function: Nothing=>B):Maybe[B] = MaybeNot
  def flatmap[B](function: Nothing=>Maybe[B]):Maybe[B] = MaybeNot
  def filter(check: Nothing=>Boolean):Maybe[Nothing]= MaybeNot
  def foreach(f: Nothing=>Unit):Unit = MaybeNot
}
case class Just[+T](value:T) extends Maybe[T]{
  def map[B](function: T=>B):Maybe[B] =Just(function(value))
  def flatmap[B](function: T=>Maybe[B]):Maybe[B] = function(value)
  def filter(check: T=>Boolean):Maybe[T]=
    if(check(value)) this
    else MaybeNot
  def foreach(f: T=>Unit):Unit = println(value)
}

object MaybeTest extends App{
  val just5 = Just(5)
  val flatmapJust = just5.flatmap(x=>Just(x*x))
  val filterJust = flatmapJust.filter(_%2==0)
  println(just5)
  println(flatmapJust)
  println(filterJust)

}