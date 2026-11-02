package com.gtlugo.ampere;

import com.gtlugo.ampere.api.PowerGrid;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

@Mod(Ampere.MOD_ID)
public class Ampere {
  public static final String MOD_ID = "ampere";
  public static final Logger LOGGER = LogUtils.getLogger();

  public Ampere(IEventBus modEventBus, ModContainer modContainer) {
    modEventBus.addListener(this::commonSetup);

    NeoForge.EVENT_BUS.register(this);

    modEventBus.addListener(this::addCreative);

    modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
  }

  private void commonSetup(FMLCommonSetupEvent event) {
    PowerGrid powerGrid; // Just a test
  }

  private void addCreative(BuildCreativeModeTabContentsEvent event) {

  }

  @SubscribeEvent
  public void onServerStarting(ServerStartingEvent event) {

  }
}
