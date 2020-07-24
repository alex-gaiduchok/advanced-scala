package example.collections

import definition.Functor

object Main extends App with ListFunctors {
  val l = List(1,2,3)

  println(Functor.map(l)(_ * 2))

}
