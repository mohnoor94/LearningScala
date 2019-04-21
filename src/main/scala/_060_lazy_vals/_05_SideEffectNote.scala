package _060_lazy_vals

object _05_SideEffectNote extends App {

  val example1: Unit = {
    println("===== example 1:")
    def sideEffectCondition: Boolean = {
      println("Any side effect we want")
      true
    }

    def simpleCondition: Boolean = false

    lazy val lazyCondition = sideEffectCondition

    // note that: we do not evaluate `lazyCondition` (and `sideEffectCondition`)
    // since they are not needed
    // so that our side effect action does not evaluated at all
    // make sure not to put you side effect in such a case if you want it to be executed always!
    println(if (simpleCondition && lazyCondition) "yes" else "no")
  }
}
