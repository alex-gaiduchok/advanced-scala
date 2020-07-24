package example.collections

import definition.{ApplicativeFunctor, ContravariantFunctor, Functor}

import scala.collection.mutable.ArrayBuffer

trait ListFunctors {

  implicit val listFunctor: Functor[List] = new Functor[List] {
    override def map[A, B](fa: List[A])(f: A => B): List[B] = {
      val iter = fa.iterator
      val mutList = ArrayBuffer.empty[B]
      while (iter.hasNext){
        mutList.addOne(f(iter.next))
      }
      mutList.toList
    }
  }

  implicit val listApplicative: ApplicativeFunctor[List] = new ApplicativeFunctor[List] {
    override def pure[A](v: A): List[A] = List(v)
    override def ap[A, B](ff: List[A => B])(fa: List[A]): List[B] = fa.flatMap(a => ff.map(func => func(a)))
    override def map[A, B](fa: List[A])(f: A => B): List[B] = ap(pure(f))(fa)
  }

}
