package com.bespectacled.customspawn.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import net.minecraft.entity.SpawnGroup;

@Config(name = "customspawn")
public class CustomSpawnConfig implements ConfigData {
    
    @ConfigEntry.Gui.PrefixText
    @ConfigEntry.Category(value = "general")
    public int chunkConstant = 17;
    
    @ConfigEntry.Category(value = "general")
    public long passiveTicksToWait = 400L;
    
    @ConfigEntry.Category(value = "general")
    @ConfigEntry.Gui.Tooltip(count = 2)
    public boolean hostileSpawning1_18 = false;

    @ConfigEntry.Gui.PrefixText
    @ConfigEntry.Category(value = "mobCaps")
    public int passiveCap = SpawnGroup.CREATURE.getCapacity();
    
    @ConfigEntry.Category(value = "mobCaps")
    public int hostileCap = SpawnGroup.MONSTER.getCapacity();
    
    @ConfigEntry.Category(value = "mobCaps")
    public int ambientCap = SpawnGroup.AMBIENT.getCapacity();
    
    @ConfigEntry.Category(value = "mobCaps")
    public int waterCap = SpawnGroup.WATER_CREATURE.getCapacity();
    
    @ConfigEntry.Category(value = "mobCaps")
    public int waterAmbientCap = SpawnGroup.WATER_AMBIENT.getCapacity();
    
    @ConfigEntry.Category(value = "persistence")
    public boolean passivePersistent = true;
    
    @ConfigEntry.Category(value = "persistence")
    public boolean hostilePersistent = false;
    
    @ConfigEntry.Category(value = "persistence")
    public boolean ambientPersistent = false;
    
    @ConfigEntry.Category(value = "persistence")
    public boolean waterPersistent = false;
    
    @ConfigEntry.Category(value = "spawners")
    public boolean overrideSpawnerDefaultValues = false;
    
    @ConfigEntry.Category(value = "spawners")
    public int minSpawnDelay = 200;
    
    @ConfigEntry.Category(value = "spawners")
    public int maxSpawnDelay = 800;
    
    @ConfigEntry.Category(value = "spawners")
    public int spawnCount = 4;
    
    @ConfigEntry.Category(value = "spawners")
    public int maxNearbyEntities = 6;
    
    @ConfigEntry.Category(value = "spawners")
    public int requiredPlayerRange = 16;
    
    @ConfigEntry.Category(value = "spawners")
    public int spawnRange = 4;
    
}
