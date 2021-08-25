package testLicense.view;

import testLicense.DAO.TestTDAO;
import testLicense.DAO.TestUserDAO;
import testLicenseController.TestLicenseController;

public class StartView {

	public static void main(String[] args) {

		System.out.println("=========모든 시험장 검색!=========");
		TestLicenseController.getAllTestLoc();
		
		
//		System.out.println("\n========= 시험의 응시료가 변경되었습니다. =========");
//		TestLicenseController.updateLoc(, );
//		TestLicenseController.getAllTest();
//		
//		System.out.println("\n========= 시험의 응시료가 변경되었습니다. =========");
//		TestLicenseController.updateFee("sqld 40회차", 25000);
//		TestLicenseController.getAllTest();
		
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
