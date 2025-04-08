import com.gtlugo.ampere.*

plugins {
  com.gtlugo.ampere.conventions
}

group = ampereGroup("core")

dependencies {
  implementation("com.gtlugo.ampere:shared:unspecified")
  implementation(project(":api"))
  shadow(project(":api"))
}
