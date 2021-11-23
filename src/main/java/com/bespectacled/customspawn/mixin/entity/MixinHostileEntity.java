package com.bespectacled.customspawn.mixin.entity;

import java.util.Random;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.bespectacled.customspawn.CustomSpawn;

import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import net.minecraft.world.ServerWorldAccess;

@Mixin(HostileEntity.class)
public abstract class MixinHostileEntity extends MobEntity {
    protected MixinHostileEntity() {
        super(null, null);
    }

    @Override
    public boolean canImmediatelyDespawn(double distance) {
        return !CustomSpawn.SPAWNS_CONFIG.hostilePersistent;
    }
    
    @Inject(
        method = "isSpawnDark", 
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/ServerWorldAccess;toServerWorld()Lnet/minecraft/server/world/ServerWorld;"
        ), 
        cancellable = true
    )
    private static void injectIsSpawnDark(ServerWorldAccess world, BlockPos pos, Random random, CallbackInfoReturnable<Boolean> info) {
        if (world.getLightLevel(LightType.BLOCK, pos) > 0 && CustomSpawn.SPAWNS_CONFIG.hostileSpawning1_18) {
            info.setReturnValue(false);
        }
    }
    
}
