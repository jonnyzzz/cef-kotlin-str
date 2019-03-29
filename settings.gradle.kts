pluginManagement {
  repositories {
    gradlePluginPortal()

    maven(url="https://dl.bintray.com/kotlin/kotlin-eap")
  }
}

include("kn")
include("kn2")
include("cpp")
include("base")

