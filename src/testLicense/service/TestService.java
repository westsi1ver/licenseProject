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

	public TestT updateTest(String testName, int testFee, Date testEndDate, Date testDay, String orgName,
							String orgPhone, String orgUrl) {
		return test.updateTest(testName, testFee, testEndDate, testDay, orgName, orgPhone, orgUrl);
	}

	public TestT testDelete(int testNum) {
		return test.testDelete(testNum);
	}

	public List<TestT> selectAllTest() {
		return test.getAllTest();
	}

	public List<TestT> selectTestWithPrice(int price) {
		return test.getTestWithPrice(price);
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

}
