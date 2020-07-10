package example.inventory.instances

import definition.Monoid
import example.inventory.Quantity

trait MonoidInstances {

  implicit val mq: Monoid[Quantity] = new Monoid[Quantity] {
    override def empty: Quantity = Quantity(0, 0)
    override def combine(x: Quantity, y: Quantity): Quantity =
      Quantity(x.buffer + y.buffer, x.quantity + y.quantity)
  }
}
