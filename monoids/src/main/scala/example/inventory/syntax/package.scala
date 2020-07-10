package example.inventory

import definition.Semigroup

package object syntax {
  implicit final class SemigroupSyntax[A: Semigroup](value: A) {
    def `this is combine of semigroup`(y: A): A = Semigroup.combineCB(value, y)
    def |+|(y: A): A = Semigroup.combineImpl(value, y)
  }
}