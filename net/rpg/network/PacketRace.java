package net.rpg.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemBow;
import net.rpg.RPG;
import net.rpg.helper.DataHelper;
import net.rpg.helper.ItemHelper;

public class PacketRace extends AbstractPacket {
	public int race;

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		buffer.writeInt(race);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		race = buffer.readInt();
		new ItemBow();
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
	}

	@Override
	public void handleServerSide(EntityPlayer player) {
		DataHelper.setRace(player, race);
		if(player.inventory.func_146028_b(ItemHelper.getItem("raceStone"))) {
			player.inventory.func_146026_a(ItemHelper.getItem("raceStone"));
		}
		PacketStatsToClient ps = new PacketStatsToClient();
		ps.race = DataHelper.getRace(player);
		ps.maxHp = DataHelper.getMaxHp(player);
		ps.de = DataHelper.getDe(player);
		ps.maxDe = DataHelper.getMaxDe(player);
		ps.credits = DataHelper.getCredits(player);
		ps.attack = DataHelper.getAttack(player);
		ps.defense = DataHelper.getDefense(player);
		RPG.packetHandler.sendTo(ps, (EntityPlayerMP) player);
	}
}