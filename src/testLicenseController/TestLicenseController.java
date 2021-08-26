package testLicenseController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

import model.entity.TestLoc;
import model.entity.TestOrg;
import model.entity.TestT;
import model.entity.TestUser;
import testLicense.DAO.TestLocDAO;
import testLicense.service.TestService;
import testLicense.view.EndView;
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

//	public static void getSpecialTestLoc() {
//		try {
//			EndView.listView(service.testLocSpecialSearch());
//		}catch(Exception e) {
//			e.printStackTrace();
//			EndView.showError("죄송해요. 존재하는 시험장이 없습니다.");
//		}
//	}

	public void updateFee(int testNum, int fee) {
		TestT test = null;
		try {
			test = service.selectTWithNum(testNum);

			if (test != null) {
				EndView.oneView(service.updateTestFee(testNum, fee));
			} else {
				System.out.println("해당번호가 없습니다 확인해주세요.");
			}
		} catch (Exception s) {
			s.printStackTrace();
			EndView.showError("존재하는 시험으로 응시료를 변경하세요오오오");
		}
	}

	public void updateLoc(String string, String testFee) {
	}

	public void selectAllTestUser() {
		List<TestUser> all = null;

		try {
			all = service.selectAllTestUser();
			
			if(all.size() != 0) {
			EndView.listView(service.TestUserAllRead());
			}else {
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
			if(all.size() != 0) {
			EndView.listView(service.selectAllOrg());
			}else {
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
			if(testuser != null) {
			EndView.printOne(service.selectUserWithId(userId));
			}else {
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
			if(org != null) {
			EndView.printOne(service.selectOneOrg(orgName));
			}else {
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
//		ArrayList<TestT> all = null;

		try {
			EndView.listView(service.selectAllTest());
		} catch (Exception e) {
//			e.printStackTrace();
			EndView.showError("해당정보가 없습니다");
		}
	}

	public void updateTest(String testName, int testFee, Date testEndDate, Date testDay, String orgName,
			String orgPhone, String orgUrl) throws ArrayIndexOutOfBoundsException {
		try {
//			EntityManager em = PublicCommon.getEntityManager();
//			em.
			EndView.oneView(service.updateTest(testName, testFee, testEndDate, testDay, orgName, orgPhone, orgUrl));
		} catch (Exception s) {
//			s.printStackTrace();
			EndView.showError("제대로 된 입력값을 입력바랍니다.");
		}
	}

	public void updateTestUser(int user_no, String phoneNum) {
		TestUser testuser = null;
		try {
			EntityManager em = PublicCommon.getEntityManager();
			testuser = em.find(TestUser.class, user_no);
			
			if(testuser != null) {
			EndView.printOne(service.updateTestUser(user_no, phoneNum));
			}else {
				System.out.println("존재하지 않는 번호입니다. 번호를 다시 확인해주세요.");
			}
		} catch (NullPointerException s) {
//			s.printStackTrace();
			EndView.showError("사용자번호를 확인해주세요");
		}
	}

	public void deleteTest(int testNum) {
		TestT test = null;
		try {
			EntityManager em = PublicCommon.getEntityManager();

			test = em.find(TestT.class, testNum);
			if (test != null) {
				EndView.oneView(service.testDelete(testNum));
			} else {
				System.out.println("번호가 이미 삭제되었습니다.");
			}
		} catch (Exception s) {
//			s.printStackTrace();
			EndView.showError("해당하는 시험 고유번호가 없습니다");
		}
	}

	public void deleteTestUser(int userNum) {
		
		TestUser testuser = null;
		try {
			EntityManager em= PublicCommon.getEntityManager();
			testuser = em.find(TestUser.class, userNum);
			
			if(testuser != null) {
			EndView.printOne(service.testUserDelete(userNum));
			}else {
				System.out.println("이미 삭제된 번호입니다. 확인해주세요");
			}
		} catch (IllegalArgumentException i) {
			i.printStackTrace();
			EndView.showError("요청하신 정보가 없습니다.");
		}
	}

}
