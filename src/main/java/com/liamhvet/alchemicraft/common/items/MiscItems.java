package com.liamhvet.alchemicraft.common.items;

import com.liamhvet.alchemicraft.Alchemicraft;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MiscItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Alchemicraft.MOD_ID);

    public static final DeferredItem<Item> SULFUR_CHUNK = ITEMS.register("sulfur_chunk",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CINNABAR_CHUNK = ITEMS.register("cinnabar_chunk",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BLUE_VITRIOL = ITEMS.register("blue_vitriol_crystal",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GREEN_VITRIOL = ITEMS.register("green_vitriol_crystal",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RED_VITRIOL = ITEMS.register("red_vitriol_crystal",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BLUE_VITRIOL_DUST = ITEMS.register("blue_vitriol_dust",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GREEN_VITRIOL_DUST = ITEMS.register("green_vitriol_dust",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RED_VITRIOL_DUST = ITEMS.register("red_vitriol_dust",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
