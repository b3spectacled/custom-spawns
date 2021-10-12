package com.bespectacled.customspawn.mixin.entity;

import org.spongepowered.asm.mixin.Mixin;

import com.bespectacled.customspawn.CustomSpawn;

import net.minecraft.entity.mob.AmbientEntity;
import net.minecraft.entity.mob.MobEntity;

@Mixin(AmbientEntity.class)
public abstract class MixinAmbientEntity extends MobEntity {

    protected MixinAmbientEntity() {
        super(null, null);
    }

    @Override
    public boolean canImmediatelyDespawn(double distance) {
        return !CustomSpawn.SPAWNS_CONFIG.ambientPersistent;
    }
    
}
