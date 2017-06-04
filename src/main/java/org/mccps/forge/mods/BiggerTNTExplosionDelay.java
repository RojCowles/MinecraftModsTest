package org.mccps.forge.mods;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BiggerTNTExplosionDelay {

	private int FUSE = 4; // 4 second delay
	private float POWER = 32.0f; // Power of the TNT block

	@SubscribeEvent
	public void spawnTNTItem(EntityJoinWorldEvent event) {
		Entity entity = event.getEntity();
		if (!(entity instanceof EntityTNTPrimed)) {
			return;
		}

		EntityItem explosion = new EntityItem(event.getWorld(), entity.posX, entity.posY, entity.posZ,
				new ItemStack(Blocks.TNT));

		explosion.setInfinitePickupDelay();
		explosion.motionX = 0;
		explosion.motionY = 0;
		explosion.motionZ = 0;
		explosion.lifespan = FUSE * 20;

		event.getWorld().spawnEntity(explosion);
	}

	@SubscribeEvent
	public void explode(ItemExpireEvent event) {

		EntityItem explosion = event.getEntityItem();
		if (explosion.getEntityItem().getItem() != Item.getItemFromBlock(Blocks.TNT)) {
			return;
		}

		boolean isSmoking = true;
		event.getEntity().getEntityWorld().createExplosion(explosion, explosion.posX, explosion.posY, explosion.posZ,
				POWER, isSmoking);
	}

}
