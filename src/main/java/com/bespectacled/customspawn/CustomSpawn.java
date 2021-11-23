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
    public static final String MOD_NAME = "Custom Spawns";
    
    public static final CustomSpawnConfig SPAWNS_CONFIG = AutoConfig.register(CustomSpawnConfig.class, GsonConfigSerializer::new).getConfig();
    
    private static final Logger LOGGER = LogManager.getLogger("CustomSpawns");

    public static void log(Level level, String message) {
        LOGGER.log(level, "[" + MOD_NAME + "] {}", message);
    }
    
    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing Custom Spawns...");
    }
}
