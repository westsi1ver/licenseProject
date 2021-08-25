package testLicenseController;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.entity.TestOrg;
import model.entity.TestT;
import model.entity.TestUser;
import testLicense.DAO.TestLocDAO;
import testLicense.DAO.TestOrgDAO;
import testLicense.DAO.TestTDAO;
import testLicense.DAO.TestUserDAO;
import testLicense.view.EndView;
import util.PublicCommon;

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
	
	public static void selectAllTestUser() {
		ArrayList<TestUser> all = null;
		
		try {
			all = TestUserDAO.TestUserAllRead();
		EndView.printAll(all);
		}catch(Exception e) {
//			e.printStackTrace();
			EndView.showError("해당 정보가 없습니다.");
		}
	}
	 
	public static void selectOneTestUser(String userId) {
		try {
			EndView.printOne(TestUserDAO.TestUserOneRead(userId));
		}catch(Exception e) {
//			e.printStackTrace();
			EndView.showError("해당정보가 없습니다.");
		}
	}
	
	public static void selectAllOrg() {
		ArrayList<TestOrg> all = null;
		
		try {
			EndView.printAll(TestOrgDAO.getAllOrg());
		}catch(Exception e) {
			EndView.showError("해당정보가 없습니다");
		}
	}
	
	public static void selectOneTestOrg(String orgName) {
		try {
			EndView.printOne(TestOrgDAO.getOneOrg(orgName));
		}catch(Exception e) {
			e.printStackTrace();
			EndView.showError("해당 정보가 없습니다.");
		}
	}
	
	public static void selectTestWithPrice(int price) {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			EndView.printAll(TestTDAO.getTestWithPrice(price));
		}catch(Exception e) {
			e.printStackTrace();
			EndView.showError("해당 정보가 없습니다");
		}
		
	}
	
	public static void selectAllTest() {
		ArrayList<TestT> all = null;
		
		try {
			EndView.printAll(TestTDAO.getAllTest());
		}catch(Exception e) {
			e.printStackTrace();
			EndView.showError("해당정보가 없습니다");
		}
	}

}
