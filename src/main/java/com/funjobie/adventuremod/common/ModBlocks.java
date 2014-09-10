package com.funjobie.adventuremod.common;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks
{

	public static Block adventureStarter = new AdventureStarterBlock();

	public static final void init()
	{
		GameRegistry.registerBlock(adventureStarter, "adventure");
		GameRegistry.registerTileEntity(AdventureStarterTileEntity.class, "adventureStarterTileEntity");
	}

}
