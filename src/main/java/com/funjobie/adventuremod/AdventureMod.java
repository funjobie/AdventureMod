package com.funjobie.adventuremod;

import com.funjobie.adventuremod.common.AdventureStarterTileEntity;
import com.funjobie.adventuremod.common.CommonProxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = AdventureMod.MODID, version = AdventureMod.VERSION, name = AdventureMod.NAME)
public class AdventureMod
{
    public static final String MODID = "AdventureMod";
    public static final String VERSION = "1.0";
    public static final String NAME = MODID;
    
    @SidedProxy(clientSide="com.funjobie.adventuremod.client.ClientProxy", serverSide="com.funjobie.adventuremod.server.ServerProxy")
    public static CommonProxy proxy;
    
    /**
     * Run before anything else. Read your config, create blocks, items, etc, and 
     * register them with the GameRegistry.
     */
    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
    	proxy.preInit(e);
    	GameRegistry.registerTileEntity(AdventureStarterTileEntity.class, "adventureStarterTileEntity");
    }
    
    /**
     * Do your mod setup. Build whatever data structures you care about. Register recipes.
     */
    @EventHandler
    public void init(FMLInitializationEvent e) {
    	proxy.init(e);
  
    	NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
    }
    
    /**
     * Handle interaction with other mods, complete your setup based on this.
     */
    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
    	proxy.postInit(e);
    	
    	//player.openGui(Tiny.instance, 0, world, x, y, z);
    }
    
    public static CreativeTabs creativeTab = new CreativeTabs("adventureMod") {
        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return Items.emerald;
        }
    };
    
    @Instance("AdventureMod")
	public static AdventureMod instance;
}
