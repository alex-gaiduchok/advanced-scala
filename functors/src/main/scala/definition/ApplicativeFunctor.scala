package definition

trait ApplicativeFunctor[F[_]] extends Functor[F] {
  def pure[A](v: A): F[A]
  def ap[A, B](ff: F[A => B])(fa: F[A]): F[B]
}