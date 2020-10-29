package com.bespectacled.customspawn.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
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
    
    @Unique
    private boolean isSaddled() {
        return saddledComponent.isSaddled();
    }

    @Override
    public boolean canImmediatelyDespawn(double distance) {
        return !(CustomSpawn.SPAWNS_CONFIG.passivePersistent || this.isSaddled());
    }
    
}
