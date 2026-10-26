package com.gtlugo.ampere.items;

import com.gtlugo.ampere.Ampere;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
  public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Ampere.MOD_ID);

  public static final DeferredItem<Item> LONSDALEITE = ITEMS.registerSimpleItem("lonsdaleite");

  public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
  }
}
