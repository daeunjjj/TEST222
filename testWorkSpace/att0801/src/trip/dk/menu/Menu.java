package trip.dk.menu;

import trip.dk.util.InputUtil;

public class Menu {
	
	public int showmenu() {
		
		System.out.println("------ 메인 메뉴 ------");
		System.out.println("6. 이벤트");
		
		
		
		return InputUtil.getInt();
	}
	
	public int eventGame() {
		System.out.println();
		System.out.println("참여할 게임을 선택 해주세요.");
		return InputUtil.getInt();
		
	}
	
}
