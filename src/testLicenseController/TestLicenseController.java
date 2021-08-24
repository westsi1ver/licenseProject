package testLicenseController;

import java.sql.SQLException;

import testLicense.DAO.TestLocDAO;
import testLicense.DAO.TestTDAO;
import testLicense.view.EndView;

public class TestLicenseController {

	public static void getAllTestLoc() {
		try {
			EndView.listView(TestLocDAO.TestLocSearchAll());
		}catch(Exception e) {
			e.printStackTrace();
			EndView.showError("죄송해요. 존재하는 시험장이 없습니다.");
		}
		
	}
//
//	public static void updateFee(String testName, int i) {
//		try{
//			EndView.OneView(TestTDAO.updateTestFee(testName, i));
//			
//		}catch(SQLException s){
//			s.printStackTrace();
//			EndView.showError("존재하는 시험으로 응시료를 변경하세요");
//		}catch(Exception s){
//			s.printStackTrace();
//			EndView.showError("존재하는 시험으로 응시료를 변경하세요오오오");
//		}
//	}
//
	public static void updateLoc(String string, String testFee) {
		// TODO Auto-generated method stub
		
	}

}
