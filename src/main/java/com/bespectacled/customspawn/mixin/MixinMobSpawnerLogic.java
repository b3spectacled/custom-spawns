package com.bespectacled.customspawn.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.bespectacled.customspawn.CustomSpawn;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.MobSpawnerLogic;
import net.minecraft.world.World;

@Mixin(MobSpawnerLogic.class)
public class MixinMobSpawnerLogic {
    @Shadow private int minSpawnDelay;
    @Shadow private int maxSpawnDelay;
    @Shadow private int spawnCount;
    @Shadow private int maxNearbyEntities;
    @Shadow private int requiredPlayerRange;
    @Shadow private int spawnRange;
    
    @Inject(method = "readNbt", at = @At("TAIL")) 
    private void injectReadNbt(World world, BlockPos pos, NbtCompound nbt, CallbackInfo info) {
        if (CustomSpawn.SPAWNS_CONFIG.overrideSpawnerDefaultValues) {
            this.minSpawnDelay = CustomSpawn.SPAWNS_CONFIG.minSpawnDelay;
            this.maxSpawnDelay = CustomSpawn.SPAWNS_CONFIG.maxSpawnDelay;
            this.spawnCount = CustomSpawn.SPAWNS_CONFIG.spawnCount;
            this.maxNearbyEntities = CustomSpawn.SPAWNS_CONFIG.maxNearbyEntities;
            this.requiredPlayerRange = CustomSpawn.SPAWNS_CONFIG.requiredPlayerRange;
            this.spawnRange = CustomSpawn.SPAWNS_CONFIG.spawnRange;
        }
    }
}
