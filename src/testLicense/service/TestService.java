package testLicense.service;

import java.util.Date;
import java.util.List;

import model.entity.TestLoc;
import model.entity.TestOrg;
import model.entity.TestT;
import model.entity.TestUser;
import testLicense.DAO.TestLocDAO;
import testLicense.DAO.TestOrgDAO;
import testLicense.DAO.TestTDAO;
import testLicense.DAO.TestUserDAO;
import testServiceException.NotExistException;

public class TestService {

	private TestTDAO test = TestTDAO.getInstance();
	private TestLocDAO loc = TestLocDAO.getInstance();
	private TestOrgDAO org = TestOrgDAO.getInstance();
	private TestUserDAO user = TestUserDAO.getInstance();

	private static TestService instance = new TestService();

	private TestService() {
	}

	public static TestService getInstance() {
		return instance;
	}

	public List<TestLoc> testLocSearchAll() {
		return loc.testLocSearchAll();
	}

	public TestT updateTestFee(int testNum, int fee) {
		return test.updateTestFees(testNum, fee);
	}
	
	public TestUser updateTestUser(int user_no, String phoneNum) {
		return user.testUserUpdate(user_no, phoneNum);
	}
	
	public TestT updateTest(String testName, int testFee, Date testEndDate, Date testDay, String orgName,
							String orgPhone, String orgUrl) {
		return test.updateTest(testName, testFee, testEndDate, testDay, orgName, orgPhone, orgUrl);
	}

	public TestT testDelete(int testNum) throws NotExistException {
		notExistTest(testNum);
		return test.testDelete(testNum);
	}

	public TestUser testUserDelete(int userNum) {
		return user.testUserDelete(userNum);
	}
	
	public List<TestT> selectAllTest() {
		return test.getAllTest();
	}

	public List<TestT> selectTestWithPrice(int price) {
		return test.getTestWithPrice(price);
	}

	public List<TestT> dateCheck(String mydate) {
		return test.dateCheck(mydate);
	}

	public List<TestOrg> selectAllOrg() {
		return org.getAllOrg();
	}

	public TestOrg selectOneOrg(String orgName) {
		return org.getOneOrg(orgName);
	}

	public List<TestUser> TestUserAllRead() {
		return user.testUserAllRead();
	}

	public TestUser selectUserWithId(String userId) {
		return user.testUserOneRead(userId);
	}

	public List<TestUser> selectAllTestUser() {
		return user.testUserAllRead();
	}
	
	public TestT selectTWithNum(int testNum) {
		return test.getOneTestWithNum(testNum);
	}


	
	public void notExistTest(int testNum) throws NotExistException {
		TestT noTest = test.testDelete(testNum);
		if (noTest == null) {
			throw new NotExistException("검색하는 시험번호가 없네요.");
		}
	}
	
	

}
