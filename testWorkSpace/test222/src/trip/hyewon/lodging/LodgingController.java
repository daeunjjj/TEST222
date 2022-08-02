package trip.hyewon.lodging;

import java.util.List;

import trip.hyewon.util.InputUtil;

public class LodgingController {

	//숙소 검색
	public void searchLodging() {
		System.out.println("\n----- 숙소 검색 -----");
	
		String location = null;
		while(true) {
			System.out.println("지역을 선택해주세요");
			System.out.println("1. 수도권");
			System.out.println("2. 강원도");
			System.out.println("3. 경상도");
			System.out.println("4. 충청도");
			System.out.println("5. 전라도");
			System.out.println("6. 제주도");
			
			System.out.print("입력 : ");
			location = InputUtil.sc.nextLine();
			
			if(checkLocationNum(location)) {
				break;
			}else {
				System.out.println("\n잘못된 입력입니다.\n");
			}
		}
		
		String startDate = null;
		while(true) {
			System.out.println("\n입실날짜를 입력해주세요(yy/mm/dd)");
			System.out.print("입력 : ");
			startDate = InputUtil.sc.nextLine();
			
			if(checkDate(startDate)) {
				break;
			}else {
				System.out.println("\n잘못된 입력입니다.\n");
			}
		}
		
		String endDate = null;
		while(true) {
			System.out.println("\n퇴실날짜를 입력해주세요(yy/mm/dd)");
			System.out.print("입력 : ");
			endDate = InputUtil.sc.nextLine();
			
			if(checkDate(endDate) && checkEndDate(startDate, endDate)) {
				break;
			}else {
				System.out.println("\n잘못된 입력입니다.\n");
			}
		}
		
		String headCount = null;
		while(true) {
			try {
				System.out.println("\n인원 수를 입력해주세요(최대 6명)");
				System.out.print("입력 : ");
				headCount = InputUtil.sc.nextLine();
				if(checkMaxPeople(headCount)) {
					break;
				}else {
					System.out.println("\n잘못된 입력입니다.\n");
				}
				
			}catch(Exception e) {
				System.out.println("\n숫자만 입력하세요!\n");
			}
			
		}
		
		LodgingReservationVo vo = new LodgingReservationVo();
		
		vo.setLocationCode(location);
		vo.setStartDate(startDate);
		vo.setEndDate(endDate);
		vo.setPeople(headCount);
		
		List<LodgingVo> lodgingVoList = new LodgingService().showLodgingList(vo);
		System.out.println("\n----- 숙소 목록 -----");
		for(int i=0; i<lodgingVoList.size(); i++) {
			LodgingVo temp = lodgingVoList.get(i);
			
			String no = temp.getNo();
			String name = temp.getName();
			String address = temp.getAddress();
			
			System.out.println(no + " | " + name + " | " + address);
		}
		
	}
	
	public boolean checkLocationNum(String location) {
		return new LodgingService().checkLocationNum(location);
	}
	
	public boolean checkDate(String date) {
		return new LodgingService().checkDate(date);
	}
	
	public boolean checkEndDate(String startDate, String endDate) {
		return new LodgingService().checkEndDate(startDate, endDate);
	}
	
	public boolean checkMaxPeople(String headCount) {
		return new LodgingService().checkMaxPeople(headCount);
	}
	
	//추천 숙소 조회
	public void showRecommendLodging() {
		List<LodgingVo> lodgingVoList = new LodgingService().showRecommendLodgingList();
		System.out.println("\n----- 추천 숙소 목록 -----");
		for(int i=0; i<lodgingVoList.size(); i++) {
			LodgingVo temp = lodgingVoList.get(i);
			
			String no = temp.getNo();
			String name = temp.getName();
			String address = temp.getAddress();
			
			System.out.println(no + " | " + name + " | " + address);
		}
	}

	//인기 숙소 조회
	public void showPopularLodging() {
		List<LodgingVo> lodgingVoList = new LodgingService().showPopularodgingList();
		System.out.println("\n----- 인기 숙소 목록 -----");
		for(int i=0; i<lodgingVoList.size(); i++) {
			LodgingVo temp = lodgingVoList.get(i);
			
			String no = temp.getNo();
			String name = temp.getName();
			String address = temp.getAddress();
			
			System.out.println(no + " | " + name + " | " + address);
		}
	}

}

