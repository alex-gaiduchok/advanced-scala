package definition

/**
 *  in general we us only pure method to wrap some values
 *  Right(42)
 *  Left("unknown error")
 *  Some(1)
 */
trait ApplicativeFunctor[F[_]] extends Functor[F] {
  def pure[A](v: A): F[A]
  def ap[A, B](ff: F[A => B])(fa: F[A]): F[B]
}