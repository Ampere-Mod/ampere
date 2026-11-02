package com.gtlugo.ampere.api;

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

@Mod(AmpereApi.MOD_ID)
public class AmpereApi {
  public static final String MOD_ID = "ampere_api";
  public static final Logger LOGGER = LogUtils.getLogger();

  public AmpereApi(IEventBus modEventBus, ModContainer modContainer) {
    modEventBus.addListener(this::commonSetup);

    NeoForge.EVENT_BUS.register(this);

    modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
  }

  private void commonSetup(FMLCommonSetupEvent event) {

  }

  @SubscribeEvent
  public void onServerStarting(ServerStartingEvent event) {

  }
}
