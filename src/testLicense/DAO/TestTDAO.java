package testLicense.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.entity.TestOrg;
import model.entity.TestT;
import util.PublicCommon;

public class TestTDAO {

	private static TestTDAO instance = new TestTDAO();

	private TestTDAO() {
	}

	public static TestTDAO getInstance() {
		return instance;
	}

	public TestT updateTestFees(int testNum, int fee) {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		TestT testF = null;

		tx.begin();

		try {
			
			testF = em.find(TestT.class, testNum);
			testF.setTestFee(fee);
			em.persist(testF);
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}

		return testF;
	}

	public TestT updateTest(String testName, int testFee, Date testEndDate, Date testDay, String orgName, String orgPhone, String orgUrl) {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		TestOrg newOrg = new TestOrg();
		TestT newTest = new TestT();

		tx.begin();

		try {

			newOrg.setOrgName(orgName);
			newOrg.setOrgPhone(orgPhone);
			newOrg.setOrgUrl(orgUrl);
			em.persist(newOrg);

			newTest.setTestDay(testDay);
			newTest.setTestEndDate(testEndDate);
			newTest.setTestFee(testFee);
			newTest.setTestName(testName);
			newTest.setOrgNumber(newOrg);
			em.persist(newTest);

			newOrg.getTestList().add(newTest);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}

		return newTest;
	}

	public boolean testDelete(int testNum) {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		TestT testD = null;
		boolean delresult = false;

		tx.begin();

		try {
			testD = em.find(TestT.class, testNum);
			em.remove(em.find(TestT.class, testNum));
			tx.commit();
			delresult = true;

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		return delresult;
	}


	public ArrayList<TestT> getAllTest() {
		EntityManager em = PublicCommon.getEntityManager();
		ArrayList<TestT> allTest = null;


		try {
			System.out.println("[모든시험정보조회]");
			allTest = (ArrayList<TestT>) em.createQuery("select t from TestT t", TestT.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
		return allTest;

	}

	public static TestT getOneTestWithNum(int testNum) {
		TestT test = null;

		try {
			EntityManager em = PublicCommon.getEntityManager();
			test = em.find(TestT.class, testNum);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return test;
	}


	public static void getOneTest(String testName) {
		EntityManager em = PublicCommon.getEntityManager();

		System.out.println("[원하는 시험조회]");
		List<TestT> test = em.createNamedQuery("TestT.findbyTestName").setParameter("testName", testName).getResultList();

		for (TestT oneTest : test) {
			System.out.println(oneTest);
		}
	}


	public ArrayList<TestT> getTestWithPrice(int price) {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		ArrayList<TestT> test = null;

		tx.begin();

		try {
			test = (ArrayList<TestT>) em.createNamedQuery("TestT.findbyTestFee").setParameter("testFee", price).getResultList();

		} catch (Exception e) {
//			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
			em = null;
		}
		return test;
	}

	public List<TestT> dateCheck(String mydate) {
		EntityManager em = PublicCommon.getEntityManager();
		List<TestT> testday = null;

		try {
			String datecheck = "SELECT m FROM TestT m WHERE m.testDay > TO_DATE(?1,'yyyy-MM-dd')";
			testday = em.createQuery(datecheck, TestT.class).setParameter(1, mydate).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
		return testday;
	}

}
