package com.gtlugo.ampere

verifyConstants()

plugins {
  idea
  java
  `java-library`
  kotlin("jvm")
  `maven-publish`
  net.neoforged.moddev
  com.gradleup.shadow
}

repositories {
  mavenLocal()
  mavenCentral()
  gradlePluginPortal()
}

dependencies {
  implementation("com.gtlugo.ampere:shared:unspecified")
}

java.toolchain.languageVersion = JavaLanguageVersion.of(21)

version = Constants.Ampere.VERSION

base {
  archivesName = Constants.Ampere.ID
}

neoForge {
  version = Constants.NeoForge.VERSION

  parchment {
    mappingsVersion = Constants.Parchment.MAPPINGS_VERSION
    minecraftVersion = Constants.Parchment.MINECRAFT_VERSION
  }

  runs {
    create("client") {
      client()
      systemProperty("neoforge.enabledGameTestNamespaces", Constants.Ampere.ID)
    }

    create("server") {
      server()
      programArgument("--nogui")
      systemProperty("neoforge.enabledGameTestNamespaces", Constants.Ampere.ID)
    }

    create("gameTestServer") {
      type = "gameTestServer"
      systemProperty("neoforge.enabledGameTestNamespaces", Constants.Ampere.ID)
    }

    create("data") {
      data()
      programArguments.addAll(
        "--mod",
        Constants.Ampere.ID,
        "--all",
        "--output",
        file("src/generated/resources/").absolutePath,
        "--existing",
        file("src/main/resources/").absolutePath
      )
    }

    // applies to all the run configs above
    configureEach {
      // Recommended logging data for a userdev environment
      // The markers can be added/removed as needed separated by commas.
      // \`SCAN\`: For mods scan.
      // \`REGISTRIES\`: For firing of registry events.
      // \`REGISTRYDUMP\`: For getting the contents of all registries.
      systemProperty("forge.logging.markers", "REGISTRIES")
      // Recommended logging level for the console
      // You can set various levels here.
      // Please read: https://stackoverflow.com/questions/2031163/when-to-use-the-different-log-levels
      logLevel = org.slf4j.event.Level.DEBUG
    }
  }

  mods {
    // define mod <-> source bindings
    // these are used to tell the game which sources are for which mod
    // multi mod projects should define one per mod
    create(Constants.Ampere.ID) {
      sourceSet(sourceSets.main.get())
    }
  }
}

var generateModMetadata = tasks.register<ProcessResources>("generateModMetadata") {
  val replaceProperties = mapOf<String, String>(
    "minecraft_version"       to Constants.Minecraft.VERSION,
    "minecraft_version_range" to Constants.Minecraft.VERSION_RANGE,
    "neo_version"             to Constants.NeoForge.VERSION,
    "neo_version_range"       to Constants.NeoForge.VERSION_RANGE,
    "loader_version_range"    to Constants.NeoForge.LOADER_VERSION,
    "mod_id"                  to Constants.Ampere.ID,
    "mod_name"                to Constants.Ampere.DISPLAY_NAME,
    "mod_license"             to Constants.Ampere.LICENSE,
    "mod_version"             to Constants.Ampere.VERSION,
    "mod_authors"             to Constants.Ampere.AUTHORS,
    "mod_description"         to Constants.Ampere.DESCRIPTION,
    "mod_repo"                to Constants.Ampere.REPO
  )
  inputs.properties(replaceProperties)
  expand(replaceProperties)
  from("src/main/templates")
  into("build/generated/sources/modMetadata")
}

sourceSets.main.get().resources {
  srcDir("src/generated/resources")
}
sourceSets.main.get().resources.srcDir(generateModMetadata)
//sourceSets.main.get().java.srcDir("../Constants/src/main/kotlin")
neoForge.ideSyncTask(generateModMetadata)

val localRuntime: Configuration? by configurations.creating

configurations.runtimeClasspath {
  extendsFrom(localRuntime)
}

publishing {
  publications {
    register<MavenPublication>("mavenJava") {
      from(components["java"])
    }
  }

  repositories {
    maven {
      name = "GitHubPackages"
      url = uri(Constants.Ampere.PACKAGE)
      credentials {
        username = System.getenv("GITHUB_ACTOR")
        password = System.getenv("GITHUB_TOKEN")
      }
    }
  }
}

configurations.shadow {
  isCanBeConsumed = false
  isCanBeResolved = true
}

idea {
  module {
    isDownloadSources = true
    isDownloadJavadoc = true
  }
}
