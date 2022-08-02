package trip.min.main;

import trip.min.main.Main;
import trip.min.util.InputUtil;

public class Menu {

	public int showMenu() {
		
		System.out.println("\n----- 로그인 메뉴 -----");
		if(Main.LoginMember != null) {
			//로그인 후
			showLoginMenu();
		}else {
			//로그인 전
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 아이디, 비밀번호 찾기");
			System.out.println("4. 여행커뮤니티 글 목록 조회");
			System.out.println("5. 프로그램 종료");
		}
		
		return InputUtil.getInt();
		
		
	}
	
	public int showLoginMenu() {
		
		System.out.println("\n----- 원하시는정보를 입력하세요 -----");
		if(Main.LoginMember != null) {
			//로그인 후
			System.out.println(Main.LoginMember.getNick() +" 님 반갑습니다.");
			System.out.println("1. 숙소 검색");
			System.out.println("2. 추천 숙소 조회");
			System.out.println("3. 인기 숙소 조회");
			System.out.println("4. 여행 커뮤니티");
			System.out.println("5. 마이페이지");
			System.out.println("6. 이벤트");
			System.out.println("7. 고객센터");
			System.out.println("8. 로그아웃(종료)");
			System.out.println("9. 관리자페이지");
		
		}
		
		return InputUtil.getInt();
	
	}
	
}
