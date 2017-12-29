package net.pl3x.bones.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.pl3x.bones.Bones;

@SideOnly(Side.CLIENT)
public class ClientProxy extends ServerProxy {
    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
    }

    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta,
                new ModelResourceLocation(Bones.modId + ":" + id, "inventory"));
    }
}
