package testLicense.service;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.entity.TestLoc;
import model.entity.TestOrg;
import model.entity.TestT;
import model.entity.TestUser;
import testLicense.DAO.TestLocDAO;
import testLicense.DAO.TestOrgDAO;
import testLicense.DAO.TestTDAO;
import testLicense.DAO.TestUserDAO;

public class TestService {
	
	
	public static List<TestLoc> testLocSearchAll() {
		return TestLocDAO.TestLocSearchAll();
	}

	public static TestT updateTestFee(int testNum, int fee) {
		return TestTDAO.updateTestFee3(testNum, fee);
	}


	public static TestT updateTest(String testName, int testFee, Date testEndDate, Date testDay, String orgName,
			String orgPhone, String orgUrl) {
		return TestTDAO.updateTest(testName,testFee,testEndDate,testDay, orgName,orgPhone, orgUrl);
	}

	public static TestT testDelete(int testNum) {
		return TestTDAO.testDelete(testNum);
	}
	
	public static List<TestUser> selectAllTestUser(){
		return TestUserDAO.TestUserAllRead();
	}
	
	public static List<TestT> selectAllTest(){
		return TestTDAO.getAllTest();
	}

	public static List<TestOrg> selectAllOrg(){
		return TestOrgDAO.getAllOrg();
	}
	
	public static TestUser selectUserWithId(String userId) {
		return TestUserDAO.TestUserOneRead(userId);
	}
	
	public static TestOrg selectOneOrg(String orgName) {
		return TestOrgDAO.getOneOrg(orgName);
	}
	
	public static List<TestT> selectTestWithPrice(int price) {
		return TestTDAO.getTestWithPrice(price);
	}
}
