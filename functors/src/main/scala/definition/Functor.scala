package definition

/**
 * Endofunctor in programming is the same as Functor
 *
 * Functor that maps a category back to that same category is called an endofunctor.
 * Quick detour from the category theory into the real world — in programming,
 * we deal with functors in category of types, and they are all endofunctors.
 * They map a category of types back to category of types.
 * Whenever you mapped something (map in Scala, fmap in Haskell) you had an endofunctor in your hands.
 * For example, Option, List and Future are all valid endofunctors. Basically anything that has a map() function is an endofunctor.
 *
 *
 * https://medium.com/free-code-camp/demistifying-the-monad-in-scala-part-2-a-category-theory-approach-2f0a6d370eff
 */

trait Functor[F[_]] {
  def map[A, B](fa: F[A])(f: A => B): F[B]
}

/**
 * Functors laws:
 *
 * 1 identity:
 * val list = List(1)
 *
 * Functor.map(list)(identity) == list
 *
 * 2 composition:
 *
 * def multiply2(i: Int) = i * 2
 * def multiply4(i: Int) = i * 4
 * val list = List(1)
 *
 * Functor.map(list)(v => multiply4(multiply2(v))) == Functor(list).map(multiply2).map(multiply4)
 *
 */

object Functor {

  def map[F[_] : Functor, A, B](fa: F[A])(func: A => B): F[B] =
    implicitly[Functor[F]].map(fa)(func)

}