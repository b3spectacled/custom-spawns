package com.bespectacled.customspawn.config;

import io.github.prospector.modmenu.api.ConfigScreenFactory;
import io.github.prospector.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.client.gui.screen.Screen;

public class CustomSpawnModMenu implements ModMenuApi {
    @Override
    public String getModId() {
        return "customspawn";
    }

    @Override
    public ConfigScreenFactory<Screen> getModConfigScreenFactory() {
        return screen -> AutoConfig.getConfigScreen(CustomSpawnConfig.class, screen).get();
    }
}
