package definition

trait ContravariantFunctor[F[_]] {
  def contramap[A, B](fa: F[A])(f: B => A): F[B]
}
