package org.jonnyzzz.example

import kotlinx.cinterop.memScoped

fun main() = memScoped {

  println("HEllo! ")

  val z = Impl().foo()

  println("Actual result of foo() : $z")

  val q = object: Base() {
    override fun foo() = null
  }

  println("Another trick ${q.foo()}")

  val main = object : MainClass(this) {
    override fun theFunction(x : Int) = null
  }

  try {
    executeMe(main.run { ptr })
  }catch (t: Throwable) {
    println("Crashed $t")
  }
}


