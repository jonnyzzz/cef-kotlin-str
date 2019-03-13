
plugins {
  kotlin("multiplatform")
}

repositories {
  mavenCentral()
}


class M

run {
  var cl : ClassLoader?= M().javaClass.classLoader
  while(cl != null) {
    println("CL: $cl")
    val urlcl = cl as? java.net.URLClassLoader
    if (urlcl != null) {
      urlcl.getURLs().map {it.toString().split("/").last() }.sorted().forEach {
        println("    " + it.toString().split("/").last())
      }
    }
    cl = cl.parent
  }
}



kotlin {
  macosX64 {
    val main by compilations

    main.kotlinOptions.freeCompilerArgs = listOf("-Xverbose-phases=linker")

    main.cinterops.create("kotlinCefInterop") {
      defFile("src/nativeInterop/cinterop/kotlinCefInterop.def")
      packageName = "org.jonnyzzz.example"
      compilerOpts += "-I${project(":cpp").file("src/main/public")}"
    }
  }
}
