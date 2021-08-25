package testLicense.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import testLicenseController.TestLicenseController;

public class StartView {

	public static void main(String[] args) throws ParseException {

		System.out.println("=========모든 시험장 검색=========");
//		TestLicenseController.getAllTestLoc();
		
		System.out.println("\n========= 시험의 응시료가 변경되었습니다. =========");
//		TestLicenseController.updateFee(4, 70000);
//		TestLicenseController.getAllTest();
		
		System.out.println("\n========특별 시험이 추가되었습니다==========");
		TestLicenseController.updateTest("타로심리상담사1급 4회", 85000, new SimpleDateFormat("yyyy-MM-dd",Locale.KOREA).parse("2021-11-19"), new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-22"), "한국직업능력진흥원","02-465-9447","http://www.pqi.or.kr/");
//
//		
//		System.out.println("\n========시험이 무기한 연기되어 취소되었습니다======");
////		TestLicenseController.deleteTest(4);
	}

}
