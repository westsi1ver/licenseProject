package testLicenseController;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.entity.TestOrg;
import model.entity.TestT;
import model.entity.TestUser;
import testLicense.DAO.TestOrgDAO;
import testLicense.DAO.TestTDAO;
import testLicense.DAO.TestUserDAO;
import testLicense.service.TestService;
import testLicense.view.EndView;
import util.PublicCommon;

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
			EndView.printOne(TestService.updateTestFee(testNum, fee));
			
		}catch(Exception s){
			s.printStackTrace();
			EndView.showError("존재하는 시험으로 응시료를 변경하세요오오오");
		}
	}

	public static void updateLoc(String string, String testFee) {
		// TODO Auto-generated method stub
		
	}
	
	public static void selectAllTestUser() {
		ArrayList<TestUser> all = null;
		
		try {
		EndView.listView(TestService.selectAllTestUser());
		}catch(Exception e) {
//			e.printStackTrace();
			EndView.showError("해당 정보가 없습니다.");
		}
	}
	 
	public static void selectOneTestUser(String userId) {
		try {
			EndView.printOne(TestService.selectUserWithId(userId));
		}catch(Exception e) {
//			e.printStackTrace();
			EndView.showError("해당정보가 없습니다.");
		}
	}
	
	public static void selectAllOrg() {
		ArrayList<TestOrg> all = null;
		
		try {
			EndView.listView(TestService.selectAllOrg());
		}catch(Exception e) {
			EndView.showError("해당정보가 없습니다");
		}
	}
	
	public static void selectOneTestOrg(String orgName) {
		try {
			EndView.printOne(TestService.selectOneOrg(orgName));
		}catch(Exception e) {
			e.printStackTrace();
			EndView.showError("해당 정보가 없습니다.");
		}
	}
	
	public static void selectTestWithPrice(int price) {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			EndView.listView(TestService.selectTestWithPrice(price));
		}catch(Exception e) {
			e.printStackTrace();
			EndView.showError("해당 정보가 없습니다");
		}
		
	}
	
	
	public static void selectAllTest() {
		ArrayList<TestT> all = null;
		
		try {
			EndView.listView(TestService.selectAllTest());
		}catch(Exception e) {
			e.printStackTrace();
			EndView.showError("해당정보가 없습니다");
		}
	}

	public static void updateTest(String testName,int testFee,Date testEndDate,Date testDay, String orgName, String orgPhone, String orgUrl) {
		try{
			EndView.printOne(TestService.updateTest(testName,testFee,testEndDate,testDay, orgName,orgPhone, orgUrl));
			
		}catch(Exception s){
			s.printStackTrace();
			EndView.showError("제대로 된 입력값을 입력바랍니다.");
		}
	}

	public static void deleteTest(int testNum) {
		try {
			EndView.printOne(TestService.testDelete(testNum));
		}catch(Exception s) {
			s.printStackTrace();
			EndView.showError("해당하는 시험 고유번호가 없습니다");
		}
	}
	

}
