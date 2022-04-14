package ru.centalia.reindustry.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


import static ru.centalia.reindustry.Reindustry.*;

public class IC2Tool extends Item  {

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

    //@OnlyIn(Dist.CLIENT)
    //public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn)
    //{
    //    super.appendHoverText(stack, worldIn, tooltip, flagIn);
    //    tooltip.add((new TranslatableComponent(re).withStyle(ChatFormatting.GREEN)));
    //
    //}
}
