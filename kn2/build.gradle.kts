
plugins {
  kotlin("multiplatform")
}

repositories {
  mavenCentral()
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
