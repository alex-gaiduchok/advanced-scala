package definition

trait Semigroup[A] {
  def combine(x: A, y: A): A
}

object Semigroup {
  // via context bounds
  def combineCB[A: Semigroup](x: A, y: A): A =
    implicitly[Semigroup[A]].combine(x, y)

  // via implicit param
  def combineImpl[A](x: A, y: A)(implicit m: Semigroup[A]): A =
    m.combine(x, y)
}
