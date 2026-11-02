package com.gtlugo.ampere.blocks;

import com.gtlugo.ampere.Ampere;
import com.gtlugo.ampere.items.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class ModBlocks {
  public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Ampere.MOD_ID);

  public static final DeferredBlock<Block> WIRE = registerBlock(
    "wire",
    properties -> new WireBlock(properties.overrideDescription("ampere.block.wire"))
  );

  private static <T extends Block> DeferredBlock<T> registerBlock(
    String name,
    Function<BlockBehaviour.Properties, T> function
  ) {
    DeferredBlock<T> block = BLOCKS.registerBlock(name, function);
    registerBlockItem(name, block);
    return block;
  }

  private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> Block) {
    ModItems.ITEMS.registerItem(
      name,
      properties -> new BlockItem(Block.get(), properties.useBlockDescriptionPrefix())
    );
  }

  public static void register(IEventBus eventBus) {
    BLOCKS.register(eventBus);
  }
}
