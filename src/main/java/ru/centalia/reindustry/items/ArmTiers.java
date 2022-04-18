package ru.centalia.reindustry.items;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import ru.centalia.reindustry.Reindustry;

import java.util.function.Supplier;

public enum ArmTiers implements ArmorMaterial {
    BRONZE(1, new int[] {100,90,80,70}, new int[] {20,20,20,20},3.2f,1.85f, Reindustry.id, SoundEvents.ARMOR_EQUIP_IRON,
            () -> Ingredient.of(Items.BRONZE_INGOT.get()));
    private final int enchant;
    private final int[] durability, damageReditions;
    private final float knockbackResist, tough;
    private final String name;
    private SoundEvent sound;
    private final Supplier<Ingredient> ingredient;

    ArmTiers(int enchant, int[] durability, int[] damageReditions,
             float knockbackResist, float tough,
             String name, SoundEvent sound,
             Supplier<Ingredient> ingredient) {
        this.enchant = enchant;
        this.durability = durability;
        this.damageReditions = damageReditions;
        this.knockbackResist = knockbackResist;
        this.tough = tough;
        this.name = name;
        this.sound = sound;
        this.ingredient = ingredient;
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlot slot) {
        return this.durability[slot.getIndex()];
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slot) {
        return this.damageReditions[slot.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchant;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.sound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.ingredient.get();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.tough;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResist;
    }
}
