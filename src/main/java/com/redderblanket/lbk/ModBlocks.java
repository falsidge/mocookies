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

    }

    private static Block register(Block block, String name) {

        // Create the identifier for the block.
        Identifier id = Identifier.of(EntrypointMain.MOD_ID, name);

        // Create block item.
        BlockItem blockItem = new BlockItem(block, new Item.Settings());

        // Register block and block item.
        Registry.register(Registries.ITEM, id, blockItem);
        Registry.register(Registries.BLOCK, id, block);

        // Add block item to dedicate creative mode tab.
        ItemGroupEvents.modifyEntriesEvent(EntrypointMain.CREATIVE_TAB).register((itemGroup) -> itemGroup.add(blockItem));

        return block;
    }

}
