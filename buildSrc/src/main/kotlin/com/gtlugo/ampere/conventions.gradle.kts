package com.gtlugo.ampere

import verifySettings

verifySettings()

plugins {
  idea
  `java-library`
  `maven-publish`
  net.neoforged.moddev
}

repositories {
  mavenLocal()
  gradlePluginPortal()
}

java.toolchain.languageVersion = JavaLanguageVersion.of(21)

version = Ampere.VERSION

base {
  archivesName = Ampere.ID
}

neoForge {
  version = NeoForge.VERSION

  parchment {
    mappingsVersion = Parchment.MAPPINGS_VERSION
    minecraftVersion = Parchment.MINECRAFT_VERSION
  }

  runs {
    create("client") {
      client()
      systemProperty("neoforge.enabledGameTestNamespaces", Ampere.ID)
    }

    create("server") {
      server()
      programArgument("--nogui")
      systemProperty("neoforge.enabledGameTestNamespaces", Ampere.ID)
    }

    create("gameTestServer") {
      type = "gameTestServer"
      systemProperty("neoforge.enabledGameTestNamespaces", Ampere.ID)
    }

    create("data") {
      data()
      programArguments.addAll(
        "--mod",
        Ampere.ID,
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
    create(Ampere.ID) {
      sourceSet(sourceSets.main.get())
    }
  }
}


sourceSets.main.get().resources {
  srcDir("src/generated/resources")
}

var generateModMetadata = tasks.register<ProcessResources>("generateModMetadata") {
  val replaceProperties = mapOf<String, String>(
    "minecraft_version"       to Minecraft.VERSION,
    "minecraft_version_range" to Minecraft.VERSION_RANGE,
    "neo_version"             to NeoForge.VERSION,
    "neo_version_range"       to NeoForge.VERSION_RANGE,
    "loader_version_range"    to NeoForge.LOADER_VERSION,
    "mod_id"                  to Ampere.ID,
    "mod_name"                to Ampere.DISPLAY_NAME,
    "mod_license"             to Ampere.LICENSE,
    "mod_version"             to Ampere.VERSION,
    "mod_authors"             to Ampere.AUTHORS,
    "mod_description"         to Ampere.DESCRIPTION,
    "mod_repo"                to Ampere.REPO
  )
  inputs.properties(replaceProperties)
  expand(replaceProperties)
  from("src/main/templates")
  into("build/generated/sources/modMetadata")
}
sourceSets.main.get().resources.srcDir(generateModMetadata)
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
      url = uri(Ampere.PACKAGE)
      credentials {
        username = System.getenv("GITHUB_ACTOR")
        password = System.getenv("GITHUB_TOKEN")
      }
    }
  }
}

idea {
  module {
    isDownloadSources = true
    isDownloadJavadoc = true
  }
}
