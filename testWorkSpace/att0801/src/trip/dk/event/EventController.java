package trip.dk.event;

import java.sql.Timestamp;
import java.util.List;

import trip.dk.menu.Menu;

public class EventController {
	
	public void showEventList() {
		
		List<EventVo> eventVoList = new EventService().showList();
		System.out.println( " ----- 현재 진행중인 이벤트 ----- ");
		for(int i = 0; i<eventVoList.size();++i) {
			
			EventVo temp = eventVoList .get(i);
			int no = temp.getNo();
			Timestamp startDate = temp.getStartDate();
			Timestamp endDate = temp.getEndDate();
			
			if(no==1) {
				System.out.println( no +" 가위바위보 게임" + " | 이벤트 기간 : "+ startDate +" ~ "+ endDate );
			}
			if(no==2) {
				System.out.println( no +" UP & DOWN 게임" + " | 이벤트 기간 : "+ startDate +" ~ "+ endDate );
			}
			
		}
		
		// 참여 할 게임 물어보기.
		int gameNo = new Menu().eventGame();
		// 출력문 입력받기.
		
		if(gameNo == 1) {
			// 가위바위보 게임 
			
		}
		if(gameNo == 2) {
			// UP&DOWN 게임
		}
		
	}//showEventList
	
	
	


}
