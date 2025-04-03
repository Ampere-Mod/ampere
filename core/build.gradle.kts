plugins {
  id("shared_build_conventions")
}

group = "${Ampere.GROUP}.core"
version = Ampere.VERSION

repositories {
  mavenCentral()
}

dependencies {
  implementation(project(":api"))
}
