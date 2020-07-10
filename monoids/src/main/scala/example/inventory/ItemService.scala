package example.inventory


import definition.{Monoid, Semigroup}
import example.inventory.instances.mq
import example.inventory.syntax._
import global.Id

import scala.concurrent.{ExecutionContext => EX}
import scala.languageFeature.postfixOps


trait ItemService[F[_]] {
  def listItems: F[List[ItemsInfo]]
}

final class ItemServiceImpl()(implicit ec: EX) extends ItemService[Id] {
  private val itemsList =
    List(
      Item(ItemId(1)),
      Item(ItemId(2)),
      Item(ItemId(3)),
    )

  private val quantitiesByLocations =
    Map(
      ItemId(1) -> Map(
        LocationId(1) -> Quantity(0, 100),
        LocationId(2) -> Quantity(0, 79)
      ),
      ItemId(2) -> Map(
        LocationId(1) -> Quantity(0, 678),
        LocationId(2) -> Quantity(0, 990)
      ),
      ItemId(3) -> Map(
        LocationId(1) -> Quantity(0, 23),
        LocationId(2) -> Quantity(0, 789)
      )
    )


  override def listItems: Id[List[ItemsInfo]] =
    itemsList.map { item =>
      val byLocations = quantitiesByLocations(item.id)
//      val total = byLocations.values.reduce(_ `this is combine of semigroup` _)
//      val total = byLocations.values.reduce(_ |+| _)
      val total = byLocations.values.reduce((a, b) => Semigroup.combineCB(a, b)(mq))
      //  same as: .reduce((a, b) => a |+| b)
      ItemsInfo(item.id, total, byLocations)
    }

}
