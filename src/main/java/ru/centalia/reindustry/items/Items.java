package ru.centalia.reindustry.items;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ru.centalia.reindustry.Reindustry;

public class Items {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reindustry.MOD_ID);

    public static final RegistryObject<Item> TIN = ITEMS.register("tin_ingot",
            () -> new Item(new Item.Properties()

            )
    );
    public static final RegistryObject<Item> RAW_TIN = ITEMS.register("tin_raw",
            () -> new Item(new Item.Properties()

            )
    );

    public static void reg(IEventBus bus){
        ITEMS.register(bus);
    }
}
