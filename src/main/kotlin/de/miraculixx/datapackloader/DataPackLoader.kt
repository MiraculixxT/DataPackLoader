package de.miraculixx.datapackloader

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import java.util.logging.Logger

class DataPackLoader: JavaPlugin() {
    private val logger = Logger.getLogger(this::class.java.name)
    private val packs: Set<String> = setOf()

    override fun onEnable() {
        val mainWorld = Bukkit.getWorlds().firstOrNull()
        if (mainWorld == null) {
            logger.warning("Failed to resolve main world! Data pack will not load automatically!")
            return
        }
        val worldFolder = File(mainWorld.worldFolder, "datapacks")
        if (!worldFolder.exists()) worldFolder.mkdir()

        packs.forEach { name ->
            val stream = javaClass.getResourceAsStream("datapacks/$name.zip")
            if (stream == null) {
                logger.warning("Failed to load data pack $name!")
                return@forEach
            }
            File(worldFolder, "$name.zip").writeBytes(stream.readAllBytes())
        }

        Bukkit.reloadData()
    }
}