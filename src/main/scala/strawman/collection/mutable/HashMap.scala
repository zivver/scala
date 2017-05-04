package strawman
package collection.mutable

import strawman.collection.{Iterator, MapFactory}

import scala.{Option, Unit}
import scala.Predef.???

/** A mutable map backed by a hashtable */
final class HashMap[K, V] extends Map[K, V] with MapLike[K, V, HashMap] {

  // From IterableOnce
  def iterator(): Iterator[(K, V)] = ???

  // From MapLike
  def get(key: K): Option[V] = ???

  // From Growable
  def add(elem: (K, V)): this.type = ???
  def clear(): Unit = ???

  // From mutable.MapLike
  def remove(elem: (K, V)): this.type = ???
  def put(key: K, value: V): Option[V] = ???

  protected def mapFromIterable[K2, V2](it: collection.Iterable[(K2, V2)]): HashMap[K2, V2] = ???
  protected[this] def fromSpecificIterable(coll: collection.Iterable[(K, V)]): HashMap[K, V] = mapFromIterable(coll)
}

object HashMap extends MapFactory[HashMap] {

  def newBuilder[K, V]: Builder[(K, V), HashMap[K, V]] = ???

  def empty[K, V]: HashMap[K, V] = new HashMap[K, V]

}
