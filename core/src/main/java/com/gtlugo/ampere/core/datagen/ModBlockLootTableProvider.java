package com.gtlugo.ampere.core.datagen;

import com.gtlugo.ampere.core.Ampere;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
  protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
    super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
  }

  @Override
  protected void generate() {
    dropSelf(Ampere.Blocks.FURNACE.get());
    dropSelf(Ampere.Blocks.POWER_PLANT.get());
    dropSelf(Ampere.Blocks.WIRE.get());
  }

  @Override
  protected @NotNull Iterable<Block> getKnownBlocks() {
    return Ampere.BLOCK_REGISTRY
      .getEntries()
      .stream()
      .map(Holder::value)::iterator;
  }
}
