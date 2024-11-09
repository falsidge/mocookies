package com.redderblanket.lbk;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    // setting a pan's .recipeRemainder(PAN) to itself, so that it returns in recipes, is... tricky
//    public static final Item PAN = register(
//            new Item(
//                    new Item.Settings().maxCount(1)
//            ),
//            "pan"
//    );

//    public static final Item BURGER = register(
//            new Item(
//                new Item.Settings()
//                    .maxCount(64)
//                    .food(
//                        new FoodComponent.Builder()
//                            .nutrition(8)
//                            .saturationModifier(8)
//                            .alwaysEdible()
//                            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 6 * 20, 1), 1.0f)
//                            .build()
//                    )
//            ),
//            "burger"
//    );

//    public static final Item SWEET_BERRY_TART = registerFood("sweet_berry_tart", 6, 8);
//    public static final Item BEETROOT_TART = registerFood("beetroot_tart", 6, 8);

    public static final Item DOUGH = register(new Item(new Item.Settings().maxCount(64)), "dough");
    public static final Item PASTRY_DOUGH = register(new Item(new Item.Settings().maxCount(64)), "pastry_dough");

    public static final Item CHOCOLATE = registerFood("chocolate", 2, 6);
    public static final Item CHOCOLATE_EGG = registerFood("chocolate_egg", 4, 6);

    public static final Item STRAWBERRY = registerFood("strawberry", 2, 0.8f);
    public static final Item BLUEBERRY = registerFood("blueberry", 2, 0.8f);

    public static final Item COOKIE_PLAIN          = registerFood("cookie_plain", 4, 8);
    public static final Item COOKIE_CANDY_CANE     = registerFood("cookie_candy_cane", 6, 10);
    public static final Item COOKIE_CHRISTMAS_TREE = registerFood("cookie_christmas_tree", 6, 10);
    public static final Item COOKIE_CREEPER        = registerFood("cookie_creeper", 6, 10);
    public static final Item COOKIE_EGG            = registerFood("cookie_egg", 6, 10);
    public static final Item COOKIE_PUMPKIN        = registerFood("cookie_pumpkin", 6, 10);
    public static final Item COOKIE_STAR           = registerFood("cookie_star", 6, 10);
    public static final Item COOKIE_SWORD          = registerFood("cookie_sword", 6, 10);

    public static void init() {

    }

    private static Item registerFood(String stringID, int nutrition, float saturation) {

        // steak gives 8 nutrition and 12.8 saturation
        // sweet berry gives 2 nutrition and 0.4 saturation
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
        ItemGroupEvents.modifyEntriesEvent(EntrypointMain.CREATIVE_TAB).register(itemGroup -> itemGroup.add(item));

        return item;
    }

}