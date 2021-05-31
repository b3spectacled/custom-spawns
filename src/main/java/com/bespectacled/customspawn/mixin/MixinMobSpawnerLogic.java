package com.bespectacled.customspawn.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.bespectacled.customspawn.CustomSpawn;

import net.minecraft.world.MobSpawnerLogic;

@Mixin(MobSpawnerLogic.class)
public class MixinMobSpawnerLogic {
    @Unique private static final int DEFAULT_MIN_SPAWN_DELAY = 200;
    @Unique private static final int DEFAULT_MAX_SPAWN_DELAY = 800;
    @Unique private static final int DEFAULT_SPAWN_COUNT = 4;
    @Unique private static final int DEFAULT_MAX_NEARBY_ENTITIES = 6;
    @Unique private static final int DEFAULT_REQUIRED_PLAYER_RANGE = 16;
    @Unique private static final int DEFAULT_SPAWN_RANGE = 4;
    
    @Shadow private int minSpawnDelay;
    @Shadow private int maxSpawnDelay;
    @Shadow private int spawnCount;
    @Shadow private int maxNearbyEntities;
    @Shadow private int requiredPlayerRange;
    @Shadow private int spawnRange;
    
    @Inject(method = "serverTick", at = @At("HEAD")) 
    private void injectUpdate(CallbackInfo info) {
        if (CustomSpawn.SPAWNS_CONFIG.overrideSpawnerDefaultValues) {
            this.minSpawnDelay = CustomSpawn.SPAWNS_CONFIG.minSpawnDelay;
            this.maxSpawnDelay = CustomSpawn.SPAWNS_CONFIG.maxSpawnDelay;
            this.spawnCount = CustomSpawn.SPAWNS_CONFIG.spawnCount;
            this.maxNearbyEntities = CustomSpawn.SPAWNS_CONFIG.maxNearbyEntities;
            this.requiredPlayerRange = CustomSpawn.SPAWNS_CONFIG.requiredPlayerRange;
            this.spawnRange = CustomSpawn.SPAWNS_CONFIG.spawnRange;
        } else {
            this.minSpawnDelay = DEFAULT_MIN_SPAWN_DELAY;
            this.maxSpawnDelay = DEFAULT_MAX_SPAWN_DELAY;
            this.spawnCount = DEFAULT_SPAWN_COUNT;
            this.maxNearbyEntities = DEFAULT_MAX_NEARBY_ENTITIES;
            this.requiredPlayerRange = DEFAULT_REQUIRED_PLAYER_RANGE;
            this.spawnRange = DEFAULT_SPAWN_RANGE;
        }
    }
}
