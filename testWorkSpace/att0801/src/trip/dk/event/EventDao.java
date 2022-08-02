package trip.dk.event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import trip.dk.common.JDBCTemplate;

public class EventDao {
	

	public List<EventVo> showEventList(Connection conn) throws Exception {
		//CONN 준비
		//SQL 준비
		String sql = "SELECT NO,START_DATE,END_DATE FROM EVENT";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<EventVo> eventVoList = new ArrayList<EventVo>();
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("no");
				Timestamp startDate = rs.getTimestamp("START_DATE");
				Timestamp endDate = rs.getTimestamp("END_DATE");
				
				EventVo vo = new EventVo();
				vo.setNo(no);
				vo.setStartDate(startDate);
				vo.setEndDate(endDate);
				
				eventVoList.add(vo);
				
			}
			
		} finally {
			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
	return eventVoList;	
	}

}
