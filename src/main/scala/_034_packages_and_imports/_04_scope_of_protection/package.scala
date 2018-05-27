package _034_packages_and_imports

/**
  * Scope of protection
  *
  * > Access modifiers in Scala can be augmented with qualifiers. A modifier of the form private[X] or protected[X]
  * means that access is private or protected "up to" X, where X designates some enclosing package, class or singleton
  * object.
  *
  * > Qualified access modifiers give you very fine-grained control over visibility.
  * > In particular they enable you to express Java's accessibility notions, such as package private, package protected,
  * or private up to outermost class, which are not directly expressible with simple modifiers in Scala. But they also
  * let you express accessibility rules that cannot be expressed in Java.
  *
  * > class Navigator is labeled private[_04_scope_of_protection]. This means that this class is visible in all classes
  * and objects that are contained in package _04_scope_of_protection.
  * >> In particular, the access to Navigator in object Vehicle is permitted because Vehicle is contained in package
  * launch, which is contained in _04_scope_of_protection.
  * >> On the other hand, all code outside the package _04_scope_of_protection cannot access class Navigator.
  *
  * ▶ This technique is quite useful in large projects that span several packages. It allows you to define things that
  * are visible in several sub-packages of your project but that remain hidden from clients external to your project.
  * The same technique is not possible in Java. There, once a definition escapes its immediate package boundary, it is
  * visible to the world at large.
  *
  * > Of course, the qualifier of a private may also be the directly enclosing package. An example is the access
  * modifier of guide in object Vehicle. Such an access modifier is equivalent to Java's package-private access.
  *
  *
  * > All qualifiers can also be applied to protected, with the same meaning as private.
  * > That is, a modifier protected[X] in a class C allows access to the labeled definition in all subclasses of C and
  * also within the enclosing package, class, or object X.
  * >> For instance, the useStarChart method in Navigator class is accessible in all subclasses of Navigator and also in
  * all code contained in the enclosing package navigation. It thus corresponds exactly to the meaning of protected in
  * Java.
  *
  *
  * > The qualifiers of private can also refer to an enclosing class or object.
  * >> For instance the distance variable in class LegOfJourney is labeled private[Navigator], so it is visible from
  * everywhere in class Navigator.
  * >> This gives the same access capabilities as for private members of inner classes in Java.
  * >> A private[C] where C is the outermost enclosing class is the same as just private in Java.
  *
  *
  * > Finally, Scala also has an access modifier that is even more restrictive than private.
  * > A definition labeled private[this] is accessible only from within the same object that contains the definition.
  * > Such a definition is called object-private.
  * >> For instance, the definition of speed in class Navigator is object-private. This means that any access must not
  * only be within class Navigator, it must also be made from the very same instance of Navigator. Thus the accesses
  * "speed" and "this.speed" would be legal from within Navigator.
  * >> The following access, though, would not be allowed, even if it appeared inside class Navigator:
  * ``
  * val other = new Navigator
  * other.speed // this line would not compile
  * ``
  * > Marking a member private[this] is a guarantee that it will not be seen from other objects of the same class.
  * > This can be useful for documentation.
  * > It also sometimes lets you write more general variance annotations (???) (see Section 19.7 from the book for
  * details).
  *
  *
  * > Summary:
  * Effects of private qualifiers on LegOfJourney.distance
  * no access modifier                ::  public access
  * private[_04_scope_of_protection]  ::  access within outer package
  * private[navigation]               ::  same as package visibility in Java
  * private[Navigator]                ::  same as private in Java
  * private[LegOfJourney]             ::  same as private in Scala
  * private[this]                     ::  access only from same object
  */
package object _04_scope_of_protection {
}