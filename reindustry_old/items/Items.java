package ru.centalia.reindustry.items;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static ru.centalia.reindustry.Config.ironDurability;
import static ru.centalia.reindustry.old_Reindustry.*;

public class Items extends Armor {
   public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, id);
   public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot",
            () -> new Item(new Item.Properties()
               .tab(REINDUSTRY)
            )
   );
   public static final RegistryObject<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot",
            () -> new Item(new Item.Properties()
               .tab(REINDUSTRY)
            )
   );
   public static final RegistryObject<Item> TIN_PLATE = ITEMS.register("tin_plate",
            () -> new Item(new Item.Properties()
                     .tab(REINDUSTRY)
            )
   );
   public static final RegistryObject<Item> IRON_PLATE = ITEMS.register("iron_plate",
            () -> new Item(new Item.Properties()
                     .tab(REINDUSTRY)
            )
   );
   public static final RegistryObject<Item> COPPER_PLATE = ITEMS.register("copper_plate",
            () -> new Item(new Item.Properties()
                     .tab(REINDUSTRY)
            )
   );
   public static final RegistryObject<Item> GOLD_PLATE = ITEMS.register("gold_plate",
            () -> new Item(new Item.Properties()
                     .tab(REINDUSTRY)
            )
   );
   public static final RegistryObject<Item> BRONZE_PLATE = ITEMS.register("bronze_plate",
            () -> new Item(new Item.Properties()
                     .tab(REINDUSTRY)
            )
   );
    public static final RegistryObject<Item> COPPER_CABLE = ITEMS.register("copper_cable",
            () -> new Item(new Item.Properties()
                    .tab(REINDUSTRY)
            )
    );
    public static final RegistryObject<Item> COPPER_DUST = ITEMS.register("copper_dust",
            () -> new Item(new Item.Properties()
                    .tab(REINDUSTRY)
            )
    );

    public static final RegistryObject<Item> TIN_DUST = ITEMS.register("tin_dust",
            () -> new Item(new Item.Properties()
                    .tab(REINDUSTRY)
            )
    );

    public static final RegistryObject<Item> BRONZE_DUST = ITEMS.register("bronze_dust",
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



   public static void register(IEventBus init){
       ITEMS.register(init);
       TOOL.register(init);
   }
}
