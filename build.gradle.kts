import net.minecrell.pluginyml.bukkit.BukkitPluginDescription

plugins {
    kotlin("jvm") version "1.9.20"
    id("io.papermc.paperweight.userdev") version "1.5.9"
    id("xyz.jpenilla.run-paper") version "1.1.0"
    id("net.minecrell.plugin-yml.paper") version "0.6.0"
}

group = "de.miraculixx"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    paperweight.paperDevBundle("1.20.2-R0.1-SNAPSHOT")
    library(kotlin("stdlib"))
}

kotlin {
    jvmToolchain(17)
}

paper {
    name = "DataPackLoader"
    version = "1.0.0"
    description = "Loads pre configured data packs into the world"
    website = "https://mutils.net"
    author = "Miraculixx"

    main = "de.miraculixx.datapackloader.DataPackLoader"

    // Generate paper-libraries.json from `library` and `paperLibrary` in `dependencies`
    generateLibrariesJson = true

    foliaSupported = true
    apiVersion = "1.19"

    load = BukkitPluginDescription.PluginLoadOrder.STARTUP
}