package ru.centalia.reindustry.items;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;


import java.util.List;

import static ru.centalia.reindustry.Reindustry.*;

public class IC2Hammer extends Item  {

    public static final DeferredRegister<Item> HAMMER = DeferredRegister.create(ForgeRegistries.ITEMS, id);
    public static final RegistryObject<Item> IC2HAMMER = HAMMER.register("hammer", () -> new IC2Hammer(
            new Item.Properties()
                    .setNoRepair()
                    .durability(5)
                    .tab(REINDUSTRY)
            )
    );

    public IC2Hammer(Properties properties){
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
