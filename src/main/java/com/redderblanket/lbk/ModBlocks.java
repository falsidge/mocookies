package com.redderblanket.lbk;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModBlocks {

    public static final Block BUSH_STRAWBERRY = register(new BlockBush(), "bush_strawberry");
    public static final Block BUSH_BLUEBERRY = register(new BlockBush(), "bush_blueberry");

    public static void init() {
        ((BlockBush) BUSH_STRAWBERRY).updateDroppedItem(ModItems.STRAWBERRY);
        ((BlockBush) BUSH_BLUEBERRY).updateDroppedItem(ModItems.BLUEBERRY);
    }

    private static Block register(Block block, String name) {

        // Create the identifier for the block.
        Identifier id = Identifier.of(EntrypointMain.MOD_ID, name);

        // Create block item.
        BlockItem blockItem = new BlockItem(block, new Item.Settings());

        // Register block and block item.
        Registry.register(Registries.ITEM, id, blockItem);
        Registry.register(Registries.BLOCK, id, block);

        // Add block item to dedicated creative mode tab.
        ItemGroupEvents.modifyEntriesEvent(EntrypointMain.CREATIVE_TAB).register((itemGroup) -> itemGroup.add(blockItem));

        return block;
    }

}
