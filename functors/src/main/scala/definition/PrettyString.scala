package definition

/**
 *  just type class
 */
trait PrettyString[A] extends ContravariantFunctor[PrettyString] {
  def prettify(a: A): String

  override def contramap[A, B](fa: PrettyString[A])(f: B => A): PrettyString[B] =
    b => fa.prettify(f(b))
}

object PrettyString {
  def prettify[A: PrettyString](fa: A): String =
    implicitly[PrettyString[A]].prettify(fa)

  def contramap[A, B](f: B => A)(implicit  p: PrettyString[A]): PrettyString[B] =
    p.contramap(p)(f)
}