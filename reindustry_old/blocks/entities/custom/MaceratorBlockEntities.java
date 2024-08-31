package ru.centalia.reindustry.blocks.entities.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.centalia.reindustry.blocks.ReindBlocks;
import ru.centalia.reindustry.blocks.entities.BlockEntities;
import ru.centalia.reindustry.items.Items;
import ru.centalia.reindustry.items.Tool;
import ru.centalia.reindustry.screen.MaceratorMenu;

import javax.annotation.Nonnull;
import java.util.Random;

public class MaceratorBlockEntities extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemStackHandler = new ItemStackHandler(4){
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<ItemStackHandler> itemStackHandlerLazyOptional = LazyOptional.empty();

    public MaceratorBlockEntities(BlockPos p_155229_, BlockState p_155230_) {
        super(BlockEntities.MACERATOR.get(), p_155229_, p_155230_);
    }

    @Override
    public Component getDisplayName() {
        return new TextComponent("Macerator");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int contId, Inventory inv, Player player) {

        return new MaceratorMenu(contId, inv, this);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @javax.annotation.Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return itemStackHandlerLazyOptional.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad(){
        super.onLoad();
        itemStackHandlerLazyOptional = LazyOptional.of(() -> itemStackHandler);
    }

    @Override
    public void invalidateCaps(){
        super.invalidateCaps();
        itemStackHandlerLazyOptional.invalidate();
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag){
        tag.put("inventory", itemStackHandler.serializeNBT());
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag){
        super.load(tag);
        itemStackHandler.deserializeNBT(tag);
    }

    public void drops(){
        SimpleContainer inv = new SimpleContainer(itemStackHandler.getSlots());
                for (int i = 1; i < itemStackHandler.getSlots(); i++ ){
                    inv.setItem(i, itemStackHandler.getStackInSlot(i));
                }
        Containers.dropContents(this.level, this.worldPosition, inv);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, MaceratorBlockEntities entities){
        if (hasRecipe(entities) && hasNotReacedStackLimit(entities)){
            craftItem(entities);
        }
    }

    public static void craftItem(MaceratorBlockEntities entities){
        entities.itemStackHandler.extractItem(0,1, false);
        entities.itemStackHandler.extractItem(1,1,false);
        entities.itemStackHandler.getStackInSlot(2).hurt(1, new Random(), null);

        entities.itemStackHandler.setStackInSlot(3, new ItemStack(Items.TIN_DUST.get(),
                entities.itemStackHandler.getStackInSlot(3).getCount() + 1));
    }

    public static boolean hasRecipe(MaceratorBlockEntities entities){
        boolean hasInFirstSlot = entities.itemStackHandler.getStackInSlot(1).getItem() == ReindBlocks.RAW_TIN_ORE.get();
        boolean hasInSecondSlot = entities.itemStackHandler.getStackInSlot(2).getItem() == Tool.BRONZE_FORGE_HAMMER.get();

        return hasInFirstSlot && hasInSecondSlot;
    }

    public static boolean hasNotReacedStackLimit(MaceratorBlockEntities entities) {
        return entities.itemStackHandler.getStackInSlot(3).getCount() < entities.itemStackHandler.getStackInSlot(3).getMaxStackSize();
    }
}
