package Post;

import java.sql.Connection;

public class PostService {

	public int write(PostVo vo) {
		
		if(vo.getTitle().length() < 1) {
			return -1;
		}
		
		if(vo.getContent().length() < 1) {
			return -2;
		}
		
		Connection conn = null;
		
		int result = 0;
		

		try {
			conn = getConnection();
			result = new PostDao().write(vo, conn);
			
			if(result == 1) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
		}catch(Exception e) {
			rollback(conn);
		}finally {
			close(conn);
		}
		
		return result;
	}
	
			
}
