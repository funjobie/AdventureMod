package com.funjobie.adventuremod.common;

import com.funjobie.adventuremod.client.AdventureStarterGUI;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler{
	
	public void preInit(FMLPreInitializationEvent e) {
    	ModItems.init();
    	ModBlocks.init();
    }

    public void init(FMLInitializationEvent e) {

    }

    public void postInit(FMLPostInitializationEvent e) {

    }

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);
        if(tileEntity instanceof AdventureStarterTileEntity){
                return new AdventureStarterContainer(player.inventory, (AdventureStarterTileEntity) tileEntity);
        }
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		
		TileEntity tileEntity = world.getTileEntity(x, y, z);
        if(tileEntity instanceof AdventureStarterTileEntity){
                return new AdventureStarterGUI(player.inventory, (AdventureStarterTileEntity) tileEntity);
        }
		
		return null;
	}
}
