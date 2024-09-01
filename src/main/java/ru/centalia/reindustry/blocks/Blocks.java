package ru.centalia.reindustry.blocks;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ru.centalia.reindustry.Reindustry;
import ru.centalia.reindustry.items.Items;

import java.util.function.Supplier;

public class Blocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Reindustry.MOD_ID);

    public static final RegistryObject<Block> TIN_ORE = register("tin_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .requiresCorrectToolForDrops()
                    .strength(3f, 3f)
            ));

    public static final RegistryObject<Block> DEEPSLATE_TIN_ORE = register("deepslate_tin_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .requiresCorrectToolForDrops()
                    .strength(3f, 3f)
            ));

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block ){
        RegistryObject<T> RegistryObject = BLOCKS.register(name, block);
        registerItems(name, RegistryObject);
        return RegistryObject;
    }

    private static <T extends Block> void registerItems(String name, RegistryObject<T> block ){
        Items.ITEMS.register(name, () ->
                new BlockItem(block.get(),
                new Item.Properties()
                        ));
    }

    public static void reg(IEventBus bus){
        BLOCKS.register(bus);
    }

}
