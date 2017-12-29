package net.pl3x.bones.capability;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class DeceptionTarget {
    private NBTTagCompound targets = new NBTTagCompound();

    public void ignoreTarget(EntityLivingBase target, boolean ignored) {
        targets.setBoolean(target.getUniqueID().toString(), ignored);
    }

    public boolean hasIgnoredTarget(EntityLivingBase target) {
        return targets.hasKey(target.getUniqueID().toString());
    }

    public boolean shouldIgnoreTarget(EntityLivingBase target) {
        return targets.getBoolean(target.getUniqueID().toString());
    }

    NBTTagCompound getDataAsNBT() {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setTag("targets", targets);
        return nbt;
    }

    void setDataFromNBT(NBTTagCompound compound) {
        targets = compound.getCompoundTag("targets");
    }

    public static class Provider implements ICapabilitySerializable<NBTBase> {
        @CapabilityInject(DeceptionTarget.class)
        static Capability<DeceptionTarget> CAPABILITY = null;

        private final DeceptionTarget instance = CAPABILITY.getDefaultInstance();

        @Override
        public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
            return capability == CAPABILITY;
        }

        @Nullable
        @Override
        public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
            return capability == CAPABILITY ? CAPABILITY.cast(this.instance) : null;
        }

        @Override
        public NBTBase serializeNBT() {
            return CAPABILITY.getStorage().writeNBT(CAPABILITY, this.instance, null);
        }

        @Override
        public void deserializeNBT(NBTBase nbt) {
            CAPABILITY.getStorage().readNBT(CAPABILITY, this.instance, null, nbt);
        }
    }

    public static class Storage implements Capability.IStorage<DeceptionTarget> {
        @Nullable
        @Override
        public NBTBase writeNBT(Capability<DeceptionTarget> capability, DeceptionTarget instance, EnumFacing side) {
            return instance.getDataAsNBT();
        }

        @Override
        public void readNBT(Capability<DeceptionTarget> capability, DeceptionTarget instance, EnumFacing side, NBTBase nbt) {
            instance.setDataFromNBT((NBTTagCompound) nbt);
        }
    }
}
