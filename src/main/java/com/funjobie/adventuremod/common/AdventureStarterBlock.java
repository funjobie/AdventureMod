package com.funjobie.adventuremod.common;

import com.funjobie.adventuremod.AdventureMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class AdventureStarterBlock extends Block {
	
	AdventureStarterBlock()
	{
		super(Material.rock);
		setHardness(999999.9F);
		setBlockName("adventure");
        setCreativeTab(AdventureMod.creativeTab);
	}

}
