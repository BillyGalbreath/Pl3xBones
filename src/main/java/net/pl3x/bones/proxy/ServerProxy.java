package net.pl3x.bones.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.pl3x.bones.capability.CapabilityHandler;
import net.pl3x.bones.capability.DeceptionTarget;

public class ServerProxy {
    public void init(FMLInitializationEvent event) {
        CapabilityManager.INSTANCE.register(DeceptionTarget.class, new DeceptionTarget.Storage(), DeceptionTarget.class);

        MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
    }

    public void registerItemRenderer(Item item, int meta, String id) {
    }
}
