/**
  * # JVM and parallelism:
  * There are many forms of parallelism.
  * Our parallel programming model assumption – multicore or multiprocessor
  * systems with shared memory.
  * Operating system and the JVM as the underlying runtime environments.
  *
  *
  * # Processes:
  * Operating system – software that manages hardware and software
  * resources, and schedules program execution.
  * Process – an instance of a program that is executing in the OS.
  * The same program can be started as a process more than once, or even
  * simultaneously in the same OS.
  * The operating system multiplexes many different processes and a limited
  * number of CPUs, so that they get time slices of execution. This
  * mechanism is called multitasking.
  * Two different processes cannot access each other’s memory directly – they
  * are isolated.
  *
  *
  * # Threads:
  * Each process can contain multiple independent concurrency units called
  * threads.
  * Threads can be started from within the same program, and they share the
  * same memory address space.
  * Each thread has a program counter and a program stack.
  * JVM threads cannot modify each other’s stack memory. They can only
  * modify the heap memory.
  * --> Look at '_01_BasicThreadsExample'
  *
  *
  * # Atomicity:
  * '_01_BasicThreadsExample' showed that separate statements in two threads can
  * overlap.
  * In some cases, we want to ensure that a sequence of statements in a
  * specific thread executes at once.
  * An operation is atomic if it appears as if it occurred instantaneously from
  * the point of view of other threads.
  * --> Look at '_02_SynchronizedBlock'
  *
  *
  * # Deadlocks:
  * Deadlock is a scenario in which two or more threads compete for resources
  * (such as monitor ownership), and wait for each to finish without releasing
  * the already acquired resources.
  *
  * # Resolving deadlocks:
  * One approach is to always acquire resources in the same order.
  * This assumes an ordering relationship on the resources.
  * --> Look at '_03_CompositionWithSynchronizedBlocks'
  *
  *
  * # Memory model:
  * Memory model is a set of rules that describes how threads interact when
  * accessing shared memory.
  * Java Memory Model – the memory model for the JVM.
  * 1. Two threads writing to separate locations in memory do not need
  * synchronization.
  * 2. A thread X that calls join on another thread Y is guaranteed to
  * observe all the writes by thread Y after join returns.
  * *. (There are other rules we won't mention here).
  *
  *
  * # Summary:
  * The parallelism constructs in the remainder of the course (Parallel Programming
  * course, see README.md file for more info)
  * are implemented in terms of:
  * ▶ threads
  * ▶ synchronization primitives such as synchronized
  * It is important to know what’s under the hood!
  */
package object _10_synchronization_primitives {

}