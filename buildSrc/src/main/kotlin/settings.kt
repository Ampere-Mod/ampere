object Ampere {
  const val VERSION = "0.1.0-alpha.10"
  const val ID = "ampere"
  const val DISPLAY_NAME = "Ampere"
  const val GROUP = "com.gtlugo.ampere"
  const val REPO = "https://github.com/Ampere-Mod/ampere"
}

object Parchment {
  const val MINECRAFT_VERSION = "1.21.1"
  const val MAPPINGS_VERSION = "2024.11.17"
}

object Minecraft {
  const val VERSION = "21.1"
  const val VERSION_RANGE = "[1.21.1]"
}

object NeoForge {
  const val VERSION = "21.1.133"
  const val VERSION_RANGE = "[21.1.133,)"
  const val LOADER_VERSION = "[1,)"
}

object NeoGradle {
  const val VERSION = "2.0.80"
}

fun verifySettings() {
  // TODO: Implement string parsing for verification. This is very simple, I just can't be bothered to do it right now.

  //  if (Minecraft.VERSION != NeoForge.VERSION) {
  //    throw GradleException("Minecraft version and NeoForge version must match.")
  //  }
}
