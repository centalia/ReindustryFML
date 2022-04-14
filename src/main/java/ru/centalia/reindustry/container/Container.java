package ru.centalia.reindustry.container;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static ru.centalia.reindustry.Reindustry.*;

public class Container {

    public static final DeferredRegister<MenuType<?>> CONTAINER = DeferredRegister.create(ForgeRegistries.CONTAINERS, id);
    public static final RegistryObject<MenuType<GenContainer>> GENERATOR = CONTAINER.register("generator",
            () -> new MenuType<>(GenContainer::new));
}
