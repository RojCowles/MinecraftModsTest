package org.mccps.forge.mods;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BiggerTNTExlposion {


	@SubscribeEvent
	public void explode(EntityJoinWorldEvent event)
	{
		Entity entity = event.getEntity();
		if (!(entity instanceof EntityTNTPrimed))
		{
			return;
		}
		
		boolean isSmoking = true;
		float power = 32.0F;
		entity.getEntityWorld().createExplosion(entity, entity.posX, entity.posY, entity.posZ, power, isSmoking);

	}

}
