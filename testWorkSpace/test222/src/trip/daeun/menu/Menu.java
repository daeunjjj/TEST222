package trip.daeun.menu;

import trip.daeun.utill.InputUtill;

public class Menu {

	public int showMenu() {
		
		System.out.println("1. 예약하기");
		System.out.println("2. 찜하기");
		System.out.println("3. 찜하기 취소");
		System.out.println("4. 숙소 리뷰 보기");
		System.out.println("5. 리스트로 돌아가기");
	
		return InputUtill.getInt();
		
	}
	
	
	
	
	
}
