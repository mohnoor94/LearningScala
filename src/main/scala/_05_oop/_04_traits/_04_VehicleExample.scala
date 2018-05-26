package _05_oop._04_traits

// a trait is like interface in Java but can have
// concrete members.

object Runner extends App {
  val bicycle = new Bicycle(20)
    .increaseSpeed(15)
    .decreaseSpeed(3)
  println(bicycle)
  println(bicycle.concreteMethod)
}

trait Vehicle {
  def increaseSpeed(x: Int): Vehicle

  def decreaseSpeed(x: Int): Vehicle

  def concreteMethod = "Yes, I can have concrete methods :3"
}

// hmmmm.. extends?
class Bicycle(val currentSpeed: Int) extends Vehicle {
  override def increaseSpeed(x: Int): Vehicle = new Bicycle(currentSpeed + x)

  override def decreaseSpeed(x: Int): Vehicle = new Bicycle(currentSpeed - x)

  override def toString = s"Bicycle(currentSpeed=$currentSpeed)"
}