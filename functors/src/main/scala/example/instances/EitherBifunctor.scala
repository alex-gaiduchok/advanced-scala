package example.instances

import definition.Bifunctor

trait EitherBifunctor {
  implicit val eitherBifunctor: Bifunctor[Either] = new Bifunctor[Either] {
    override def bimap[A, B, C, D](fab: Either[A, B])(f: A => C, g: B => D): Either[C, D] =
      fab.map(g).left.map(f)
  }
}
