package example.collections

import example.others.PrettyString

trait IntFunctors {
  implicit val longPretty = new PrettyString[Long] {
    override def prettify(a: Long): String =
      s"this is the num: $a"
  }
}
