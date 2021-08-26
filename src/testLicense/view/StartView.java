package testLicense.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import testLicenseController.TestLicenseController;

public class StartView {
	
	public static void main(String[] args) throws ParseException {

		TestLicenseController controller = TestLicenseController.getInstance();


		System.out.println("\n♨시나리오 1 : 코로나 상황으로 인해 시험 일정에 많은 변화가 생겼다.");
		System.out.println("");
		
		System.out.println("\n▶1) SQL 응시료가 5만원에서 2만원으로 변경되었습니다.");
		controller.updateFee(8, 20000);
		
		System.out.println("\n▶2) 인기있는 타로심리상담사자격증 시험이 1회 추가되었습니다.");
		controller.updateTest("타로심리상담사1급 41회", 85000, new SimpleDateFormat("yyyy-MM-dd").parse("2021-11-19"), new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-22"), "한국직업능력진흥원","02-465-9447","http://www.pqi.or.kr/");
		
		System.out.println("\n▶3) 시험이 무기한 연기되어 결국 취소되었습니다.");
		controller.deleteTest(100);
		System.out.println("<1번 시험 삭제 후 결과>");
		controller.selectAllTest();
		
		System.out.println("\n▶4) 충분한 시험장이 있는지 확인을 해보았습니다.");
		controller.getAllTestLoc();
		
		System.out.println("");
		System.out.println("\n♨시나리오 2. 갑자기 취준생이 된 김학년은 자격증들을 검색중이다.");
		System.out.println("");
		
		System.out.println("\n▶1) 모든 시험을 검색했습니다.");
		controller.selectAllTest();
		

		
		System.out.println("\n▶3) 돈이 없어서 3만원 이하 자격증만 검색했습니다.");
		controller.selectTestWithPrice(30000);
		
		System.out.println("\n▶4) 본인 아이디로 지금까지 접수한 자격증을 확인했습니다.");
		controller.selectOneTestUser("bae99999");
		
		System.out.println("\n▶5) 오늘 날짜 기준으로 응시 가능한 시험들을 전체 검색했습니다.");		
		LocalDate now = LocalDate.now();
		controller.dateChecked(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		
//		System.out.println("\n▶5) 번호가 바뀌어서 전화번호를 수정했습니다.");
//		TestUserDAO.TestUserUpdate(3, "01065498798");
//		
//		System.out.println("\n▶6) 취업에 성공해서 자격증통합관리사이트에서 탈퇴했습니다.");
//		TestUserDAO.TestUserDelete(3);

		System.out.println("");
		System.out.println("\n♨시나리오 3. 관리자 전용 ");
		System.out.println("");
		
		System.out.println("\n▶1) 모든유저검색");
		controller.selectAllTestUser();

		System.out.println("\n▶2) 모든 기관 검색");
		controller.selectAllOrg();
		
		System.out.println("\n▶3) YBM이라는 기관 검색");
		controller.selectOneTestOrg("YBM");
		
		}

}
