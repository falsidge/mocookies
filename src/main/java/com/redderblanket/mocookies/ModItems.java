package com.redderblanket.mocookies;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    static {

        // add the default cookie
        addToCreativeTab(Registries.ITEM.get(Identifier.of("minecraft", "cookie")));
    }

    public static final Item COOKIE_CHOCOLATE = registerFood("cookie_chocolate", 2, 0.4f);
    public static final Item COOKIE_GOLDEN = registerFood("cookie_golden", 2, 16f);
    public static final Item COOKIE_SUGAR = registerFood("cookie_sugar", 2, 0.4f);
    public static final Item COOKIE_HALF_MOON = registerFood("cookie_half_moon", 2, 0.4f);
    public static final Item COOKIE_STROOPWAFEL = registerFood("cookie_stroopwafel", 2, 0.4f);

    public static final Item CARAMEL = registerFood("caramel", 2, 0.4f);

    public static void init() {}

    private static Item registerFood(String stringID, int nutrition, float saturation) {

        // steak gives 8 nutrition and 12.8 saturation
        // cookies gives 2 nutrition and 0.4 saturation
        return register(
            new Item(
                new Item.Settings()
                    .maxCount(64)
                    .food(
                        new FoodComponent.Builder()
                            .nutrition(nutrition)
                            .saturationModifier(saturation)
                            .build()
                    )
            ),
            stringID
        );
    }

    private static Item register(Item item, String stringID) {

        // Create the identifier for the item.
        Identifier itemID = Identifier.of(EntrypointMain.MOD_ID, stringID);

        // Register item (this function returns the item parameter).
        Registry.register(Registries.ITEM, itemID, item);

        // Add registered item to dedicate creative mode tab.
        addToCreativeTab(item);

        return item;
    }

    private static void addToCreativeTab(Item item) {

        ItemGroupEvents.modifyEntriesEvent(EntrypointMain.CREATIVE_TAB).register(itemGroup -> itemGroup.add(item));
    }

}