package com.redderblanket.mocookies;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

import net.neoforged.neoforge.registries.DeferredItem;

import static com.redderblanket.mocookies.MoCookiesMod.ITEMS;

public class ModItems {


    public static final DeferredItem<Item> COOKIE_CHOCOLATE = registerFood("cookie_chocolate", 2, 0.4f);
    public static final DeferredItem<Item> COOKIE_GOLDEN = registerFood("cookie_golden", 2, 16f);
    public static final DeferredItem<Item> COOKIE_SUGAR = registerFood("cookie_sugar", 2, 0.4f);
    public static final DeferredItem<Item> COOKIE_HALF_MOON = registerFood("cookie_half_moon", 2, 0.4f);
    public static final DeferredItem<Item> COOKIE_STROOPWAFEL = registerFood("cookie_stroopwafel", 2, 0.4f);
    public static final DeferredItem<Item> COOKIE_MACARON_CHOCOLATE = registerFood("cookie_macaron_chocolate", 2, 0.4f);
    public static final DeferredItem<Item> COOKIE_MACARON_ROSEWATER = registerFood("cookie_macaron_rosewater", 2, 0.4f);

    public static final DeferredItem<Item> CARAMEL = registerFood("caramel", 2, 0.4f);

    public static void init() {}

    private static DeferredItem<Item> registerFood(String stringID, int nutrition, float saturation) {
        // steak gives 8 nutrition and 12.8 saturation
        // cookies gives 2 nutrition and 0.4 saturation
        return ITEMS.registerSimpleItem(stringID, new Item.Properties().food(new FoodProperties.Builder()
                .alwaysEdible().nutrition(nutrition).saturationModifier(saturation).build()));
    }

}