
plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    compileOnly(kotlin("gradle-plugin", version = "1.3.21"))
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}


