package com.bespectacled.customspawn.mixin.entity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.bespectacled.customspawn.CustomSpawn;

import net.minecraft.entity.passive.AnimalEntity;

@Mixin(AnimalEntity.class)
public class MixinAnimalEntity {
    @Inject(method = "canImmediatelyDespawn", at = @At("HEAD"), cancellable = true)
    private void injectDespawn(double distance, CallbackInfoReturnable<Boolean> info) {
        info.setReturnValue(!CustomSpawn.SPAWNS_CONFIG.passivePersistent);
    }
}
