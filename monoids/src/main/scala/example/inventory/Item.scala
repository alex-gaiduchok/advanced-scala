package example.inventory

final case class ItemId(value: Long) extends AnyVal
final case class LocationId(value: Long) extends AnyVal


final case class Item(id: ItemId)
final case class Quantity(buffer: Long, quantity: Long)


final case class ItemsInfo(id: ItemId, total: Quantity, qByLocations: Map[LocationId, Quantity])