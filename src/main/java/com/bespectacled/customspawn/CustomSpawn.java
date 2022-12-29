package com.bespectacled.customspawn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;

import com.bespectacled.customspawn.config.CustomSpawnConfig;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class CustomSpawn implements ModInitializer {
    public static final String MOD_ID = "custom_spawns";
    public static final String MOD_NAME = "Custom Spawns";
    
    public static final CustomSpawnConfig SPAWNS_CONFIG = AutoConfig.register(CustomSpawnConfig.class, GsonConfigSerializer::new).getConfig();
    
    private static final Logger LOGGER = LoggerFactory.getLogger("CustomSpawns");

    public static void log(Level level, String message) {
        message = String.format("[%s] %s", MOD_NAME, message);
        
        switch(level) {
            case DEBUG: LOGGER.debug(message);
            case ERROR: LOGGER.error(message);
            case WARN: LOGGER.warn(message);
            default: LOGGER.info(message);
        }
    }
    
    public static Identifier createId(String name) {
        return new Identifier(MOD_ID, name);
    }
    
    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing Custom Spawns...");
        
        // Add custom spawns
        CustomSpawnModifications.modifySpawns();
    }
}
