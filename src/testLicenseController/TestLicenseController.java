package testLicenseController;

import java.util.Date;

import testLicense.service.TestService;
import testLicense.view.EndView;

public class TestLicenseController {

	public static void getAllTestLoc() {
		try {
			EndView.listView(TestService.testLocSearchAll());
		}catch(Exception e) {
			e.printStackTrace();
			EndView.showError("죄송해요. 존재하는 시험장이 없습니다.");
		}
		
	}

	public static void updateFee(int testNum, int fee){
		try{
			EndView.oneView(TestService.updateTestFee(testNum, fee));
			
		}catch(Exception s){
			s.printStackTrace();
			EndView.showError("존재하는 시험으로 응시료를 변경하세요오오오");
		}
	}

	public static void updateLoc(String string, String testFee) {
		// TODO Auto-generated method stub
		
	}

	public static void updateTest(String testName,int testFee,Date testEndDate,Date testDay, String orgName, String orgPhone, String orgUrl) {
		try{
			EndView.oneView(TestService.updateTest(testName,testFee,testEndDate,testDay, orgName,orgPhone, orgUrl));
			
		}catch(Exception s){
			s.printStackTrace();
			EndView.showError("제대로 된 입력값을 입력바랍니다.");
		}
	}

	public static void deleteTest(int testNum) {
		try {
			EndView.oneView(TestService.testDelete(testNum));
		}catch(Exception s) {
			s.printStackTrace();
			EndView.showError("해당하는 시험 고유번호가 없습니다");
		}
	}
	

}
