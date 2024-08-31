package ru.centalia.reindustry.screen;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MenuTypes {

    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.CONTAINERS, old_Reindustry.id);

    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>>registryMenusType(IContainerFactory<T> factory,
                                                                                String name){
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static final RegistryObject<MenuType<MaceratorMenu>> MACERATOR_MENU =
            registryMenusType(MaceratorMenu::new, "macerator_menu");

    public static void register(IEventBus init) {
        MENUS.register(init);
    }
}
