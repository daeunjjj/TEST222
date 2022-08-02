package Post;

import util.Util;

public class PostController {

	/*
	 * 1. 게시글 작성
	 * 2. 게시글 수정
	 * 3. 게시글 삭제
	 * 4. 댓글 작성
	 * 5. 댓글 수정
	 * 6. 댓글 삭제
	 */
	
	public void postWrite() {
		
		System.out.println("로그인을 먼저 해주세요.\n\n");
		
		System.out.println("\n----- 게시글 작성 -----");
		
		// 데이터 받기
		System.out.print("제목 : ");
		String title = Util.sc.nextLine();
		System.out.print("내용 : ");
		String content = Util.sc.nextLine();
		
		int memberNo = 5;
		
		// 데이터 뭉치기
		PostVo vo = new PostVo();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(memberNo);
		
		int result = new PostService().write(vo);
		
		// insert 결과에 따라 로직 처리
		if(result == 1) {
			// 글 작성 성공
			System.out.println("게시글 작성 성공!\n\n");
		}else {
			//글 작성 실패
			System.out.println("게시글 작성 실패...");
		}
		
		
	}//postWrite
	
	
	
}// class
