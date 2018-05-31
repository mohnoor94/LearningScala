package _035_mutable_objects

/**
  * From Chapter 18 - Mutable Objects
  * Programming in Scala, Third Edition
  *
  * > Mutation and vars usually go hand in hand, but things are not always so clear cut. For instance,
  * >> a class might be mutable without defining or inheriting any vars because it forwards method calls to other
  * objects that have mutable state.
  * >> The reverse is also possible: A class might contain vars and still be purely functional.
  * >>> An example would be a class that caches the result of an expensive operation in a field for optimization purposes.
  * >>> To pick an example, assume the following unoptimized class Keyed with an expensive operation computeKey:
  */
object _01_MutationAndVars {

  class Keyed {
    def computeKey: Int = 10 // this will take some time (given that we make an action to compute the value).
  }

  /** > Provided that computeKey neither reads nor writes any vars, you can make Keyed more efficient by adding a cache:
    * ...
    * > Using MemoKeyed instead of Keyed can speed things up because the second time the result of the computeKey
    * operation is requested, the value stored in the keyCache field can be returned instead of running computeKey once
    * again. But except for this speed gain, the behavior of class Keyed and MemoKeyed is exactly the same.
    * Consequently, if Keyed is purely functional, then so is MemoKeyed, even though it contains a reassignable variable.
    * */
  class MemoKeyed extends Keyed {
    private var keyCache: Option[Int] = None
    override def computeKey: Int = {
      if (keyCache.isEmpty) keyCache = Some(super.computeKey)
      keyCache.get
    }
  }
}
