package org.mccps.forge.mods;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockBreakMessage {
	@SubscribeEvent
	public void sendMessage(BreakEvent event)
	{
		EntityPlayer player = event.getPlayer();
		player.sendMessage(new TextComponentString("You broke a block"));
	}

}
