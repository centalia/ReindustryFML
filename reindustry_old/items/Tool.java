package ru.centalia.reindustry.items;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static ru.centalia.reindustry.old_Reindustry.*;

public class Tool {
    public static final DeferredRegister<Item> BRONZE_TOOLS = DeferredRegister.create(ForgeRegistries.ITEMS, id);
    public static final RegistryObject<AxeItem> BRONZE_AXE = BRONZE_TOOLS.register("bronze_axe",
            () -> new AxeItem(Tiers.BRONZE, 1, 1, new Item.Properties()
                    .tab(REINDUSTRY)
            )
    );
    public static final RegistryObject<PickaxeItem> BRONZE_PICKAXE = BRONZE_TOOLS.register("bronze_pickaxe",
            () -> new PickaxeItem(Tiers.BRONZE,1,1, new Item.Properties()
                    .tab(REINDUSTRY)
            )
    );
    public static final RegistryObject<ShovelItem> BRONZE_SHOVEL = BRONZE_TOOLS.register("bronze_shovel",
            () -> new ShovelItem(Tiers.BRONZE,1,1, new Item.Properties()
                    .tab(REINDUSTRY)
            )
    );
    public static final RegistryObject<HoeItem> BRONZE_HOE = BRONZE_TOOLS.register("bronze_hoe",
            () -> new HoeItem(Tiers.BRONZE,1,1, new Item.Properties()
                    .tab(REINDUSTRY)
            )
    );
    public static final RegistryObject<SwordItem> BRONZE_SWORD = BRONZE_TOOLS.register("bronze_sword",
            () -> new SwordItem(Tiers.BRONZE,1,1, new Item.Properties()
                    .tab(REINDUSTRY)
            )
    );
    public static final RegistryObject<Item> BRONZE_FORGE_HAMMER = BRONZE_TOOLS.register("bronze_forge_hammer",
            () -> new IC2Tool(new Item.Properties()
                    .tab(REINDUSTRY)
                    .setNoRepair()
                    .durability(Tiers.BRONZE.getUses())
            )
    );
    public static final RegistryObject<Item> BRONZE_CUTTER = BRONZE_TOOLS.register("bronze_cutter",
            () -> new IC2Tool(new Item.Properties()
                    .tab(REINDUSTRY)
                    .setNoRepair()
                    .durability(Tiers.BRONZE.getUses())
            )
    );
    public static void register(IEventBus init){
        BRONZE_TOOLS.register(init);
    }
}
