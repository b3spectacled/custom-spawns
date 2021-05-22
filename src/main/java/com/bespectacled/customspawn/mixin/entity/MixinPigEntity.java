package com.bespectacled.customspawn.mixin.entity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import com.bespectacled.customspawn.CustomSpawn;

import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.SaddledComponent;

@Mixin(PigEntity.class)
public class MixinPigEntity extends MobEntity {
    @Shadow
    private SaddledComponent saddledComponent;
    
    protected MixinPigEntity() {
        super(null, null);
    }

    @Override
    public boolean canImmediatelyDespawn(double distance) {
        return !(CustomSpawn.SPAWNS_CONFIG.passivePersistent || this.saddledComponent.isSaddled());
    }
    
}
