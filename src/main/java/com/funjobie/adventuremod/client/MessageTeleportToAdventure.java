package com.funjobie.adventuremod.client;

import java.nio.charset.Charset;
import java.util.UUID;

import com.ibm.icu.util.CharsTrieBuilder;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class MessageTeleportToAdventure implements IMessage
{
	private UUID m_playerUUID;

	public MessageTeleportToAdventure()
	{
		
	}
	
	public MessageTeleportToAdventure(UUID uuid)
	{
		m_playerUUID = uuid;
	}
	// message structure
	public void fromBytes(ByteBuf buf)
	{
		long mostSigBits = buf.readLong();
		long leastSigBits = buf.readLong();
		m_playerUUID = new UUID(mostSigBits, leastSigBits);
	}

	public void toBytes(ByteBuf buf)
	{
		buf.writeLong(m_playerUUID.getMostSignificantBits());
		buf.writeLong(m_playerUUID.getLeastSignificantBits());
	}
	
	public UUID GetPlayerUUID()
	{
		return m_playerUUID;
	}
}
