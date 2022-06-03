package ru.centalia.reindustry;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.centalia.reindustry.blocks.BlockItems;
import ru.centalia.reindustry.blocks.ReindBlocks;
import ru.centalia.reindustry.blocks.entities.BlockEntities;
import ru.centalia.reindustry.items.Armor;
import ru.centalia.reindustry.items.Items;
import ru.centalia.reindustry.items.Tool;
import ru.centalia.reindustry.screen.MaceratorScreen;
import ru.centalia.reindustry.screen.MenuTypes;

import java.util.Random;

import static ru.centalia.reindustry.Reindustry.*;
import static ru.centalia.reindustry.blocks.BlockItems.*;


@Mod(id)
public class Reindustry
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String id = "reindustry";
    public static Random random = new Random();

    public static final CreativeModeTab REINDUSTRY = new CreativeModeTab("reindustry") {
        public ItemStack makeIcon(){
            return new ItemStack(Blocks.ANVIL);
        }
    };

    public Reindustry(){

        IEventBus init = FMLJavaModLoadingContext.get().getModEventBus();
        ReindBlocks.register(init);
        Items.register(init);
        BlockItems.register(init);
        Tool.register(init);
        Armor.register(init);
//      BlockEntities.register(init);
//      MenuTypes.register(init);

        init.addListener(this::clientSetup);
    }

    private void clientSetup(final FMLClientSetupEvent event){
        LOGGER.info("Welcome to the FUCKING HELL");

    }
//      MenuScreens.create(MenuTypes.MACERATOR_MENU.get(), MaceratorScreen::new);
}

