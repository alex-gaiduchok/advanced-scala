package example

import definition.Functor
import example.collections.{IntFunctors, ListFunctors}

object Main extends App with ListFunctors with IntFunctors {
  val l = List(1,2,3)

  println(Functor.map(l)(_ * 2))

  println(listApplicative.pure(123))

}
