package org.jonnyzzz.example

import kotlinx.cinterop.CPointer
import kotlinx.cinterop.cValue
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.useContents

fun main() = memScoped {

  val s = cValue<value_struct_t> {
    v = 132
  }

  println(s.useContents { v })
  s.useContents { v = 9594 }
  println(s.useContents { v })
}


fun main2() = memScoped {

  println("HEllo! ")

  val z = Impl().foo()

  println("Actual result of foo() : $z")

  val q = object: Base() {
    override fun foo() = null
  }

  println("Another trick ${q.foo()}")

  val main = object : MainClass(this) {
    override fun theFunction(x : Int) : CPointer<sub_struct_t>? = null
  }

  try {
    executeMe(main.run { ptr })
  }catch (t: Throwable) {
    println("Crashed $t")
  }
}


