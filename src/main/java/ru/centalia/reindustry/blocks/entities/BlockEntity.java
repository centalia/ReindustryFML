package ru.centalia.reindustry.blocks.entities;


import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import ru.centalia.reindustry.blocks.ReindBlocks;

import static ru.centalia.reindustry.Reindustry.*;

public class BlockEntity {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, id);
    public static final RegistryObject<GenBlockEntity> GENERATOR = BLOCK_ENTITY.register("generator",
            () -> BlockEntityType.Builder.of(GenBlockEntity::new, ReindBlocks.GENERATOR.get()
                    .build(null)
            )
    );
}
