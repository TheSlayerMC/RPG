package net.rpg.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.rpg.RPG;
import net.rpg.container.ContainerStats;

public class GuiMerchant extends GuiContainer{

	private static ResourceLocation texture = new ResourceLocation("rpg:textures/gui/merchant.png");

	private EntityPlayer p = Minecraft.getMinecraft().thePlayer;

	public GuiMerchant(EntityPlayer p) {
		super(new ContainerStats(p));
	}

	@Override
	protected void func_146979_b(int arg1, int arg2) {
		String s = "Merchant";
		this.field_146289_q.drawString(s, this.field_146999_f / 2 - this.field_146289_q.getStringWidth(s) / 2 - 20, 6 - 25, 4210752);
		s = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
		String credits;

		if(RPG.credits == 0)
			credits = "Credits: " + EnumChatFormatting.RED + RPG.credits;
		else if(RPG.credits < 30)
			credits = "Credits: " + EnumChatFormatting.YELLOW + RPG.credits;
		else
			credits = "Credits: " + EnumChatFormatting.GREEN + RPG.credits;

		s = credits;
		this.field_146289_q.drawString(s, this.field_146999_f / 2 - this.field_146289_q.getStringWidth(s) / 2 + 50, 6 - 25, 4210752);
		s = EnumChatFormatting.YELLOW + "Discount: " + EnumChatFormatting.WHITE + RPG.discount + "%";
		this.field_146289_q.drawString(s, this.field_146999_f / 2 - this.field_146289_q.getStringWidth(s) / 2 - 90, 6 - 25, 4210752);
	}

	@Override
	public void initGui() {
		super.initGui();
		page1();
	}

