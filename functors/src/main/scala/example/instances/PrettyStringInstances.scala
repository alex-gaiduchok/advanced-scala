package example.instances

import definition.PrettyString

trait PrettyStringInstances {
  implicit val longPretty: PrettyString[Long] = new PrettyString[Long] {
    override def prettify(a: Long): String =
      s"this is the num: $a"
  }
}
