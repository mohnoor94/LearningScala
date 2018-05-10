package _10_jvm_parallel_programming

/**
  * # Creating and starting threads:
  * Each JVM process starts with a main thread.
  * To start additional threads:
  * 1. Define a Thread subclass.
  * 2. Instantiate a new Thread object.
  * 3. Call start on the Thread object.
  * The Thread subclass defines the code that the thread will execute. The
  * same custom Thread subclass can be used to start multiple threads.
  *
  * Hint: Run this multiple times!
  */
object _01_BasicThreadsExample extends App {
  val t1 = new HelloThread
  val t2 = new HelloThread
  t1.start()
  t2.start()
  t1.join()
  t2.join()
}

class HelloThread extends Thread {
  override def run(): Unit = {
    println("Hello")
    println("world!")
    for (i <- 0 until 10) print(s"$i, ")
    println
    println("done!")
  }
}