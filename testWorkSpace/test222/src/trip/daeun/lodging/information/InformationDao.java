package trip.daeun.lodging.information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import trip.daeun.lodging.common.JDBCTemplate;


public class InformationDao {
	public List<InformationVo> showList(Connection conn) throws Exception {

		// CONN 준비

		// SQL 준비
		String sql = "SELECT L.NAME , T.R_TYPE , R.PRICE , L.BREAKFAST_YN , L.ADDRESS FROM LODGING_INFORMATION L JOIN ROOM R ON L.NO = R.LODGING_NO JOIN ROOM_TYPE T ON R.ROOM_CODE = T.CODE";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<InformationVo> informationVoList = new ArrayList<InformationVo>();

		try {
			// SQL 담을 객체 준비 및 SQL 완성
			pstmt = conn.prepareStatement(sql);

			// SQL 실행 및 결과 저장
			rs = pstmt.executeQuery();

			// 커서 내리고, 칼럼별로 읽어오기, 객체로 만들기 반복

			while (rs.next()) {
				String name = rs.getString("NAME");
				String room = rs.getString("R_TYPE");
				int price = rs.getInt("PRICE");
				String breakfast = rs.getString("BREAKFAST_YN");
				String address = rs.getString("ADDRESS");
				

				InformationVo vo = new InformationVo();
				vo.setName(name);
				vo.setRoom(room);
				vo.setPrice(price);
				vo.setBreakfast(breakfast);
				vo.setAddress(address);

				informationVoList.add(vo);
			}

		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}

		// SQL 실행 결과 리턴
		return informationVoList;

	}
}
