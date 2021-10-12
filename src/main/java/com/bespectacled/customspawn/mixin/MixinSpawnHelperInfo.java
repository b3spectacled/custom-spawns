package com.bespectacled.customspawn.mixin;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.bespectacled.customspawn.CustomSpawn;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.SpawnHelper;

@Mixin(value = SpawnHelper.Info.class, priority = 999)
public abstract class MixinSpawnHelperInfo {
    @Unique private static final Map<SpawnGroup, Supplier<Integer>> SPAWN_CAPS = new HashMap<>();
    
    @Shadow private int spawningChunkCount;
    @Shadow private Object2IntOpenHashMap<SpawnGroup> groupToCount;
    
    @Inject(method = "isBelowCap", at = @At("HEAD"), cancellable = true)
    private void injectIsBelowCap(SpawnGroup spawnGroup, CallbackInfoReturnable<Boolean> info) {
        int cap = spawnGroup.getCapacity() * this.spawningChunkCount / (int)Math.pow(CustomSpawn.SPAWNS_CONFIG.chunkConstant, 2.0);
        
        info.setReturnValue(this.groupToCount.getInt(spawnGroup) < cap);
    }
}
