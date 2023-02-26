package mod.bespectacled.customspawn.config;

import java.util.List;

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
    public long rareSpawnTicksToWait = 400L;
    
    @ConfigEntry.Category(value = "mobGroups")
    @ConfigEntry.Gui.CollapsibleObject
    public CustomSpawnGroup monsterGroup = new CustomSpawnGroup(70, false, false, 128, 32);
    
    @ConfigEntry.Category(value = "mobGroups")
    @ConfigEntry.Gui.CollapsibleObject
    public CustomSpawnGroup creatureGroup = new CustomSpawnGroup(10, true, true, 128, 32);
    
    @ConfigEntry.Category(value = "mobGroups")
    @ConfigEntry.Gui.CollapsibleObject
    public CustomSpawnGroup ambientGroup = new CustomSpawnGroup(15, true, false, 128, 32);
    
    @ConfigEntry.Category(value = "mobGroups")
    @ConfigEntry.Gui.CollapsibleObject
    public CustomSpawnGroup axolotlGroup = new CustomSpawnGroup(5, true, false, 128, 32);
    
    @ConfigEntry.Category(value = "mobGroups")
    @ConfigEntry.Gui.CollapsibleObject
    public CustomSpawnGroup waterCreatureGroup = new CustomSpawnGroup(5, true, false, 128, 32);
    
    @ConfigEntry.Category(value = "mobGroups")
    @ConfigEntry.Gui.CollapsibleObject
    public CustomSpawnGroup waterAmbientGroup = new CustomSpawnGroup(20, true, false, 64, 32);
    
    @ConfigEntry.Category(value = "mobGroups")
    @ConfigEntry.Gui.CollapsibleObject
    public CustomSpawnGroup undergroundWaterGroup = new CustomSpawnGroup(5, true, false, 128, 32);
    
    @ConfigEntry.Category(value = "persistence")
    public boolean passivePersistent = true;
    
    @ConfigEntry.Category(value = "persistence")
    public boolean hostilePersistent = false;
    
    @ConfigEntry.Category(value = "persistence")
    public boolean ambientPersistent = false;
    
    @ConfigEntry.Category(value = "persistence")
    public boolean waterPersistent = false;
    
    @ConfigEntry.Gui.PrefixText
    @ConfigEntry.Category(value = "mobSpawnAdditions")
    public List<CustomSpawnAddition> mobSpawnAdditions = List.of();
    
    @ConfigEntry.Gui.PrefixText
    @ConfigEntry.Category(value = "mobSpawnRemovals")
    public List<CustomSpawnRemoval> mobSpawnRemovals = List.of();
    
    @ConfigEntry.Gui.PrefixText
    @ConfigEntry.Category(value = "mobSpawnReplacements")
    public List<CustomSpawnReplacement> mobSpawnReplacements = List.of();
    
    @ConfigEntry.Gui.PrefixText
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
    
    public static class CustomSpawnGroup {
        public int capacity;
        public boolean peaceful;
        public boolean rare;
        public int immediateDespawnRange;
        public int despawnStartRange;
        
        public CustomSpawnGroup(
            int capacity, 
            boolean peaceful, 
            boolean rare, 
            int immediateDespawnRange, 
            int despawnStartRange
        ) {
            this.capacity = capacity;
            this.peaceful = peaceful;
            this.rare = rare;
            this.immediateDespawnRange = immediateDespawnRange;
            this.despawnStartRange = despawnStartRange;
        }
    }
    
    public static class CustomSpawnAddition {
        public String biomeId;
        public String biomeTag;
        public String mobId;
        public SpawnGroup spawnGroup;
        public int weight;
        public int minCount;
        public int maxCount;
        
        public CustomSpawnAddition() {
            this.biomeId = "minecraft:plains";
            this.biomeTag = "";
            this.mobId = "minecraft:pig";
            this.spawnGroup = SpawnGroup.CREATURE;
            this.weight = 10;
            this.minCount = 4;
            this.maxCount = 4;
        }
    }
    
    public static class CustomSpawnRemoval {
        public String biomeId;
        public String biomeTag;
        public String mobId;
        
        public CustomSpawnRemoval() {
            this.biomeId = "minecraft:plains";
            this.biomeTag = "";
            this.mobId = "minecraft:pig";
        }
    }
    
    public static class CustomSpawnReplacement {
        public String biomeId;
        public String biomeTag;
        public String originalMobId;
        
        public String replacementMobId;
        public SpawnGroup replacementSpawnGroup;
        public int replacementWeight;
        public int replacementMinCount;
        public int replacementMaxCount;
        
        public CustomSpawnReplacement() {
            this.biomeId = "minecraft:plains";
            this.biomeTag = "";
            this.originalMobId = "minecraft:pig";
            
            this.replacementMobId = "minecraft:pig";
            this.replacementSpawnGroup = SpawnGroup.CREATURE;
            this.replacementWeight = 10;
            this.replacementMinCount = 4;
            this.replacementMaxCount = 4;
        }
    }
}
