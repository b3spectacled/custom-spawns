package mod.bespectacled.customspawn.mixin.entity;

import org.spongepowered.asm.mixin.Mixin;

import mod.bespectacled.customspawn.CustomSpawn;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;

@Mixin(HostileEntity.class)
public abstract class MixinHostileEntity extends MobEntity {
    protected MixinHostileEntity() {
        super(null, null);
    }

    @Override
    public boolean canImmediatelyDespawn(double distance) {
        return !CustomSpawn.SPAWNS_CONFIG.hostilePersistent;
    }
}
