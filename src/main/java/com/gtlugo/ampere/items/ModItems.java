package com.gtlugo.ampere.items;

import com.gtlugo.ampere.Ampere;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Consumer;

public class ModItems {
  public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Ampere.MOD_ID);

  public static final DeferredItem<Item> ICON = ITEMS.registerItem(
    "icon",
    properties -> new Item(properties.fireResistant().overrideDescription("ampere.item.icon")) {
      @SuppressWarnings("deprecation")
      @Override
      public void appendHoverText(
        ItemStack itemStack,
        TooltipContext context,
        TooltipDisplay display,
        Consumer<Component> builder,
        TooltipFlag tooltipFlag
      ) {
        MutableComponent tooltip = Component.translatable("ampere.item.icon.tooltip");
        tooltip.setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY).withItalic(true));
        builder.accept(tooltip);
        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
      }
    }
  );
  public static final DeferredItem<Item> LONSDALEITE = ITEMS.registerItem(
    "lonsdaleite", properties -> new Item(properties.overrideDescription("ampere.item.lonsdaleite"))
  );

  public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
  }
}
