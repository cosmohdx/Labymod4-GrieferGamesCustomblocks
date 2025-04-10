plugins {
    id("net.labymod.labygradle")
    id("net.labymod.labygradle.addon")
}

val versions = providers.gradleProperty("net.labymod.minecraft-versions").get().split(";")
group = "net.griefergames"
version = "1.1.0"

java.toolchain.languageVersion.set(JavaLanguageVersion.of(21))

labyMod {
    defaultPackageName = "net.griefergames.customblocks" //change this to your main package name (used by all modules) xx
    addonInfo {
        namespace = "customblocks"
        displayName = "GrieferGames CustomBlocks"
        author = "GrieferGames CosmoHDx"
        description = "Provides CustomBlocks for GrieferGames via LabyMod Fabric."
        minecraftVersion = "1.20.1,1.20.4,1.21.1,1.21.4" //"1.20<*"
        version = System.getenv().getOrDefault("VERSION", project.version.toString())
        iconUrl = "textures/icon.png"
//        addonDependencies = mutableListOf(
//                AddonDependency("labyfabric", false)
//        )
//        metas = mutableListOf(
//                AddonMeta.RESTART_REQUIRED
//        )
    }

    minecraft {
        registerVersion(versions.toTypedArray()) {
            runs {
                getByName("client") {
                    // When the property is set to true, you can log in with a Minecraft account
                    // devLogin = true
                }
            }
        }
    }
}

subprojects {
    plugins.apply("java-library")
    plugins.apply("net.labymod.labygradle")
    plugins.apply("net.labymod.labygradle.addon")

    repositories {
        maven("https://libraries.minecraft.net/")
        maven("https://repo.spongepowered.org/repository/maven-public/")
    }
    group = rootProject.group
    version = rootProject.version
}