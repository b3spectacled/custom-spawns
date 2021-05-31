package com.bespectacled.customspawn;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bespectacled.customspawn.config.CustomSpawnConfig;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;

public class CustomSpawn implements ModInitializer {
    public static final String MOD_ID = "custom_spawns";
    public static final Logger LOGGER = LogManager.getLogger("CustomSpawns");
    public static final CustomSpawnConfig SPAWNS_CONFIG = AutoConfig.register(CustomSpawnConfig.class, GsonConfigSerializer::new).getConfig();

    @Override
    public void onInitialize() {
        LOGGER.log(Level.INFO, "Initializing Custom Spawns...");
    }
}
