package example

import definition.{Functor, PrettyString}
import example.instances.{EitherBifunctor, ListFunctors, PrettyStringInstances}

object Main extends App with ListFunctors with PrettyStringInstances with  EitherBifunctor {
  val l = List(1,2,3)

  println(Functor.map(l)(_ * 2))

  println(listApplicative.pure(123))

  val e: Either[String, Int] = Right(1)
  val e2 = e.bimap(_.toUpperCase(), _ * 42)
  println(e2)

  implicit val strPrettifier: PrettyString[String] =
    PrettyString.contramap(_.toLong)

  println(PrettyString.prettify("22"))
}
