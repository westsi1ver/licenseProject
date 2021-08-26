package testLicense.view;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import testLicenseController.TestLicenseController;

public class StartView {

	public static void main(String[] args) throws ParseException, SQLException {

		TestLicenseController controller = TestLicenseController.getInstance();
		
		
		System.out.println("\n♨시나리오 - [코로나 발생으로 인한 변동사항]============================= ");
		System.out.println("");
		

		System.out.println("\n▶1) SQL 응시료가 5만원에서 2만원으로 변경되었습니다.");
		controller.updateFee(8, 20000);

		System.out.println("***수정전***");
		controller.selectAllTest();
		System.out.println("\n▶1) 응시료가 변경되었습니다.");
		controller.updateFee(9, 20000);

		
		System.out.println("\n▶2) 인기있는 타로심리상담사자격증 시험이 1회 추가되었습니다.");
		controller.updateTest("타로심리상담사1급 41회", 85000, new SimpleDateFormat("yyyy-MM-dd").parse("2021-11-19"), new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-22"), "한국직업능력진흥원","02-465-9447","http://www.pqi.or.kr/");
		
		System.out.println("******수정 전******");
		controller.selectAllTest();
		System.out.println("\n▶3) 시험이 무기한 연기되어 결국 취소되었습니다.");
		controller.deleteTest(1);
		controller.selectAllTest();
		
		System.out.println("\n▶4) 충분한 시험장이 있는지 확인을 해보았습니다.");
		controller.getAllTestLoc();
		
		System.out.println("");
		System.out.println("\n♨시나리오 - [응시자 시점]============================= ");
		System.out.println("");
		
		System.out.println("\n▶5) 모든 시험을 검색했습니다.");
		controller.selectAllTest();
		
		System.out.println("\n▶6) 돈이 없어서 3만원 이하 자격증만 검색했습니다.");
		controller.selectTestWithPrice(30000);
		
		System.out.println("\n▶7) 오늘 날짜 기준으로 응시 가능한 시험들을 전체 검색했습니다.");		
		LocalDate now = LocalDate.now();
		controller.dateChecked(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		
		System.out.println("\n▶8) 본인 아이디로 지금까지 접수한 자격증을 확인했습니다.");
		controller.selectOneTestUser("circle00");
		
		
		System.out.println("\n▶9) 번호가 바뀌어서 전화번호를 수정했습니다.");
		controller.updateTestUser(9, "010-5555-5555");
		
		System.out.println("\n▶10) 취업에 성공해서 자격증통합관리사이트에서 탈퇴했습니다.");
		controller.deleteTestUser(5);
		controller.selectAllTestUser();

		System.out.println("");
		System.out.println("\n♨시나리오 - [관리자 시점]============================= ");
		System.out.println("");
		
		System.out.println("\n▶11) 모든 유저검색");
		controller.selectAllTestUser();

		System.out.println("\n▶12) 모든 기관 검색");
		controller.selectAllOrg();

		System.out.println("\n▶13) 특정 기관 검색");
		controller.selectOneTestOrg("YBM");
		controller.selectOneTestOrg("큐넷");
		
	}
}
