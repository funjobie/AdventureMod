package com.funjobie.adventuremod.server;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.management.PlayerManager;
import net.minecraft.world.World;

import com.funjobie.adventuremod.client.MessageTeleportToAdventure;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class HandlerTeleportToAdventure implements IMessageHandler<MessageTeleportToAdventure,IMessage>
{
	@Override
	public IMessage onMessage(MessageTeleportToAdventure message, MessageContext ctx)
	{
		World world = Minecraft.getMinecraft().theWorld;
		EntityPlayer player = world.func_152378_a(message.GetPlayerUUID()); //function probably getPlayerEntityByUUID
		//EntityPlayer player = world.getPlayerEntityByName("foo");
		
		player.addVelocity(0, 4, 0);
		//-1:nether, 0 overworld
		/*
		if(player.dimension == -1)
		{
			player.travelToDimension(0);
		}
		else if(player.dimension == 0)
		{
			player.travelToDimension(-1);
		}
		*/
		// handle the message 2 response message at the other end
		// no reply for this message - return null
		return null;
	}
}