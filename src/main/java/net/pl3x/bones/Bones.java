package net.pl3x.bones;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.pl3x.bones.enchantment.ModEnchantments;
import net.pl3x.bones.item.ModItems;
import net.pl3x.bones.proxy.ServerProxy;

@Mod(modid = Bones.modId, name = Bones.name, version = Bones.version,
        updateJSON = "http://pl3x.net/versions/bones.json")
public class Bones {
    public static final String modId = "bones";
    public static final String name = "Bones";
    public static final String version = "@DEV_BUILD@";

    @SidedProxy(serverSide = "net.pl3x.bones.proxy.ServerProxy", clientSide = "net.pl3x.bones.proxy.ClientProxy")
    public static ServerProxy proxy;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventBusSubscriber
    public static class EventHandler {
        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            ModItems.register(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerModels(ModelRegistryEvent event) {
            ModItems.registerModels();
        }

        @SubscribeEvent
        public static void registerEnchantments(RegistryEvent.Register<Enchantment> event) {
            ModEnchantments.register(event.getRegistry());
        }
    }
}
