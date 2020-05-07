package com.shelk;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.NoteBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import com.shelk.utils.XMaterial;

public class NoteBlockCreator extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);
		Bukkit.getPluginManager().registerEvents(new NoteBlockGUI(), this);
	}

	@Override
	public void onDisable() {

	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock() != null
				&& e.getClickedBlock().getType() == Material.NOTE_BLOCK && !e.getPlayer().isSneaking()) {
				e.setCancelled(true);
				openGui(e.getPlayer(), e.getClickedBlock());
			
		}
	}

	public void openGui(Player p, Block noteBlock) {
		NoteBlockHolder holder = new NoteBlockHolder();
		holder.setNoteBlock((NoteBlock) noteBlock.getState());
		Inventory gui = Bukkit.createInventory(holder, 36, "§dCustomize noteblocks");
		int x = 0;
		for (int i = 1; i < 3; i++) {
			gui.setItem(1 + x, getItemStack(XMaterial.WHITE_WOOL, i + " Sol"));
			gui.setItem(2 + x, getItemStack(XMaterial.WHITE_WOOL, i + " La"));
			gui.setItem(3 + x, getItemStack(XMaterial.WHITE_WOOL, i + " Si"));
			gui.setItem(4 + x, getItemStack(XMaterial.WHITE_WOOL, i + " Do"));
			gui.setItem(5 + x, getItemStack(XMaterial.WHITE_WOOL, i + " Ré"));
			gui.setItem(6 + x, getItemStack(XMaterial.WHITE_WOOL, i + " Mi"));
			gui.setItem(7 + x, getItemStack(XMaterial.WHITE_WOOL, i + " Fa"));

			gui.setItem(10 + x, getItemStack(XMaterial.BLACK_WOOL, i + " Fa#"));
			gui.setItem(11 + x, getItemStack(XMaterial.BLACK_WOOL, i + " Sol#"));
			gui.setItem(12 + x, getItemStack(XMaterial.BLACK_WOOL, i + " La#"));

			gui.setItem(14 + x, getItemStack(XMaterial.BLACK_WOOL, i + " Do#"));
			gui.setItem(15 + x, getItemStack(XMaterial.BLACK_WOOL, i + " Ré#"));
			// octave 2
			x = 18;
		}
		gui.setItem(35, getItemStack(XMaterial.BLACK_WOOL, "3 Fa#"));
		p.openInventory(gui);
	}

	public static ItemStack getItemStack(XMaterial m, String s) {
		ItemStack is = m.parseItem();
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(s);
		is.setItemMeta(im);
		return is;
	}

}
