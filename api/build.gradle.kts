import com.gtlugo.ampere.*

plugins {
  com.gtlugo.ampere.conventions
}

group = ampereGroup("api")

dependencies {
  implementation("com.gtlugo.ampere:shared:unspecified")
}

//val copySettings by tasks.register<Copy>("copySettings") {
//  from("buildSrc/src/main/kotlin/${Ampere.GROUP}/Settings.kt")
//  into(layout.projectDirectory.dir("src/main/kotlin/${Ampere.GROUP}/api"))
//}
//
//// Make sure the file is copied before compilation happens
//tasks.compileKotlin {
//  dependsOn(copySettings)
//}
