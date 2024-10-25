package com.redderblanket.lbk;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModBlocks {

    public static final Block TEST_BLOCK = register(
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GRASS)),
            "test_block"
    );

    public static void init() {

        // Add block items to dedicate creative mode tab.
        ItemGroupEvents.modifyEntriesEvent(EntrypointMain.CREATIVE_TAB).register((itemGroup) -> {

            itemGroup.add(TEST_BLOCK.asItem());
        });
    }



    private static Block register(Block block, String name) {

        Identifier id = Identifier.of(EntrypointMain.MOD_ID, name);

        // Register block item.
        BlockItem blockItem = new BlockItem(block, new Item.Settings());
        Registry.register(Registries.ITEM, id, blockItem);

        // Register block.
        return Registry.register(Registries.BLOCK, id, block);
    }

}
