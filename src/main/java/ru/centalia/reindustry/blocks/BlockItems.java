package ru.centalia.reindustry.blocks;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static ru.centalia.reindustry.Reindustry.REINDUSTRY;
import static ru.centalia.reindustry.Reindustry.id;

public class BlockItems {
    public static final DeferredRegister<Item> BLOCKITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, id);
    public static final RegistryObject<Item> TIN_ORE = BLOCKITEMS.register("tin_ore",
            () -> new BlockItem(ReindBlocks.TIN_ORE.get(),
                    new Item.Properties()
                            .tab(REINDUSTRY)
            )
    );
    public static final RegistryObject<Item> DEEPSLATE_TIN_ORE = BLOCKITEMS.register("deepslate_tin_ore",
            () -> new BlockItem(ReindBlocks.DEEPSLATE_TIN_ORE.get(),
                    new Item.Properties()
                            .tab(REINDUSTRY)
            )
    );

    public static void register(IEventBus init) {
        BLOCKITEMS.register(init);
    }
}
