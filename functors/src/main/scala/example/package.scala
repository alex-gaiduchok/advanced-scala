import definition.Bifunctor

package object example {
  implicit class EitherOps[A, B](val either: Either[A, B]) extends AnyVal {
    def bimap[C, D](f: A => C, g: B => D)(implicit bme: Bifunctor[Either]): Either[C, D] =
      bme.bimap(either)(f, g)
  }
}
