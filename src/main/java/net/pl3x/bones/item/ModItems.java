package net.pl3x.bones.item;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import net.pl3x.bones.Bones;

import java.util.HashSet;
import java.util.Set;

public class ModItems {
    public static final Set<Item> __ITEMS__ = new HashSet<>();

    public static final BoneArmor BONE_BOOTS = new BoneArmor(EntityEquipmentSlot.FEET, "bone_boots");
    public static final BoneArmor BONE_CHESTPLATE = new BoneArmor(EntityEquipmentSlot.CHEST, "bone_chestplate");
    public static final BoneArmor BONE_HELMET = new BoneArmor(EntityEquipmentSlot.HEAD, "bone_helmet");
    public static final BoneArmor BONE_LEGGINGS = new BoneArmor(EntityEquipmentSlot.LEGS, "bone_leggings");

    public static void register(IForgeRegistry<Item> registry) {
        __ITEMS__.forEach(registry::register);
    }

    public static void registerModels() {
        __ITEMS__.forEach(item -> Bones.proxy.registerItemRenderer(item, 0, item.getUnlocalizedName().substring(5)));
    }
}
