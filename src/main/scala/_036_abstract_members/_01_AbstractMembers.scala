package _036_abstract_members

/**
  * Main Resource: Chapter 20 - Abstract Member, From Programming in Scala, Third Edition.
  *
  * > In Scala, we could have abstract methods, vals, vars, and types.
  *
  * 20.2 TYPE MEMBERS
  * > An abstract type in Scala is always a member of some class or trait, such as type T in trait Abstract.
  * >> You can think of a non-abstract (or "concrete") type member, such as type T in class Concrete, as a way to define
  * a new name, or alias, for a type.
  * > One reason to use a type member is to define a short, descriptive alias for a type whose real name is more verbose,
  * or less obvious in meaning, than the alias. Such type members can help clarify the code of a class or trait.
  * > The other main use of type members is to declare abstract types that must be defined in subclasses.
  *
  * 20.3 ABSTRACT VALS
  * > You use an abstract val declaration in a class when you do not know the correct value in the class, but you do
  * know that the variable will have an unchangeable value in each instance of the class.
  * > An abstract val constrains its legal implementation: Any implementation must be a val definition;
  * >> it may not be a var or a def.
  * > Abstract method declarations, on the other hand, may be implemented by both concrete method definitions and
  * concrete val definitions.
  *
  *
  * 20.4 ABSTRACT VARS
  * > Like an abstract val, an abstract var declares just a name and a type, but not an initial value.
  * > vars declared as members of classes come equipped with getter and setter methods. This holds for abstract vars as
  * well.
  * >> If you declare an abstract var named hour, for example, you implicitly declare an abstract getter method, hour,
  * and an abstract setter method, hour_=.
  * >> There's no reassignable field to be defined—that will come in subclasses that define the concrete implementation
  * of the abstract var.
  *
  * @see '_970_scala_puzzlers._04_NowYouSeeMeNowYouDoNot'
  *
  *
  * Read 20.10 CASE STUDY: CURRENCIES
  */
object _01_AbstractMembers {

  trait Abstract {
    type T

    def transform(x: T): T

    val initial: T
    var current: T
  }

  class Concrete extends Abstract {
    type T = String

    def transform(x: String): String = x + x

    val initial = "hi"
    var current: String = initial
  }

}
