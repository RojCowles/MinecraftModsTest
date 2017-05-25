package org.mccps.forge.mods;

import net.minecraft.entity.item.EntityMinecart;
import net.minecraftforge.event.entity.minecart.MinecartCollisionEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ExplodingMinecarts {
	@SubscribeEvent
	public void explode(MinecartCollisionEvent event)
	{
		EntityMinecart minecart = event.getMinecart();
		boolean isSmoking = false;
		minecart.getEntityWorld().createExplosion(minecart, minecart.posX, minecart.posY, minecart.posZ, 2.0f, isSmoking);
	}

}
