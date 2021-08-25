package testLicense.service;

import java.util.Date;
import java.util.List;

import model.entity.TestLoc;
import model.entity.TestT;
import testLicense.DAO.TestLocDAO;
import testLicense.DAO.TestTDAO;

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

}
