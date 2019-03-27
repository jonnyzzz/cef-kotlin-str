package org.jonnyzzz.example

import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CValue
import kotlinx.cinterop.alloc
import kotlinx.cinterop.cValue
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import kotlinx.cinterop.useContents

fun main() = memScoped {

  val s: CValue<value_struct_t> = cValue {
    v = 132
  }

  println("cValue useContants value: " + s.useContents { v })
  s.useContents { v = 9594 }
  println("cValue after useContents: " + s.useContents { v })

  doSomethingWith(s.ptr)
  println("change cValue pointer from C: " + s.useContents { v })


  val a: value_struct_t = alloc {
    v = 1231
  }

  println("alloc value: " + a.v)
  a.v = 9999
  println("alloc after update: " + a.v)
  doSomethingWith(a.ptr)
  println("change alloc pointer from C: " + a.v)
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


