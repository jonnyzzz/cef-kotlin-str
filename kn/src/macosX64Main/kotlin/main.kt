package org.jonnyzzz.example

import kotlinx.cinterop.COpaquePointerVar
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CStructVar
import kotlinx.cinterop.CValue
import kotlinx.cinterop.MemScope
import kotlinx.cinterop.NativePtr
import kotlinx.cinterop.StableRef
import kotlinx.cinterop.asStableRef
import kotlinx.cinterop.cValue
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.memberAt
import kotlinx.cinterop.pointed
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.staticCFunction
import kotlinx.cinterop.value


class MainWrapper(rawPtr: NativePtr) : CStructVar(rawPtr) {
  val cef: _main_struct
    get() = memberAt(0)

  val stablePtr: COpaquePointerVar
    get() = memberAt(_main_struct.size)

  companion object : CStructVar.Type(_main_struct.size + COpaquePointerVar.size, _main_struct.align)
}


class MainClass {
  val MemScope.ptr: CPointer<_main_struct>?
    get() = cValue.ptr.reinterpret()

  private val stableRef: StableRef<MainClass> = StableRef.create(this)

  private val cValue: CValue<MainWrapper> = cValue {
    stablePtr.value = stableRef.asCPointer()
    cef.function = staticCFunction { THIS, param ->
      val pThis = THIS!!.reinterpret<MainWrapper>()
              .pointed
              .stablePtr
              .value!!
              .asStableRef<MainClass>()
              .get()

      pThis.theFunction(param)

    }
  }

  fun theFunction(x : Int) : CPointer<sub_struct_t>? {
    return null
  }
}

fun main() = memScoped {

  val main = MainClass()

  executeMe(main.run { ptr })

}


