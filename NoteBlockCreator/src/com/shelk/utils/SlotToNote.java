package com.shelk.utils;

public class SlotToNote {

	public static int slotToNote(int slot) {
		switch(slot) {
		// octave 1 
			case 1: return 1;
			case 2: return 3;
			case 3: return 5;
			case 4: return 6;
			case 5: return 8;
			case 6: return 10;
			case 7: return 11;
		
			case 10: return 0;
			case 11: return 2;
			case 12: return 4;
		
			case 14: return 7;
			case 15: return 9;
		// octave 2
			case 19: return 13;
			case 20: return 15;
			case 21: return 17;
			case 22: return 18;
			case 23: return 20;
			case 24: return 22;
			case 25: return 23;
			
			case 28: return 12;
			case 29: return 14;
			case 30: return 16;
			
			case 32: return 19;
			case 33: return 21;
			
			case 35: return 24;
			
		
			default: return 0;
		}
		
	}
	
}
