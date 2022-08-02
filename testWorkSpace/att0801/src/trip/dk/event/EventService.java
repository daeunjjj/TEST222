package trip.dk.event;

import java.sql.Connection;
import java.util.List;

import trip.dk.common.JDBCTemplate;


public class EventService {
	//이벤트 조회 
	public List<EventVo> showList() {
		Connection conn = null;
		List<EventVo> boardVoList = null;
		try {
			conn = JDBCTemplate.getConnection();
			boardVoList =new EventDao().showEventList(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		
		return boardVoList;
	}
	

	
	
	

}
