package com.gtlugo.ampere

object Constants {
  object Ampere {
    const val VERSION = "0.1.0-alpha.10"
    const val ID = "ampere"
    const val DISPLAY_NAME = "Ampere"
    const val GROUP = "com.gtlugo.ampere"
    const val LICENSE = "MIT"
    const val AUTHORS = "GTLugo"
    const val DESCRIPTION = "Create power grids to electrify your world."
    const val REPO = "https://github.com/Ampere-Mod/ampere"
    const val PACKAGE = "https://maven.pkg.github.com/Ampere-Mod/ampere"
  }

  object Parchment {
    const val MINECRAFT_VERSION = "1.21.1"
    const val MAPPINGS_VERSION = "2024.11.17"
  }

  object Minecraft {
    const val VERSION = "1.21.1"
    const val VERSION_RANGE = "[1.21.1]"
  }

  object NeoForge {
    const val VERSION = "21.1.133"
    const val VERSION_RANGE = "[21.1.133,)"
    const val LOADER_VERSION = "[1,)"
  }
}

fun verifyConstants() {
  // TODO: Implement string parsing for verification. This is very simple, I just can't be bothered to do it right now.

  //  if (Minecraft.VERSION != NeoForge.VERSION) {
  //    throw GradleException("Minecraft version and NeoForge version must match.")
  //  }
}

fun ampereGroup(subdomain: String): String {
  return "${Constants.Ampere.GROUP}.${subdomain}"
}
