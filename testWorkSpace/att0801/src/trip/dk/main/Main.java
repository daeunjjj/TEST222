package trip.dk.main;

import trip.dk.event.EventController;
import trip.dk.menu.Menu;

public class Main {

	public static void main(String[] args) {

		Menu menu = new Menu();
		
		int input = menu.showmenu();
		
		switch(input) {
		case 6:
			new EventController().showEventList();
			break;
			
		default:
		}
		
	}

}
