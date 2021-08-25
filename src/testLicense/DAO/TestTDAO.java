package testLicense.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

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
			testF.getOrgNumber().getOrgName();
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

	public TestT updateTest(String testName, int testFee, Date testEndDate, Date testDay, String orgName,String orgPhone, String orgUrl) {
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

	public TestT testDelete(int testNum) {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		TestT testD = null;

		tx.begin();

		try {

			em.remove(em.find(TestT.class, testNum));
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		return testD;
	}

//	@Test
	public ArrayList<TestT> getAllTest() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		ArrayList<TestT> allTest = null;
		
		tx.begin();
		
		try {
			System.out.println("[모든시험정보조회]");
			allTest = (ArrayList<TestT>) em.createQuery("select t from TestT t", TestT.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
			em = null;
		}
		return allTest;

	}

//	@Test
	public void getOneTest() {
		EntityManager em = PublicCommon.getEntityManager();

		System.out.println("[원하는 시험조회]");
		List<TestT> test = em.createQuery("select t from TestT t where t.testName like '%정보%' ", TestT.class).getResultList();
		
		for (TestT oneTest : test) {
			System.out.println(oneTest);
		}
	}

	@Test
	public ArrayList<TestT> getTestWithPrice(int price) {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		ArrayList<TestT> t1 = null;

		tx.begin();
		
		try {
			t1 = (ArrayList<TestT>) em.createNamedQuery("TestT.findbyTestFee").setParameter("testFee", price).getResultList();
		} catch (Exception e) {
//			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
			em = null;
		}
		return t1;
	}
}
