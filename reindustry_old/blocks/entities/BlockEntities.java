package ru.centalia.reindustry.blocks.entities;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ru.centalia.reindustry.blocks.ReindBlocks;
import ru.centalia.reindustry.blocks.entities.custom.MaceratorBlockEntities;

public class BlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
        DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, old_Reindustry.id);

    public static final RegistryObject<BlockEntityType<MaceratorBlockEntities>> MACERATOR =
            BLOCK_ENTITIES.register("macerator_block_entity", () ->
                    BlockEntityType.Builder.of(MaceratorBlockEntities::new,
                            ReindBlocks.MACERATOR.get()).build(null));

    public static void register(IEventBus init){
        BLOCK_ENTITIES.register(init);
    }
}
