package com.gtlugo.ampere;

import com.gtlugo.ampere.datagen.ModModelProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = Ampere.MOD_ID)
public class AmpereDataGen {
  @SubscribeEvent
  public static void gatherClientData(GatherDataEvent.Client event) {
    DataGenerator generator = event.getGenerator();
    PackOutput output = generator.getPackOutput();
    generator.addProvider(true, new ModModelProvider(output));
  }
}
