package _070_timely_effects._01_the_observer_pattern

trait Subscriber {
  def handler(publisher: Publisher)
}