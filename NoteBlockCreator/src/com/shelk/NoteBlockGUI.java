package com.shelk;

import org.bukkit.Note;
import org.bukkit.block.NoteBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.shelk.utils.SlotToNote;

public class NoteBlockGUI implements Listener {

	@EventHandler
	public void onGuiClick(InventoryClickEvent e) {
		if (e.getInventory().getHolder() instanceof NoteBlockHolder) {
			e.setCancelled(true);
			if (e.getCurrentItem() != null && e.getRawSlot() < 36) {
				int slot = e.getSlot();
				byte note = (byte) SlotToNote.slotToNote(slot);
				NoteBlockHolder holder = (NoteBlockHolder) e.getInventory().getHolder();
				holder.getNoteBlock().setRawNote(note);
				holder.getNoteBlock().update();
				holder.getNoteBlock().play();
				
			}
		}
	}

}
