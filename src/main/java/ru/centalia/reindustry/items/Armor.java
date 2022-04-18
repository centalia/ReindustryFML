package ru.centalia.reindustry.items;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static ru.centalia.reindustry.Reindustry.*;
public class Armor {
    public static final DeferredRegister<Item> ARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, id);

    public static final RegistryObject<ArmorItem> BRONZE_HELMET = ARMOR.register("bronze_helmet",
            () -> new ArmorItem(ArmTiers.BRONZE, EquipmentSlot.HEAD,
                    new Item.Properties()
                            .tab(REINDUSTRY)));
    public static final RegistryObject<ArmorItem> BRONZE_CHEST = ARMOR.register("bronze_chest",
            () -> new ArmorItem(ArmTiers.BRONZE, EquipmentSlot.CHEST,
                    new Item.Properties()
                            .tab(REINDUSTRY)));
    public static final RegistryObject<ArmorItem> BRONZE_LEGS = ARMOR.register("bronze_legs",
            () -> new ArmorItem(ArmTiers.BRONZE, EquipmentSlot.LEGS,
                    new Item.Properties()
                            .tab(REINDUSTRY)));
    public static final RegistryObject<ArmorItem> BRONZE_FEET = ARMOR.register("bronze_feet",
            () -> new ArmorItem(ArmTiers.BRONZE, EquipmentSlot.FEET,
                    new Item.Properties()
                            .tab(REINDUSTRY)));

    public static void register(IEventBus init){
       ARMOR.register(init);
    }
}
