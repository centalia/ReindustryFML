package ru.centalia.reindustry.items;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import ru.centalia.reindustry.Reindustry;
import ru.centalia.reindustry.blocks.Blocks;

public class ReindTabs {

    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Reindustry.MOD_ID);

    public static final RegistryObject<CreativeModeTab> REINDUSTRY_ITEMS_TAB = TABS.register("reindustry_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.TIN.get()))
                    .title(Component.translatable("creativetab.reindustry.reindustry_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(Items.TIN.get());
                        output.accept(Items.RAW_TIN.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> REINDUSTRY_BLOCKS_TAB = TABS.register("reindustry_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Blocks.TIN_ORE.get()))
                    .title(Component.translatable("creativetab.reindustry.reindustry_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(Blocks.TIN_ORE.get());
                        output.accept(Blocks.DEEPSLATE_TIN_ORE.get());
                    }).build());

    public static void reg(IEventBus bus){
        TABS.register(bus);
    }
}
