package _050_implicit

import java.util.concurrent.{ExecutorService, Executors}

import scala.concurrent.{ExecutionContext, ExecutionContextExecutorService, Future}

/**
  * implicit is really used to bind services that require something and
  * you don't particularly need to inject everywhere explicitly, in this
  * case let's discuss Future[+T]
  */
object _05_ImplicitAndFuture extends App {
  private val executorService: ExecutorService = Executors.newFixedThreadPool(10) // Java
  implicit private val executorContext: ExecutionContextExecutorService = ExecutionContext.fromExecutorService(executorService) // Scala

  val future = Future {
    println(s"Inside future: ${Thread.currentThread().getName}")
    Thread.sleep(2000)
    50 + 100
  } /*(executorContext)*/

  future.foreach(println) /*(executorContext)*/

  future.onComplete(println) /*(executorContext)*/
}