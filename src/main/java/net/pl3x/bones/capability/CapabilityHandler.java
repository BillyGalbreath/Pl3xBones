package net.pl3x.bones.capability;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.pl3x.bones.Bones;

public class CapabilityHandler {
    private static final ResourceLocation DECEPTION_TARGET = new ResourceLocation(Bones.modId, "target");

    @SubscribeEvent
    public void on(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof EntitySkeleton) {
            event.addCapability(DECEPTION_TARGET, new DeceptionTarget.Provider());
        }
    }

    public static DeceptionTarget getCapability(Entity entity) {
        return entity.getCapability(DeceptionTarget.Provider.CAPABILITY, null);
    }
}
