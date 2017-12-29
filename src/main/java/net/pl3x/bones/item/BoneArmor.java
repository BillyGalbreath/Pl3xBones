package net.pl3x.bones.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.pl3x.bones.material.BonesMaterial;

public class BoneArmor extends net.minecraft.item.ItemArmor {
    public BoneArmor(EntityEquipmentSlot slot, String name) {
        super(BonesMaterial.ARMOR, 0, slot);
        setRegistryName(name);
        setUnlocalizedName(name);

        setCreativeTab(CreativeTabs.COMBAT);

        ModItems.__ITEMS__.add(this);
    }
}
