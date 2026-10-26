package com.gtlugo.ampere;

import com.gtlugo.ampere.items.ModItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(Ampere.MOD_ID)
public class Ampere {
  public static final String MOD_ID = "ampere";
  public static final Logger LOGGER = LogUtils.getLogger();

  public Ampere(IEventBus modEventBus, ModContainer modContainer) {
    modEventBus.addListener(this::commonSetup);
    ModItems.register(modEventBus);
    NeoForge.EVENT_BUS.register(this);
    modEventBus.addListener(this::addCreative);
    modContainer.registerConfig(ModConfig.Type.LOCAL, Config.SPEC);
  }

  private void commonSetup(FMLCommonSetupEvent event) {

  }

  private void addCreative(BuildCreativeModeTabContentsEvent event) {
    
  }

  @SubscribeEvent
  public void onServerStarting(ServerStartingEvent event) {

  }
}
