package com.bespectacled.customspawn.config;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;
import net.minecraft.entity.SpawnGroup;

@Config(name = "customspawn")
public class CustomSpawnConfig implements ConfigData {
    
    @ConfigEntry.Gui.PrefixText
    @ConfigEntry.Category(value = "general")
    public int chunkConstant = 17;
    
    @ConfigEntry.Category(value = "general")
    public long passiveTicksToWait = 400L;

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
}
