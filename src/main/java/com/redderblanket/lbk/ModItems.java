package com.redderblanket.lbk;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item BURGER = register(
            new Item(
                new Item.Settings()
                    .maxCount(64)
                    .food(
                        new FoodComponent.Builder()
                            .nutrition(8)
                            .saturationModifier(8)
                            .alwaysEdible()
                            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 6 * 20, 1), 1.0f)
                            .build()
                    )
            ),
            "burger"
    );

    public static final Item SWEET_BERRY_TART = registerFood("sweet_berry_tart", 6, 8);
    public static final Item BEETROOT_TART = registerFood("beetroot_tart", 6, 8);
    public static final Item CHOCOLATE_CROISSANT = registerFood("chocolate_croissant", 4, 6);

    public static final Item SEED_OIL = register(new Item(new Item.Settings().maxCount(64)), "seed_oil");
    public static final Item PASTRY_DOUGH = register(new Item(new Item.Settings().maxCount(64)), "pastry_dough");

    public static void init() {

        // Add food items to dedicate creative mode tab.
        ItemGroupEvents.modifyEntriesEvent(EntrypointMain.CREATIVE_TAB).register(itemGroup -> {

            itemGroup.add(BURGER);
            itemGroup.add(SWEET_BERRY_TART);
            itemGroup.add(BEETROOT_TART);
            itemGroup.add(CHOCOLATE_CROISSANT);

            itemGroup.add(SEED_OIL);
            itemGroup.add(PASTRY_DOUGH);
        });
    }



    private static Item registerFood(String stringID, int nutrition, int saturation) {

        // steak gives 8 nutrition and 12.8 saturation

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

        // Register and return newly registered item.
        return Registry.register(Registries.ITEM, itemID, item);
    }

}