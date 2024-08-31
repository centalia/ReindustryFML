package ru.centalia.reindustry.items;

import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class IC2Tool extends Item implements TooltipComponent {

    public IC2Tool(Properties properties){
        super(properties);
    }

    public boolean hasContainerItem(ItemStack stack){
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack stackIn){
        ItemStack ret = stackIn.copy();
        ret.setDamageValue(getDamage(ret) + 1);

        if(ret.getDamageValue() >= ret.getMaxDamage()){
            ret.shrink(1);
        }

        return ret;

    }


}
