package ru.centalia.reindustry.container;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import ru.centalia.reindustry.blocks.ReindBlocks;
import ru.centalia.reindustry.blocks.entities.GenBlockEntity;
import ru.centalia.reindustry.container.data.GenContainerData;

public class GenContainer extends AbstractContainerMenu {
    private final ContainerLevelAccess containerAccess;
    public final ContainerData data;

    // Client Constructor
    public GenContainer(int id, Inventory playerInv) {
        this(id, playerInv, new ItemStackHandler(1), BlockPos.ZERO, new SimpleContainerData(4));
    }

    // Server constructor
    public GenContainer(int id, Inventory playerInv, IItemHandler slots, BlockPos pos, ContainerData data) {
        super(Container.GENERATOR.get(), id);
        this.containerAccess = ContainerLevelAccess.create(playerInv.player.level, pos);
        this.data = data;

        final int slotSizePlus2 = 18, startX = 8, startY = 86, hotbarY = 144;

        addSlot(new SlotItemHandler(slots, 0, 44, 36));

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                addSlot(new Slot(playerInv, 9 + row * 9 + column, startX + column * slotSizePlus2,
                        startY + row * slotSizePlus2));
            }
        }

        for (int column = 0; column < 9; column++) {
            addSlot(new Slot(playerInv, column, startX + column * slotSizePlus2, hotbarY));
        }

        addDataSlots(data);
    }


    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        var retStack = ItemStack.EMPTY;
        final Slot slot = getSlot(index);
        if (slot.hasItem()) {
            final ItemStack item = slot.getItem();
            retStack = item.copy();
            if (index < 1) {
                if (!moveItemStackTo(item, 1, this.slots.size(), true))
                    return ItemStack.EMPTY;
            } else if (!moveItemStackTo(item, 0, 1, false))
                return ItemStack.EMPTY;

            if (item.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return retStack;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.containerAccess, player, ReindBlocks.GENERATOR.get());
    }

    public static MenuConstructor getServerContainer(GenBlockEntity be, BlockPos pos) {
        return (id, playerInv, player) -> new GenContainer(id, playerInv, be.inventory, pos,
                new GenContainerData(be, 4, blockEntity));
    }
}
