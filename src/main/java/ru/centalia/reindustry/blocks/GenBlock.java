package ru.centalia.reindustry.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import ru.centalia.reindustry.blocks.entities.GenBlockEntity;

public class GenBlock extends Block implements EntityBlock {
    public GenBlock(Properties properties){
        super(properties);
    }

    @Override
    public <T extends BlockEntity>BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> type){
        return level.isClientSide ? null
                : (level0, pos, state0, blockEntity) -> ((GenBlockEntity) blockEntity).tick();
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state){
        return new GenBlockEntity(pos, state);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean moving) {
        final BlockEntity be = level.getBlockEntity(pos);
        //@formatter:off
        if (!((be instanceof final GenBlockEntity gen)))
            return;
        //@formatter:on

        for (int slot = 0; slot < gen.inventory.getSlots(); slot++) {
            if (gen.inventory.getStackInSlot(slot).isEmpty())
                return;

            level.addFreshEntity(new ItemEntity(level, pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D,
                    gen.inventory.getStackInSlot(slot)));
        }

        super.onRemove(state, level, pos, newState, moving);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand,
                                 BlockHitResult result) {
        if (!level.isClientSide && level.getBlockEntity(pos) instanceof final GenBlockEntity gen) {
            final MenuProvider container = new SimpleMenuProvider(
                    GenContainer.getServerContainer(gen, pos), GenBlockEntity.TITLE);
            NetworkHooks.openGui((ServerPlayer) player, container, pos);
        }

        return InteractionResult.SUCCESS;
    }
}
