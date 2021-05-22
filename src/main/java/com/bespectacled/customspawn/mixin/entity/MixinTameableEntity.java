package com.bespectacled.customspawn.mixin.entity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import com.bespectacled.customspawn.CustomSpawn;

import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.TameableEntity;

@Mixin(TameableEntity.class)
public class MixinTameableEntity extends MobEntity {
    @Shadow
    private static TrackedData<Byte> TAMEABLE_FLAGS;
    
    protected MixinTameableEntity() {
        super(null, null);
    }
    
    @Shadow
    public boolean isTamed() {
        return ((Byte)this.dataTracker.get(TAMEABLE_FLAGS) & 4) != 0;
    }

    @Override
    public boolean canImmediatelyDespawn(double distance) {
        return !(CustomSpawn.SPAWNS_CONFIG.passivePersistent || this.isTamed());
    }
    
}
