package com.gtlugo.ampere.datagen;

import com.gtlugo.ampere.Ampere;
import com.gtlugo.ampere.blocks.ModBlocks;
import com.gtlugo.ampere.items.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;

public class ModModelProvider extends ModelProvider {
  public ModModelProvider(PackOutput output) {
    super(output, Ampere.MOD_ID);
  }

  @Override
  protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
    itemModels.generateFlatItem(ModItems.ICON.get(), ModelTemplates.FLAT_ITEM);
    itemModels.generateFlatItem(ModItems.LONSDALEITE.get(), ModelTemplates.FLAT_ITEM);
    itemModels.generateFlatItem(ModBlocks.WIRE.get().asItem(), ModelTemplates.FLAT_ITEM);


  }
}