	@Override
	protected void func_146976_a(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.field_146297_k.getTextureManager().bindTexture(texture);
		this.field_146999_f = 220;
		this.field_147000_g = 220;
		int k = (this.field_146294_l - this.field_146999_f) / 2;
		int l = (this.field_146295_m - this.field_147000_g) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.field_146999_f, this.field_147000_g);
	}

	@Override
	protected void func_146284_a(GuiButton button) {
		switch(button.field_146127_k) {
		case 1: 
			buy(Items.arrow, 1, 7);
			return;
		case 2:
			buy(Items.diamond, 1, 100);
			return;
		case 3:
			buy(Items.gold_ingot, 1, 50);
			return;
		case 4:
			buy(Items.iron_ingot, 1, 70);
			return;
		case 5:
			buy(Items.golden_apple, 1, 100);
			return;
		case 6:
			buy(Items.golden_apple, 1, 300);
			return;
		case 7:
			buy(Items.string, 1, 3);
			return;
		case 9:
			buy(Items.diamond_sword, 1, 200);
			return;
		case 10:
			buy(Items.golden_sword, 1, 100);
			return;
		case 11:
			buy(Item.func_150898_a(Blocks.diamond_block), 1, 800);
			return;
		case 12:
			buy(Item.func_150898_a(Blocks.beacon), 1, 900);
			return;
		case 13:
			buy(Item.func_150898_a(Blocks.dragon_egg), 1, 1500);
			return;
		case 14:
			buy(Items.ender_pearl, 1, 50);
			return;
		case 15:
			buy(Items.ender_eye, 1, 200);
			return;
		case 16:
			buy(Items.blaze_rod, 1, 250);
			return;
		case 17:
			buy(Items.blaze_powder, 1, 125);
			return;
		case 18:
			buy(Items.slime_ball, 1, 50);
			return;
		case 19:
			buy(Items.lead, 1, 75);
			return;
		case 20:
			buy(Items.golden_horse_armor, 1, 200);
			return;
		case 21:
			buy(Items.stick, 1, 5);
			return;
		case 22:
			buy(Items.nether_star, 1, 500);
			return;
		case 23:
			buy(Items.iron_sword, 1, 100);
			return;
		case 24:
			buy(Items.wooden_sword, 1, 50);
			return;
		case 25:
			buy(Items.diamond_helmet, 1, 500);
			return;
		case 26:
			buy(Items.diamond_chestplate, 1, 800);
			return;
		case 27:
			buy(Items.diamond_leggings, 1, 700);
			return;
		case 28:
			buy(Items.diamond_boots, 1, 400);
			return;
		case 29:
			page2();
			return;
		case 30:
			page1();
			return;
		}
	}

	public void buy(Item i, int amount, int cost){
		if(RPG.credits > 0)
			p.inventory.addItemStackToInventory(new ItemStack(i, amount));
		useCredits(cost);
	}
	
	public int useCredits(int howMany){
		if(RPG.credits < 0)
			return RPG.credits -= howMany;
		else if(RPG.credits <= 0)
			return RPG.credits = 0;
		return howMany;
	}

	private void page1() {
		this.field_146292_n.clear();
		final int x = this.field_146294_l / 2 - 100;
		final int w = 96;
		final int h = 20;
		addButton(new GuiButton(1, x, 86, w, h, "Arrow"));
		addButton(new GuiButton(2, x, 107, w, h, "Diamond"));
		addButton(new GuiButton(3, x, 128, w, h, "Gold Ingot"));
		addButton(new GuiButton(4, x, 149, w, h, "Iron Ingot"));
		addButton(new GuiButton(5, x, 170, w, h, "Golden Apple"));
		addButton(new GuiButton(6, x, 191, w, h, "OP Apple"));
		addButton(new GuiButton(7, x, 212, w, h, "String"));
		addButton(new GuiButton(8, x + 103, 86, w, h, "Bow"));
		addButton(new GuiButton(9, x + 103, 107, w, h, "Diamond Sword"));
		addButton(new GuiButton(10, x + 103, 128, w, h, "Golden Sword"));
		addButton(new GuiButton(11, x + 103, 149, w, h, "Diamond Block"));
		addButton(new GuiButton(12, x + 103, 170, w, h, "Beacon"));
		addButton(new GuiButton(13, x + 103, 191, w, h, "Dragon Egg"));
		addButton(new GuiButton(14, x + 103, 212, w, h, "Ender Pearl"));
		addMoveButtons();
	}

	private void page2() {
		this.field_146292_n.clear();
		final int x = this.field_146294_l / 2 - 100;
		final int w = 96;
		final int h = 20;
		addButton(new GuiButton(15, x, 86, w, h, "Ender Eye"));
		addButton(new GuiButton(16, x, 107, w, h, "Blaze Rod"));
		addButton(new GuiButton(17, x, 128, w, h, "Blaze Powder"));
		addButton(new GuiButton(18, x, 149, w, h, "Slime Ball"));
		addButton(new GuiButton(19, x, 170, w, h, "Lead"));
		addButton(new GuiButton(20, x, 191, w, h, "Gold Horse Armor"));
		addButton(new GuiButton(21, x, 212, w, h, "Stick"));
		addButton(new GuiButton(22, x + 103, 86, w, h, "Nether Star"));
		addButton(new GuiButton(23, x + 103, 107, w, h, "Iron Sword"));
		addButton(new GuiButton(24, x + 103, 128, w, h, "Wood Sword"));
		addButton(new GuiButton(25, x + 103, 149, w, h, "Diamond Helmet"));
		addButton(new GuiButton(26, x + 103, 170, w, h, "Diamond Chestplate"));
		addButton(new GuiButton(27, x + 103, 191, w, h, "Diamond Leggings"));
		addButton(new GuiButton(28, x + 103, 212, w, h, "Diamond Boots"));
		addMoveButtons();
	}

	private void addMoveButtons() {
		addButton(new GuiButton(29, this.field_146294_l / 2 + 3, 255, 96, 20, ">>>"));
		addButton(new GuiButton(30, this.field_146294_l / 3 + 15, 255, 96, 20, "<<<"));
	}

	private void addButton(GuiButton b) {
		this.field_146292_n.add(b);
	}
}