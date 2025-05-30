package com.redderblanket.mocookies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


@Mod(MoCookiesMod.MODID)
public class MoCookiesMod
{
	public static final String MODID = "mocookies";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
//
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CREATIVE_TAB = CREATIVE_MODE_TABS.register("mocookies_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("item_group." + MODID))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ModItems.COOKIE_CHOCOLATE.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(ModItems.COOKIE_CHOCOLATE.get());
				output.accept(ModItems.COOKIE_GOLDEN.get());
				output.accept(ModItems.COOKIE_SUGAR.get());
				output.accept(ModItems.COOKIE_HALF_MOON.get());
				output.accept(ModItems.COOKIE_STROOPWAFEL.get());
				output.accept(ModItems.COOKIE_MACARON_CHOCOLATE.get());
				output.accept(ModItems.COOKIE_MACARON_ROSEWATER.get());
				output.accept(ModItems.CARAMEL.get());
            }).build());

    public MoCookiesMod(IEventBus modEventBus, ModContainer modContainer)
	{
		// Register the Deferred Register to the mod event bus so items get registered
		ITEMS.register(modEventBus);
		ModItems.init();

		// Register the Deferred Register to the mod event bus so tabs get registered
		CREATIVE_MODE_TABS.register(modEventBus);

		LOGGER.info("Mo' Cookies has loaded.");
	}
}