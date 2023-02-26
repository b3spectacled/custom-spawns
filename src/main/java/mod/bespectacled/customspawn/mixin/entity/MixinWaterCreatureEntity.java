package mod.bespectacled.customspawn.mixin.entity;

import org.spongepowered.asm.mixin.Mixin;

import mod.bespectacled.customspawn.CustomSpawn;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.WaterCreatureEntity;

@Mixin(WaterCreatureEntity.class)
public abstract class MixinWaterCreatureEntity extends MobEntity {

    protected MixinWaterCreatureEntity() {
        super(null, null);
    }

    @Override
    public boolean canImmediatelyDespawn(double distance) {
        return !CustomSpawn.SPAWNS_CONFIG.waterPersistent;
    }
    
}
