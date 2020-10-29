package com.bespectacled.customspawn.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import com.bespectacled.customspawn.CustomSpawn;

import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.HorseBaseEntity;

@Mixin(HorseBaseEntity.class)
public class MixinHorseBaseEntity extends MobEntity {
    @Shadow
    private static TrackedData<Byte> HORSE_FLAGS;
    
    protected MixinHorseBaseEntity() {
        super(null, null);
    }
    
    @Shadow
    protected boolean getHorseFlag(int integer) {
        return (this.dataTracker.<Byte>get(HORSE_FLAGS) & integer) != 0x0;
    }
    
    @Shadow
    public boolean isSaddled() {
        return this.getHorseFlag(4);
    }

    @Override
    public boolean canImmediatelyDespawn(double distance) {
        return !(CustomSpawn.SPAWNS_CONFIG.passivePersistent || this.isSaddled());
    }
    
}
