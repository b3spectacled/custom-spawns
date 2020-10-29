package com.bespectacled.customspawn.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.bespectacled.customspawn.CustomSpawn;

import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.nbt.CompoundTag;

@Mixin(AnimalEntity.class)
public class MixinAnimalEntity {
    
    @Inject(method = "canImmediatelyDespawn", at = @At("HEAD"), cancellable = true)
    private void injectDespawn(double distance, CallbackInfoReturnable info) {
        info.setReturnValue(!CustomSpawn.SPAWNS_CONFIG.passivePersistent);
    }
    

    
}
