package trip.min.main;

import trip.min.member.MemberController;
import trip.min.member.MemberVo;

public class Main {

	//로그인 멤버 변수 만들기 (전역으로)
	public static MemberVo LoginMember;
	
	public static void main(String[] args) {
		/* 실행시킬때 주의 사항
		 * JDBCTemplate 가서 
		 * url localhost 아닌사람!
		 * 본인 아이피로 변경
		 * 포트값이 다르다면 그것도 변경
		 * 후 실행
		 */
		System.out.println("======== 환영합니다 ========");
		System.out.println("===== A to Trip 입니다 =====");
		
		Menu menu = new Menu();
		
		while(true) {
			int input = menu.showMenu();
			
			switch(input) {
			case 1:
				//로그인
				new MemberController().login();
				break;
			case 2:
				//회원가입
				new MemberController().join();
				break;
			case 3:
				//아이디, 비밀번호 찾기
				System.out.println("아이디, 비번찾기");
				break;
			case 4:
				//여행커뮤니티 글 목록 보기
				System.out.println("여행 커뮤니티 글 목록 보기");
				break;
			case 5:
				//프로그램 종료
				System.out.println("프로그램을 종료합니다.");
				return;
			}//switch
			
		}//while
		
	}//main

}//class
