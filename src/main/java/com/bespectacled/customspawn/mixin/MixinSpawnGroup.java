package com.bespectacled.customspawn.mixin;

import java.util.HashMap;
import java.util.Map;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.bespectacled.customspawn.CustomSpawn;
import com.bespectacled.customspawn.config.CustomSpawnConfig.CustomSpawnGroup;

import net.minecraft.entity.SpawnGroup;

@Mixin(SpawnGroup.class)
public class MixinSpawnGroup {
    @Unique private static final Map<String, CustomSpawnGroup> CUSTOM_SPAWN_GROUPS;
    
    @Shadow @Final private String name;
    
    @Inject(method = "getCapacity", at = @At("HEAD"), cancellable = true)
    private void injectGetCapacity(CallbackInfoReturnable<Integer> info) {
        CustomSpawnGroup spawnGroup = CUSTOM_SPAWN_GROUPS.get(this.name);
        if (spawnGroup == null)
            return;
            
        info.setReturnValue(spawnGroup.capacity);
    }
    
    @Inject(method = "isPeaceful", at = @At("HEAD"), cancellable = true)
    private void injectIsPeaceful(CallbackInfoReturnable<Boolean> info) {
        CustomSpawnGroup spawnGroup = CUSTOM_SPAWN_GROUPS.get(this.name);
        if (spawnGroup == null)
            return;
        
        info.setReturnValue(spawnGroup.peaceful);
    }
    
    @Inject(method = "isRare", at = @At("HEAD"), cancellable = true)
    private void injectIsRare(CallbackInfoReturnable<Boolean> info) {
        CustomSpawnGroup spawnGroup = CUSTOM_SPAWN_GROUPS.get(this.name);
        if (spawnGroup == null)
            return;
        
        info.setReturnValue(spawnGroup.rare);
    }
    
    @Inject(method = "getImmediateDespawnRange", at = @At("HEAD"), cancellable = true)
    private void injectGetImmediateDespawnRange(CallbackInfoReturnable<Integer> info) {
        CustomSpawnGroup spawnGroup = CUSTOM_SPAWN_GROUPS.get(this.name);
        if (spawnGroup == null)
            return;
        
        info.setReturnValue(spawnGroup.immediateDespawnRange);
    }
    
    @Inject(method = "getDespawnStartRange", at = @At("HEAD"), cancellable = true)
    private void injectGetDespawnStartRange(CallbackInfoReturnable<Integer> info) {
        CustomSpawnGroup spawnGroup = CUSTOM_SPAWN_GROUPS.get(this.name);
        if (spawnGroup == null)
            return;
        
        info.setReturnValue(spawnGroup.despawnStartRange);
    }
    
    @Unique
    private CustomSpawnGroup getCustomSpawnGroup(String name) {
        return CUSTOM_SPAWN_GROUPS.get(name);
    }
    
    static {
        CUSTOM_SPAWN_GROUPS = new HashMap<>();
        
        CUSTOM_SPAWN_GROUPS.put(SpawnGroup.MONSTER.getName(), CustomSpawn.SPAWNS_CONFIG.monsterGroup);
        CUSTOM_SPAWN_GROUPS.put(SpawnGroup.CREATURE.getName(), CustomSpawn.SPAWNS_CONFIG.creatureGroup);
        CUSTOM_SPAWN_GROUPS.put(SpawnGroup.AMBIENT.getName(), CustomSpawn.SPAWNS_CONFIG.ambientGroup);
        CUSTOM_SPAWN_GROUPS.put(SpawnGroup.WATER_CREATURE.getName(), CustomSpawn.SPAWNS_CONFIG.waterCreatureGroup);
        CUSTOM_SPAWN_GROUPS.put(SpawnGroup.WATER_AMBIENT.getName(), CustomSpawn.SPAWNS_CONFIG.waterAmbientGroup);
        CUSTOM_SPAWN_GROUPS.put(SpawnGroup.UNDERGROUND_WATER_CREATURE.getName(), CustomSpawn.SPAWNS_CONFIG.waterCreatureGroup);
    }
}
