package com.bespectacled.customspawn;

import org.slf4j.event.Level;

import com.bespectacled.customspawn.config.CustomSpawnConfig;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.SpawnSettings;

public class CustomSpawnModifications {
    public static void modifySpawns() {
        CustomSpawnConfig config = CustomSpawn.SPAWNS_CONFIG;
        
        config.mobSpawnAdditions.forEach(addition -> {
            BiomeModifications
                .create(CustomSpawn.createId(Integer.toString(addition.hashCode())))
                .add(
                    ModificationPhase.ADDITIONS,
                    BiomeSelectors.includeByKey(biomeKey(addition.biomeId)),
                    context -> {
                        CustomSpawn.log(Level.INFO, String.format(
                            "Adding mob '%s' to biome '%s', to group '%s' with weight %d, min count %d, and max count %d",
                            addition.mobId,
                            addition.biomeId,
                            addition.spawnGroup.asString(),
                            addition.weight,
                            addition.minCount,
                            addition.maxCount
                        ));
                        
                        context.getSpawnSettings().addSpawn(
                            addition.spawnGroup,
                            new SpawnSettings.SpawnEntry(
                                Registries.ENTITY_TYPE.get(entityKey(addition.mobId)),
                                addition.weight,
                                addition.minCount,
                                addition.maxCount
                            )
                        );
                    }
                );
        });
        
        config.mobSpawnRemovals.forEach(removal -> {
            BiomeModifications
                .create(CustomSpawn.createId(Integer.toString(removal.hashCode())))
                .add(
                    ModificationPhase.REMOVALS,
                    BiomeSelectors.includeByKey(biomeKey(removal.biomeId)),
                    context -> {
                        CustomSpawn.log(Level.INFO, String.format(
                            "Removing mob '%s' from biome '%s'",
                            removal.mobId,
                            removal.biomeId
                        ));
                        
                        context.getSpawnSettings().removeSpawnsOfEntityType(
                            Registries.ENTITY_TYPE.get(entityKey(removal.mobId))
                        );
                    }
                );
        });
        
        config.mobSpawnReplacements.forEach(replacement -> {
            BiomeModifications
                .create(CustomSpawn.createId(Integer.toString(replacement.hashCode())))
                .add(
                    ModificationPhase.REPLACEMENTS,
                    BiomeSelectors.includeByKey(biomeKey(replacement.biomeId)),
                    context -> {
                        CustomSpawn.log(Level.INFO, String.format(
                            "Replacing mob '%s' from biome '%s', with mob '%s', to group '%s' with weight '%d', min count '%d', and max count '%d'",
                            replacement.originalMobId,
                            replacement.biomeId,
                            replacement.replacementMobId,
                            replacement.replacementSpawnGroup.asString(),
                            replacement.replacementWeight,
                            replacement.replacementMinCount,
                            replacement.replacementMaxCount
                        ));
                        
                        context.getSpawnSettings().removeSpawnsOfEntityType(
                            Registries.ENTITY_TYPE.get(entityKey(replacement.originalMobId))
                        );
                        
                        context.getSpawnSettings().addSpawn(
                            replacement.replacementSpawnGroup,
                            new SpawnSettings.SpawnEntry(
                                Registries.ENTITY_TYPE.get(entityKey(replacement.replacementMobId)),
                                replacement.replacementWeight,
                                replacement.replacementMinCount,
                                replacement.replacementMaxCount
                            )
                        );
                    }
                );
        });
    }
    
    private static RegistryKey<Biome> biomeKey(String id) {
        return RegistryKey.of(RegistryKeys.BIOME, new Identifier(id));
    }
    
    private static RegistryKey<EntityType<?>> entityKey(String id) {
        return RegistryKey.of(RegistryKeys.ENTITY_TYPE, new Identifier(id));
    }
}
