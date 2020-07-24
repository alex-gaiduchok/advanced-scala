package definition

/**
 * the simplest way to map functor with 2 type params
 * like Either
 */
trait Bifunctor[F[_, _]] {
  def bimap[A, B, C, D](fab: F[A, B])(f: A => C, g: B => D): F[C, D]
}
