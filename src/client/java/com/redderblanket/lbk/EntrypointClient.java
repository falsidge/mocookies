package com.redderblanket.lbk;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class EntrypointClient implements ClientModInitializer {

	// https://fabricmc.net/wiki/tutorial:screen
	// https://fabricmc.net/wiki/tutorial:blockappearance

	// This entrypoint is suitable for setting up client-specific logic, such as rendering.
	public void onInitializeClient() {

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BUSH_STRAWBERRY, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BUSH_BLUEBERRY, RenderLayer.getCutout());
	}
}