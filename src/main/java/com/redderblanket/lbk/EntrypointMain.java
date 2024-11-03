package com.redderblanket.lbk;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EntrypointMain implements ModInitializer {

	public static final String MOD_ID = "lbk";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final RegistryKey<ItemGroup> CREATIVE_TAB = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(MOD_ID, "item_group"));

	// This code runs as soon as Minecraft is in a mod-load-ready state.
	// However, some things (like resources) may still be uninitialized.
	// Proceed with mild caution.
	public void onInitialize() {

		// Initialize item group (creative tab).
		Registry.register(Registries.ITEM_GROUP, CREATIVE_TAB,
				FabricItemGroup.builder()
					.icon(() -> new ItemStack(ModItems.BURGER))
					.displayName(Text.translatable("item_group." + MOD_ID))
					.build()
		);

		ModItems.init();
		ModBlocks.init();

		LOGGER.info("Lil' Block Kitchen has loaded.");
	}
}