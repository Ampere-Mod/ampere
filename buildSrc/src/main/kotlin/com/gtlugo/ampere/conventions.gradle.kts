package com.gtlugo.ampere

import verifySettings

verifySettings()

plugins {
  idea
  `java-library`
  `maven-publish`
  net.neoforged.moddev
}

java.toolchain.languageVersion = JavaLanguageVersion.of(21)
version = Ampere.VERSION

repositories {
  mavenLocal()
  gradlePluginPortal()
}

base {
  archivesName = Ampere.ID
}

neoForge {
  
}
