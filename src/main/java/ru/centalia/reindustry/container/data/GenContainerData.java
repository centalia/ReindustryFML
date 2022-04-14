package ru.centalia.reindustry.container.data;

import net.minecraft.world.inventory.SimpleContainerData;
import ru.centalia.reindustry.blocks.entities.GenBlockEntity;

public class GenContainerData extends SimpleContainerData {
    private final GenBlockEntity blockEntity;
    public GenContainerData(GenBlockEntity be, int i) {
        super(i);
        this.blockEntity = be;
    }

    @Override
    public int get(int key) {
        return switch (key) {
            case 0 -> this.blockEntity.getProgress();
            case 1 -> this.blockEntity.getMaxProgress();
            case 2 -> this.blockEntity.getEnergy();
            case 3 -> this.blockEntity.energyStorage.getMaxEnergyStored();
            default -> throw new UnsupportedOperationException("Unable to get key: '" + key + "' for block entity: '"
                    + this.blockEntity + "' at pos: '" + this.blockEntity.getBlockPos() + "'");
        };
    }
}
