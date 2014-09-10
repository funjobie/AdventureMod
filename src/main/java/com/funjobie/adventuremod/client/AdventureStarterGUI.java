package com.funjobie.adventuremod.client;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.funjobie.adventuremod.AdventureMod;
import com.funjobie.adventuremod.common.AdventureStarterContainer;
import com.funjobie.adventuremod.common.AdventureStarterTileEntity;

public class AdventureStarterGUI extends GuiContainer
{

	public AdventureStarterGUI(InventoryPlayer inventoryPlayer, AdventureStarterTileEntity tileEntity)
	{
		// the container is instanciated and passed to the superclass for
		// handling
		super(new AdventureStarterContainer(inventoryPlayer, tileEntity));
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2)
	{
		// draw text and stuff here
		// the parameters for drawString are: string, x, y, color

		// fontRendererObj.drawString("Tiny", 8, 6, 4210752);

		// draws "Inventory" or your regional equivalent

		// fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"),
		// 8, ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	{
		// draw your Gui here, only thing you need to change is the path
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(new ResourceLocation(AdventureMod.MODID + ":/gui/AdventureStarterBlock.png"));
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_CLAMP);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_CLAMP);
		// int x = (width - xSize) / 2;
		// int y = (height - ySize) / 2;
		// this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
		// TODO: fix position on screen. now fine for fullscreen but not ok for
		// windowed.
		int x = (width - xSize) / 3;
		int y = (height - ySize) / 3;
		this.drawTexturedModalRect(x, y, 0, 0, 512, 512);
	}

}