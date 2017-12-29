package net.pl3x.bones.material;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import net.pl3x.bones.Bones;

public class BonesMaterial {
    public static final ItemArmor.ArmorMaterial ARMOR = EnumHelper.addArmorMaterial("BONE", Bones.modId + ":bone", 7, new int[]{1, 3, 5, 1}, 9, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0);
}
