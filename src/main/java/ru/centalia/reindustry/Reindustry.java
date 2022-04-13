package ru.centalia.reindustry;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

import static ru.centalia.reindustry.Reindustry.*;
import static ru.centalia.reindustry.items.Items.*;
import static ru.centalia.reindustry.blocks.Blocks.*;
import static ru.centalia.reindustry.items.IC2Hammer.*;

@Mod(id)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
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
        LOGGER.debug("Welcome to the HELL");

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        INGOTS.register(bus);
        PLATES.register(bus);
        ORE.register(bus);
        RAW_ORE.register(bus);
        BLOCKITEMS.register(bus);
        HAMMER.register(bus);
    }
}
