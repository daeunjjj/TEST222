package trip.hyewon.lodging;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import trip.hyewon.common.JDBCTemplate;

public class LodgingDao {

	//숙소 검색
	public List<LodgingVo> showLodgingList(Connection conn, LodgingReservationVo vo) throws Exception {
		
		String locationCode = vo.getLocationCode();
		String startDate = vo.getStartDate();
		String endDate = vo.getEndDate();
		String headCount = vo.getPeople();
				
		String sql = "SELECT DISTINCT(LI.NO), LI.NAME, LI.ADDRESS FROM LODGING_INFORMATION LI JOIN ROOM R ON LI.NO = R.LODGING_NO WHERE LOCATION_CODE = ? AND R.MAX_PEOPLE >= ? AND R.NO NOT IN (SELECT R.NO FROM LODGING_INFORMATION LI JOIN ROOM R ON LI.NO = R.LODGING_NO JOIN LODGING_RESERVATION LR ON R.NO = LR.ROOM_NO AND ((LR.START_DATE >= TO_DATE(?) AND LR.START_DATE < TO_DATE(?)) OR (LR.END_DATE > TO_DATE(?) AND LR.END_DATE <= TO_DATE(?)) OR (LR.START_DATE < TO_DATE(?) AND LR.END_DATE > TO_DATE(?)))) ORDER BY LI.NO";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<LodgingVo> lodgingVoList = new ArrayList<LodgingVo>();
		
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(locationCode));
			pstmt.setInt(2, Integer.parseInt(headCount));
			pstmt.setString(3, startDate);
			pstmt.setString(4, endDate);
			pstmt.setString(5, startDate);
			pstmt.setString(6, endDate);
			pstmt.setString(7, startDate);
			pstmt.setString(8, endDate);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("NO");
				String name = rs.getString("NAME");
				String address = rs.getString("ADDRESS");
				
				LodgingVo lodgingVo = new LodgingVo();
				lodgingVo.setNo(Integer.toString(no));
				lodgingVo.setName(name);
				lodgingVo.setAddress(address);
		
				lodgingVoList.add(lodgingVo);
			}

		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return lodgingVoList;
		
	}

	//추천 숙소 조회
	public List<LodgingVo> showRecommendLodgingList(Connection conn) throws Exception {
		String sql = "SELECT NO, NAME, ADDRESS FROM LODGING_INFORMATION WHERE NO IN (SELECT COUNT(LODGING_NO) FROM LODGING_REVIEW LR JOIN LODGING_INFORMATION LI ON LR.LODGING_NO = LI.NO GROUP BY LODGING_NO ORDER BY COUNT(LR.LODGING_NO) DESC OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY)";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<LodgingVo> lodgingVoList = new ArrayList<LodgingVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("NO");
				String name = rs.getString("NAME");
				String address = rs.getString("ADDRESS");
				
				LodgingVo lodgingVo = new LodgingVo();
				lodgingVo.setNo(Integer.toString(no));
				lodgingVo.setName(name);
				lodgingVo.setAddress(address);
		
				lodgingVoList.add(lodgingVo);
			}

		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return lodgingVoList;
	}

	//인기 숙소 조회
	public List<LodgingVo> showPopularLodgingList(Connection conn) throws Exception {

		String sql = "SELECT * FROM LODGING_INFORMATION ORDER BY LODGING_LIKE DESC OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<LodgingVo> lodgingVoList = new ArrayList<LodgingVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("NO");
				String name = rs.getString("NAME");
				String address = rs.getString("ADDRESS");
				
				LodgingVo lodgingVo = new LodgingVo();
				lodgingVo.setNo(Integer.toString(no));
				lodgingVo.setName(name);
				lodgingVo.setAddress(address);
		
				lodgingVoList.add(lodgingVo);
			}

		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return lodgingVoList;
	}

}
