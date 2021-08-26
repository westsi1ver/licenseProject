package testLicenseController;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import model.entity.TestLoc;
import model.entity.TestOrg;
import model.entity.TestT;
import model.entity.TestUser;
import testLicense.service.TestService;
import testLicense.view.EndView;
import testServiceException.NotExistException;
import util.PublicCommon;

public class TestLicenseController {

	private TestService service = TestService.getInstance();

	private static TestLicenseController instance = new TestLicenseController();

	private TestLicenseController() {
	}

	public static TestLicenseController getInstance() {
		return instance;
	}

	public void getAllTestLoc() {
		List<TestLoc> all = null;

		try {
			all = service.testLocSearchAll();
			if (all.size() != 0) {
				EndView.listView(service.testLocSearchAll());
			} else {
				System.out.println("정보가 더 이상 존재하지 않습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			EndView.showError("죄송해요. 존재하는 시험장이 없습니다.");
		}

	}

	public void selectAllTestUser() {
		List<TestUser> all = null;

		try {
			all = service.selectAllTestUser();

			if (all.size() != 0) {
				EndView.listView(service.TestUserAllRead());
			} else {
				System.out.println("존재하는 수험자 존재하지 않습니다.");
			}
		} catch (Exception e) {
//			e.printStackTrace();
			EndView.showError("해당 정보가 없습니다.");
		}
	}

	public void selectAllOrg() {
//		ArrayList<TestOrg> all = null;
		List<TestOrg> all = null;
		try {
			all = service.selectAllOrg();
			if (all.size() != 0) {
				EndView.listView(service.selectAllOrg());
			} else {
				System.out.println("더 이상 기관이 존재하지 않습니다.");
			}
		} catch (Exception e) {
//			e.printStackTrace();

			EndView.showError("해당정보가 없습니다");

		}
	}

	public void selectOneTestUser(String userId) throws NoResultException, SQLException {

		TestUser testuser = null;

		try {
			testuser = service.selectUserWithId(userId);
			if (testuser != null) {
				EndView.printOne(service.selectUserWithId(userId));
			} else {
				System.out.println("해당ID가 존재하지 않습니다.");
			}
		} catch (Exception e) {
//			e.printStackTrace();
			EndView.showError("해당정보가 없습니다.");
		}
	}

	public void selectOneTestOrg(String orgName) {

		TestOrg org = null;

		try {
			org = service.selectOneOrg(orgName);
			if (org != null) {
				EndView.printOne(service.selectOneOrg(orgName));
			} else {
				System.out.println("해당기관이 존재하지 않습니다.");
			}
		} catch (Exception e) {
//			e.printStackTrace();
			EndView.showError("해당 정보가 없습니다.");
		}
	}

	public void selectTestWithPrice(int price) {

		try {
			EndView.listView(service.selectTestWithPrice(price));
		} catch (Exception e) {
//			e.printStackTrace();
			EndView.showError("해당 정보가 없습니다");
		}

	}

	public void selectAllTest() {

		try {
			EndView.listView(service.selectAllTest());
		} catch (Exception e) {
//			e.printStackTrace();
			EndView.showError("해당정보가 없습니다");
		}
	}

	public boolean updateTest(String testName, int testFee, Date testEndDate, Date testDay, String orgName,
			String orgPhone, String orgUrl) throws ArrayIndexOutOfBoundsException {

		if (service.updateTest(testName, testFee, testEndDate, testDay, orgName, orgPhone, orgUrl)) {
			EndView.printOne(service.updateTest(testName, testFee, testEndDate, testDay, orgName, orgPhone, orgUrl));
			EndView.showError("업데이트 성공!");
		} else {
			System.out.println("정보를 다시 확인해 주세요");
		}
		return false;
	}

	public boolean updateTestUser(int user_no, String phoneNum) {

		if (service.updateTestUser(user_no, phoneNum)) {
			EndView.printOne(service.updateTestUser(user_no, phoneNum));
		} else {
			System.out.println("존재하지 않는 번호입니다. 번호를 다시 확인해주세요.");
		}
		return false;
	}

	public boolean updateFee(int testNum, int fee) {

		try {
			if (service.updateTestFee(testNum, fee)) {
				EndView.printOne(service.updateTestFee(testNum, fee));
				;
			} else {
				System.out.println("아 잠시만요! 번호를 다시 확인해주세요.");
			}
		} catch (NotExistException e) {
//			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteTest(int testNum) {

		if (service.testDelete(testNum)) {
			EndView.showmessage("삭제 성공");
		} else {
			EndView.showError("삭제 실패");
		}
		return false;
	}

	public boolean deleteTestUser(int userNum) {

		if (service.testUserDelete(userNum)) {
			EndView.showmessage("삭제 성공");
		} else {
			EndView.showError("삭제 실패");
		}
		return false;
	}

	public void dateChecked(String mydate) {
		try {
			EndView.listView(service.dateCheck(mydate));
		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("해당하는 범위에 속하는 시험이 존재하지 않습니다.");
		}
	}

}
