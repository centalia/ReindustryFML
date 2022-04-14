package ru.centalia.reindustry.items;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ru.centalia.reindustry.blocks.Blocks;

import static ru.centalia.reindustry.Config.ironDurability;
import static ru.centalia.reindustry.Reindustry.*;

public class Items {
   public static final DeferredRegister<Item> INGOTS = DeferredRegister.create(ForgeRegistries.ITEMS, id);
   public static final RegistryObject<Item> TIN_INGOT = INGOTS.register("tin_ingot",
            () -> new Item(new Item.Properties()
               .tab(REINDUSTRY)
            )
   );
   public static final RegistryObject<Item> BRONZE_INGOT = INGOTS.register("bronze_ingot",
            () -> new Item(new Item.Properties()
               .tab(REINDUSTRY)
            )
   );

   public static final DeferredRegister<Item> RAW_ORE = DeferredRegister.create(ForgeRegistries.ITEMS, id);
   public static final RegistryObject<Item> RAW_TIN_ORE = RAW_ORE.register("tin_raw",
            () -> new Item(new Item.Properties()
               .tab(REINDUSTRY)
            )
   );

   public static final DeferredRegister<Item> BLOCKITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, id);
   public static final RegistryObject<Item> TIN_ORE = BLOCKITEMS.register("tin_ore",
            () -> new BlockItem(Blocks.TIN_ORE.get(),
                  new Item.Properties()
                     .tab(REINDUSTRY)
            )
   );
   public static final RegistryObject<Item> DEEPSLATE_TIN_ORE = BLOCKITEMS.register("deepslate_tin_ore",
            () -> new BlockItem(Blocks.DEEPSLATE_TIN_ORE.get(),
                  new Item.Properties()
                     .tab(REINDUSTRY)
            )
   );

   public static final DeferredRegister<Item> PLATES = DeferredRegister.create(ForgeRegistries.ITEMS, id);
   public static final RegistryObject<Item> TIN_PLATE = PLATES.register("tin_plate",
            () -> new Item(new Item.Properties()
                     .tab(REINDUSTRY)
            )
   );
   public static final RegistryObject<Item> IRON_PLATE = PLATES.register("iron_plate",
            () -> new Item(new Item.Properties()
                     .tab(REINDUSTRY)
            )
   );
   public static final RegistryObject<Item> COPPER_PLATE = PLATES.register("copper_plate",
            () -> new Item(new Item.Properties()
                     .tab(REINDUSTRY)
            )
   );
   public static final RegistryObject<Item> GOLD_PLATE = PLATES.register("gold_plate",
            () -> new Item(new Item.Properties()
                     .tab(REINDUSTRY)
            )
   );
   public static final RegistryObject<Item> BRONZE_PLATE = PLATES.register("bronze_plate",
            () -> new Item(new Item.Properties()
                     .tab(REINDUSTRY)
            )
   );

   public static final DeferredRegister<Item> TOOL = DeferredRegister.create(ForgeRegistries.ITEMS, id);
   public static final RegistryObject<Item> FORGE_HAMMER = TOOL.register("forge_hammer",
            () -> new IC2Tool(new Item.Properties()
                     .setNoRepair()
                     .durability(ironDurability)
                     .tab(REINDUSTRY)
            )
   );
   public static final RegistryObject<Item> CUTTER = TOOL.register("cutter",
            () -> new IC2Tool(new Item.Properties()
                     .setNoRepair()
                     .durability(ironDurability)
                     .tab(REINDUSTRY)
      )
   );

   public static final DeferredRegister<Item> CABLE = DeferredRegister.create(ForgeRegistries.ITEMS, id);
   public static final RegistryObject<Item> COPPER_CABLE = CABLE.register("copper_cable",
            () -> new Item(new Item.Properties()
                     .tab(REINDUSTRY)
            )
   );

}
