package testLicense.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import testLicense.DAO.TestTDAO;
import testLicense.DAO.TestUserDAO;
import testLicenseController.TestLicenseController;

public class StartView {

	public static void main(String[] args) throws ParseException {


		System.out.println("=========모든 시험장 검색!=========");
		TestLicenseController.getAllTestLoc();
		
		
		System.out.println("\n========= 시험의 응시료가 변경되었습니다. =========");
//		TestLicenseController.updateFee(4, 70000);
//		TestLicenseController.getAllTest();
		
		System.out.println("\n========특별 시험이 추가되었습니다==========");
		TestLicenseController.updateTest("타로심리상담사1급 4회", 85000, new SimpleDateFormat("yyyy-MM-dd",Locale.KOREA).parse("2021-11-19"), new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-22"), "한국직업능력진흥원","02-465-9447","http://www.pqi.or.kr/");
//
//		
//		System.out.println("\n========시험이 무기한 연기되어 취소되었습니다======");
////		TestLicenseController.deleteTest(4);

//		System.out.println("모든유저검색");
//		TestLicenseController.selectAllTestUser();

//		System.out.println("***모든시험 검색***");
//		TestLicenseController.selectAllTest();
//		
//
//		System.out.println("****모든 기관 검색*****");
//		TestLicenseController.selectAllOrg();
//
//		System.out.println("아이디로 검색");
//		TestLicenseController.selectOneTestUser("kimkimkim");
		
//
//		System.out.println("*****기관이름으로 검색*******");
//		TestLicenseController.selectOneTestOrg("YBM");
//
		System.out.println("***가격으로 검색***");
		TestLicenseController.selectTestWithPrice(30000);
//
//		System.out.println("전화번호 수정");
//		TestUserDAO.TestUserUpdate(3, "01065498798");
//
//		System.out.println("유저 삭제");
//		TestUserDAO.TestUserDelete(3);
//		
//		TestTDAO.getTestWithPrice(20000);

		
		}

}
