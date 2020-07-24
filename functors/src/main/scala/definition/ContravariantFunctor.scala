package definition

/**
 * approach to apply existed typeclass instance to new type
 */
trait ContravariantFunctor[F[_]] {
  def contramap[A, B](fa: F[A])(f: B => A): F[B]
}
