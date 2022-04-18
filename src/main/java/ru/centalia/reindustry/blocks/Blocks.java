package ru.centalia.reindustry.blocks;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static ru.centalia.reindustry.Reindustry.*;

public class Blocks {

    public static final DeferredRegister<Block> ORE = DeferredRegister.create(ForgeRegistries.BLOCKS, id);
    public static final RegistryObject<Block> TIN_ORE = ORE.register("tin_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .requiresCorrectToolForDrops()
                    .strength(3f, 3f)
            )
    );
    public static final RegistryObject<Block> DEEPSLATE_TIN_ORE = ORE.register("deepslate_tin_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .color(MaterialColor.DEEPSLATE)
                    .strength(3f, 4.5f)
                    .sound(SoundType.DEEPSLATE)
            )
    );
    public static final DeferredRegister<Item> RAW_ORE = DeferredRegister.create(ForgeRegistries.ITEMS, id);
    public static final RegistryObject<Item> RAW_TIN_ORE = RAW_ORE.register("tin_raw",
            () -> new Item(new Item.Properties()
                    .tab(REINDUSTRY)
            )
    );
}
