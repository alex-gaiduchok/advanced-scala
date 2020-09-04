package example

import cats.{Id, Monad}
import cats.instances.option._
import cats.syntax.flatMap._
import cats.syntax.functor._ // for Monad

object Main extends App {

  val addOne: Int => Int = x => x + 1
  val addOneM: Int => Option[Int] = x => Option(x + 1)
  val addTwoM: Int => Option[Int] = x => Option(x + 2)

  // MONAD Laws
  // On Option example

  // Left identity: pure(m).flatMap(func) == func(m)
  println(Option(1).flatMap(addOneM) == addOneM(1))

  // Right identity: m.flatMap(pure) == m
  println(Option(1).flatMap(Option.apply) == Option(1))

  // Associativity: m.flatMap(f).flatMap(g) == m.flatMap(x => f(x).flatMap(g))
  println(Option(1).flatMap(addOneM).flatMap(addTwoM) == Option(1).flatMap(x =>
    addOneM(x).flatMap(addTwoM)))

  // Abstracting with monads

  def sumSquare[F[_]: Monad](a: F[Int], b: F[Int]): F[Int] =
    a.flatMap(x => b.map(y => x * x + y * y))

  def sumSquare2[F[_]: Monad](a: F[Int], b: F[Int]): F[Int] =
    for {
      x <- a
      y <- b
    } yield x * x + y * y

  // The methods above are equivalent

  println(sumSquare(Option(3), Option(4)))
  println(sumSquare2(Option(3), Option(4)))

  println(sumSquare2[Id](3, 4)) // The Identity Monad is used here
}
