package ru.centalia.reindustry;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.centalia.reindustry.items.Armor;
import ru.centalia.reindustry.items.Items;
import ru.centalia.reindustry.items.Tool;

import java.util.Random;

import static ru.centalia.reindustry.Reindustry.*;
import static ru.centalia.reindustry.blocks.BlockItems.*;
import static ru.centalia.reindustry.blocks.Blocks.*;


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
        LOGGER.debug("Welcome to the HELL");

        IEventBus init = FMLJavaModLoadingContext.get().getModEventBus();
        ORE.register(init);
        RAW_ORE.register(init);
        Items.register(init);
        BLOCKITEMS.register(init);
        Tool.register(init);
        Armor.register(init);
    }
}
