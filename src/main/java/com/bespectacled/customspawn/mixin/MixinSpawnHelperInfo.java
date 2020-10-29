package com.bespectacled.customspawn.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

import com.bespectacled.customspawn.CustomSpawn;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.SpawnHelper;

@Mixin(SpawnHelper.Info.class)
public abstract class MixinSpawnHelperInfo {
    @Shadow
    private int spawningChunkCount;
    
    @Shadow
    private Object2IntOpenHashMap<SpawnGroup> groupToCount;

    @Overwrite
    private boolean isBelowCap(SpawnGroup spawnGroup) {
        int cap = 
            getModifiedCap(spawnGroup) * 
            this.spawningChunkCount / (int)Math.pow(CustomSpawn.SPAWNS_CONFIG.chunkConstant, 2.0);
        return this.groupToCount.getInt(spawnGroup) < cap;
    }
    
    @Unique
    private int getModifiedCap(SpawnGroup group) {
        int modifiedCap = group.getCapacity();
        
        if (group == SpawnGroup.CREATURE)
            modifiedCap = CustomSpawn.SPAWNS_CONFIG.passiveCap;
        else if (group == SpawnGroup.MONSTER)
            modifiedCap = CustomSpawn.SPAWNS_CONFIG.hostileCap;
        else if (group == SpawnGroup.AMBIENT)
            modifiedCap = CustomSpawn.SPAWNS_CONFIG.ambientCap;
        else if (group == SpawnGroup.WATER_CREATURE)
            modifiedCap = CustomSpawn.SPAWNS_CONFIG.waterCap;
        else if (group == SpawnGroup.WATER_AMBIENT)
            modifiedCap = CustomSpawn.SPAWNS_CONFIG.waterAmbientCap;
        
        return modifiedCap;
    }

}
