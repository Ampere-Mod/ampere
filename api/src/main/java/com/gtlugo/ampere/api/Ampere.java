package com.gtlugo.ampere.api;

import com.gtlugo.ampere.Constants;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

@Mod(Ampere.MOD_ID)
public class Ampere {
  public static final String MOD_ID = Constants.Ampere.ID;
  private static final Logger LOGGER = LogUtils.getLogger();

  // The constructor for the mod class is the first code that is run when your mod is loaded.
  // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
  public Ampere(IEventBus modEventBus, ModContainer modContainer) {
    NeoForge.EVENT_BUS.register(this);
    modEventBus.addListener(this::commonSetup);

    modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
  }

  private void commonSetup(final FMLCommonSetupEvent event) {
    // Some common setup code
    LOGGER.info("Ampere Common Setup");
  }

  // You can use SubscribeEvent and let the Event Bus discover methods to call
  @SubscribeEvent
  public void onServerStarting(ServerStartingEvent event) {
    // Do something when the server starts
    LOGGER.info("Ampere Server Startup");
  }
}
