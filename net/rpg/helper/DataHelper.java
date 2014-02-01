package net.rpg.helper;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.minecraftforge.common.config.Configuration;
import net.rpg.RPG;
import net.rpg.network.PacketStatsToClient;

public class DataHelper {
	private static Configuration data;

	public static void load(World w) {
		if(Minecraft.getMinecraft().isSingleplayer()) {
			data = new Configuration(new File("./saves/" + w.getWorldInfo().getWorldName() + "/rpgdata.dat"), true);
		} else {
			data = new Configuration(new File("./" + w.getWorldInfo().getWorldName() + "/rpgdata.dat"), true);
		}
		data.load();
	}

	public static void save() {
		data.save();
	}

	public static void loadPlayer(EntityPlayer player) {
		data.get(player.getDisplayName(), "Race", -1);
		data.get(player.getDisplayName(), "Max Health", 10);
		data.get(player.getDisplayName(), "Max Divine Energy", 20);
		data.get(player.getDisplayName(), "Credits", 0);
		data.get(player.getDisplayName(), "Attack", 0);
		data.get(player.getDisplayName(), "Defense", 0);
	}

	public static void setRace(EntityPlayer player, int race) {
		data.get(player.getDisplayName(), "Race", -1).set(race);
		save();
		PacketStatsToClient ps = new PacketStatsToClient();
		ps.race = DataHelper.getRace(player);
		ps.maxHp = DataHelper.getMaxHp(player);
		ps.de = DataHelper.getDe(player);
		ps.maxDe = DataHelper.getMaxDe(player);
		ps.credits = DataHelper.getCredits(player);
		ps.attack = DataHelper.getAttack(player);
		ps.defense = DataHelper.getDefense(player);
		RPG.packetHandler.sendTo(ps, (EntityPlayerMP) player);
		RPG.applyStats(player);
	}

	public static int getRace(EntityPlayer player) {
		return data.get(player.getDisplayName(), "Race", -1).getInt();
	}

	public static void setMaxHp(EntityPlayer player, int maxHp) {
		data.get(player.getDisplayName(), "Max Health", 10).set(maxHp);
		save();
		PacketStatsToClient ps = new PacketStatsToClient();
		ps.race = DataHelper.getRace(player);
		ps.maxHp = DataHelper.getMaxHp(player);
		ps.de = DataHelper.getDe(player);
		ps.maxDe = DataHelper.getMaxDe(player);
		ps.credits = DataHelper.getCredits(player);
		ps.attack = DataHelper.getAttack(player);
		ps.defense = DataHelper.getDefense(player);
		RPG.packetHandler.sendTo(ps, (EntityPlayerMP) player);
		RPG.applyStats(player);
	}

	public static int getMaxHp(EntityPlayer player) {
		return data.get(player.getDisplayName(), "Max Health", 10).getInt();
	}

	public static void setDe(EntityPlayer player, int de) {
		data.get(player.getDisplayName(), "Divine Energy", 20).set(de);
		save();
		PacketStatsToClient ps = new PacketStatsToClient();
		ps.race = DataHelper.getRace(player);
		ps.maxHp = DataHelper.getMaxHp(player);
		ps.de = DataHelper.getDe(player);
		ps.maxDe = DataHelper.getMaxDe(player);
		ps.credits = DataHelper.getCredits(player);
		ps.attack = DataHelper.getAttack(player);
		ps.defense = DataHelper.getDefense(player);
		RPG.packetHandler.sendTo(ps, (EntityPlayerMP) player);
		RPG.applyStats(player);
	}

	public static int getDe(EntityPlayer player) {
		return data.get(player.getDisplayName(), "Divine Energy", 20).getInt();
	}

	public static void setMaxDe(EntityPlayer player, int maxDe) {
		data.get(player.getDisplayName(), "Max Divine Energy", 20).set(maxDe);
		save();
		PacketStatsToClient ps = new PacketStatsToClient();
		ps.race = DataHelper.getRace(player);
		ps.maxHp = DataHelper.getMaxHp(player);
		ps.de = DataHelper.getDe(player);
		ps.maxDe = DataHelper.getMaxDe(player);
		ps.credits = DataHelper.getCredits(player);
		ps.attack = DataHelper.getAttack(player);
		ps.defense = DataHelper.getDefense(player);
		RPG.packetHandler.sendTo(ps, (EntityPlayerMP) player);
		RPG.applyStats(player);
	}

	public static int getMaxDe(EntityPlayer player) {
		return data.get(player.getDisplayName(), "Max Divine Energy", 20).getInt();
	}

	public static void setCredits(EntityPlayer player, int amt) {
		data.get(player.getDisplayName(), "Credits", 0).set(amt);
		save();
		PacketStatsToClient ps = new PacketStatsToClient();
		ps.race = DataHelper.getRace(player);
		ps.maxHp = DataHelper.getMaxHp(player);
		ps.de = DataHelper.getDe(player);
		ps.maxDe = DataHelper.getMaxDe(player);
		ps.credits = DataHelper.getCredits(player);
		ps.attack = DataHelper.getAttack(player);
		ps.defense = DataHelper.getDefense(player);
		RPG.packetHandler.sendTo(ps, (EntityPlayerMP) player);
		RPG.applyStats(player);
	}

	public static int getCredits(EntityPlayer player) {
		return data.get(player.getDisplayName(), "Credits", 0).getInt();
	}

	public static void setAttack(EntityPlayer player, int amt) {
		data.get(player.getDisplayName(), "Attack", 0).set(amt);
		save();
		PacketStatsToClient ps = new PacketStatsToClient();
		ps.race = DataHelper.getRace(player);
		ps.maxHp = DataHelper.getMaxHp(player);
		ps.de = DataHelper.getDe(player);
		ps.maxDe = DataHelper.getMaxDe(player);
		ps.credits = DataHelper.getCredits(player);
		ps.attack = DataHelper.getAttack(player);
		ps.defense = DataHelper.getDefense(player);
		RPG.packetHandler.sendTo(ps, (EntityPlayerMP) player);
		RPG.applyStats(player);
	}

	public static int getAttack(EntityPlayer player) {
		return data.get(player.getDisplayName(), "Attack", 0).getInt();
	}

	public static void setDefense(EntityPlayer player, int amt) {
		data.get(player.getDisplayName(), "Defense", 0).set(amt);
		save();
		PacketStatsToClient ps = new PacketStatsToClient();
		ps.race = DataHelper.getRace(player);
		ps.maxHp = DataHelper.getMaxHp(player);
		ps.de = DataHelper.getDe(player);
		ps.maxDe = DataHelper.getMaxDe(player);
		ps.credits = DataHelper.getCredits(player);
		ps.attack = DataHelper.getAttack(player);
		ps.defense = DataHelper.getDefense(player);
		RPG.packetHandler.sendTo(ps, (EntityPlayerMP) player);
		RPG.applyStats(player);
	}

	public static int getDefense(EntityPlayer player) {
		return data.get(player.getDisplayName(), "Defense", 0).getInt();
	}
}