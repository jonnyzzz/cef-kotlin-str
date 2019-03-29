plugins {
  kotlin("multiplatform")
}

repositories {
  mavenCentral()
}

kotlin {
  macosX64 {
    val main by compilations

    binaries {
      executable {
        entryPoint = "org.jonnyzzz.example.main"
        linkerOpts.add("-ljonnyzzzcpp")
        linkerOpts.add("-L${project(":cpp").buildDir}/lib/main/${buildType.name.toLowerCase()}")

        linkTask.dependsOn(project(":cpp").tasks["link${buildType.name.toLowerCase().capitalize()}"])
      }
    }
  }

  sourceSets {
    val macosX64Main by getting {
      dependencies {
        implementation(project(":kn2"))
      }
    }
  }
}
