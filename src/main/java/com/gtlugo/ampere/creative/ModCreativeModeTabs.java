package com.gtlugo.ampere.creative;

import com.gtlugo.ampere.Ampere;
import com.gtlugo.ampere.blocks.ModBlocks;
import com.gtlugo.ampere.items.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
  public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
      DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Ampere.MOD_ID);

  public static final Supplier<CreativeModeTab> AMPERE_TAB = CREATIVE_MODE_TABS.register(
    "ampere_tab", () -> CreativeModeTab.builder()
      .title(Component.translatable("ampere.creative_tab"))
      .icon(() -> new ItemStack(ModItems.ICON.get()))
      .displayItems((_, output) -> {
//        output.accept(ModItems.LONSDALEITE.get());
        output.accept(ModBlocks.WIRE.get());
      })
      .build()
  );

  public static void register(IEventBus eventBus) {
    CREATIVE_MODE_TABS.register(eventBus);
  }
}
