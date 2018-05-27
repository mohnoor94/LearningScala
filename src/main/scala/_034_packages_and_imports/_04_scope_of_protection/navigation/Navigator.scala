package _034_packages_and_imports._04_scope_of_protection.navigation

private[_04_scope_of_protection] class Navigator {
  protected[navigation] def useStarChart(): Unit = {}

  class LegOfJourney {
    private[Navigator] val distance = 100
  }

  private[this] var speed = 200
}