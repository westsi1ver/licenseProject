package testLicenseController;

import java.util.Date;

import testLicense.service.TestService;
import testLicense.view.EndView;

public class TestLicenseController {
	
	private TestService service = TestService.getInstance();
	
	private static TestLicenseController instance = new TestLicenseController();
	
	private TestLicenseController() {}
	
	public static TestLicenseController getInstance() {
		return instance;
	}

	public void getAllTestLoc() {
		try {
			EndView.listView(service.testLocSearchAll());
		}catch(Exception e) {
			e.printStackTrace();
			EndView.showError("죄송해요. 존재하는 시험장이 없습니다.");
		}
		
	}
	
//	public static void getSpecialTestLoc() {
//		try {
//			EndView.listView(service.testLocSpecialSearch());
//		}catch(Exception e) {
//			e.printStackTrace();
//			EndView.showError("죄송해요. 존재하는 시험장이 없습니다.");
//		}
//	}
	

	public void updateFee(int testNum, int fee){
		try {
			EndView.oneView(service.updateTestFee(testNum, fee));
		}catch(Exception s){
			s.printStackTrace();
			EndView.showError("존재하는 시험으로 응시료를 변경하세요오오오");
		}
	}

	public void updateLoc(String string, String testFee) {		
	}
	
	public void selectAllTestUser() {
		
		try {
		EndView.listView(service.TestUserAllRead());
		}catch(Exception e) {
//			e.printStackTrace();
			EndView.showError("해당 정보가 없습니다.");
		}
	}
	 
	public void selectOneTestUser(String userId) {
		try {
			EndView.printOne(service.selectUserWithId(userId));
		}catch(Exception e) {
//			e.printStackTrace();
			EndView.showError("잘못 입력하신 것 같아요.");
		}
	}
	
	public void selectAllOrg() {
//		ArrayList<TestOrg> all = null;
		
		try {
			EndView.listView(service.selectAllOrg());
		}catch(Exception e) {
			EndView.showError("해당정보가 없습니다");
		}
	}
	
	public void selectOneTestOrg(String orgName) {
		try {
			EndView.printOne(service.selectOneOrg(orgName));
		}catch(Exception e) {
			e.printStackTrace();
			EndView.showError("해당 정보가 없습니다.");
		}
	}
	
	public void selectTestWithPrice(int price) {

		try {
			EndView.listView(service.selectTestWithPrice(price));
		}catch(Exception e) {
			e.printStackTrace();
			EndView.showError("해당 정보가 없습니다");
		}
		
	}
	
	public void selectAllTest() {
//		ArrayList<TestT> all = null;
		
		try {
			EndView.listView(service.selectAllTest());
		}catch(Exception e) {
			e.printStackTrace();
			EndView.showError("해당정보가 없습니다");
		}
	}

	public void updateTest(String testName,int testFee,Date testEndDate,Date testDay, String orgName, String orgPhone, String orgUrl) {
//	public void updateTest(String testName, int testFee, String testEndDate, String testDay, String orgName, String orgPhone, String orgUrl) {
		try {
			EndView.oneView(service.updateTest(testName,testFee,testEndDate,testDay, orgName,orgPhone, orgUrl));
		}catch(Exception s){
			s.printStackTrace();
			EndView.showError("제대로 된 입력값을 입력바랍니다.");
		}
	}

	public void deleteTest(int testNum) {
			
			if(service.testDelete(testNum)) {
				EndView.showError("삭제 성공");	
			}else {
				EndView.showError("삭제 실패");
			}
//			EndView.oneView(service.testDelete(testNum));
//	(Exception s) {
//			s.printStackTrace();
//			EndView.showError("해당하는 시험 고유번호가 없습니다");
//		}
	}
	
	public void dateChecked(String mydate) {
		try{
			EndView.listView(service.dateCheck(mydate));
		}catch(Exception s) {
			s.printStackTrace();
			EndView.showError("해당하는 범위에 속하는 시험이 존재하지 않습니다.");
		}
	}



}
