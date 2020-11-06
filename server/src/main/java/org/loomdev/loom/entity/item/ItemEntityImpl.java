package org.loomdev.loom.entity.item;

import net.minecraft.world.entity.item.ItemEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.loomdev.api.entity.EntityType;
import org.loomdev.api.entity.Item;
import org.loomdev.api.item.ItemStack;
import org.loomdev.loom.entity.EntityImpl;
import org.loomdev.loom.item.ItemStackImpl;

import java.util.UUID;

public class ItemEntityImpl extends EntityImpl implements Item {

    public ItemEntityImpl(ItemEntity entity) {
        super(entity);
    }

    @Override
    @NotNull
    public EntityType<Item> getType() {
        return EntityType.ITEM;
    }

    @Override
    @NotNull
    public ItemEntity getMinecraftEntity() {
        return (ItemEntity) super.getMinecraftEntity();
    }

    @Override
    @Nullable
    public UUID getOwner() {
        return getMinecraftEntity().getOwner();
    }

    @Override
    public void setOwner(@Nullable UUID uuid) {
        getMinecraftEntity().setOwner(uuid);
    }

    @Override
    @Nullable
    public UUID getThrower() {
        return getMinecraftEntity().getThrower();
    }

    @Override
    public void setThrower(@Nullable UUID uuid) {
        getMinecraftEntity().setThrower(uuid);
    }

    @Override
    @NotNull
    public ItemStack getItemStack() {
        return ItemStackImpl.of(getMinecraftEntity().getItem());
    }

    @Override
    public void setItemStack(@NotNull ItemStack item) {
        getMinecraftEntity().setItem(((ItemStackImpl) item).getMinecraftItemStack());
    }

    @Override
    public int getPickupDelay() {
        return getMinecraftEntity().pickupDelay;
    }

    @Override
    public void setPickupDelay(int ticks) {
        getMinecraftEntity().setPickUpDelay(ticks);
    }
}
