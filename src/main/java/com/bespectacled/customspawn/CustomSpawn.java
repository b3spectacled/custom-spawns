package com.bespectacled.customspawn;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bespectacled.customspawn.config.CustomSpawnConfig;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.GsonConfigSerializer;

import com.bespectacled.customspawn.client.GoVote;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class CustomSpawn implements ModInitializer {
    public static final String ID = "custom_stars";
    public static final Logger LOGGER = LogManager.getLogger("CustomStars");
    public static final CustomSpawnConfig SPAWNS_CONFIG = AutoConfig
            .register(CustomSpawnConfig.class, GsonConfigSerializer::new).getConfig();

    @Override
    public void onInitialize() {
        LOGGER.log(Level.INFO, "Initializing Custom Spawns...");

        if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
            GoVote.init();
        }

        LOGGER.log(Level.INFO, "Initialized Custom Spawns!");
    }
}
