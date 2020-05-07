package com.shelk;

import org.bukkit.block.NoteBlock;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class NoteBlockHolder implements InventoryHolder {

	public NoteBlock block;
	
	@Override
	public Inventory getInventory() {
		return null;
	}
	
	public void setNoteBlock(NoteBlock b) {
		this.block = b;
	}
	
	public NoteBlock getNoteBlock() {
		return this.block;
	}

}
