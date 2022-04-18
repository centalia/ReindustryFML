package ru.centalia.reindustry.items;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;


import java.util.function.Supplier;

public enum Tiers implements Tier {
    BRONZE(2, 192,6,6, 14,
            () -> { return Ingredient.of(Items.BRONZE_INGOT.get());
    });
    private final int level, durability, enchant;
    private final float speed, damage;
    private final Supplier<Ingredient> ingredient;

    private Tiers(int level, int durability, int enchant,
                  float speed, float damage,
                  Supplier<Ingredient> ingerdient){
        this.level      = level;
        this.durability = durability;
        this.enchant    = enchant;
        this.speed      = speed;
        this.damage     = damage;
        this.ingredient = ingerdient;
    }

    @Override
    public int getLevel(){ return this.level;}

    @Override
    public int getUses(){ return this.durability;}

    @Override
    public int getEnchantmentValue(){ return this.enchant;}

    @Override
    public Ingredient getRepairIngredient() { return this.ingredient.get();}

    @Override
    public float getSpeed() { return this.speed;}

    @Override
    public float getAttackDamageBonus(){ return this.damage;}
}
