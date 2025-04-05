plugins {
  com.gtlugo.ampere.conventions
}

group = "${Ampere.GROUP}.core"

dependencies {
  implementation(project(":api"))
}
