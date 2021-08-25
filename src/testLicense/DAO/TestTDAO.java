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


	public static TestT updateTestFee3(int testNum, int fee) {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		TestT tt = null;
		tx.begin();
		
		try {
			tt = em.find(TestT.class, testNum);
			tt.setTestFee(fee);
			tt.getOrgNumber().getOrgName();
			em.persist(tt);
			
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally{
			em.close();
		}
			
		return tt;
	}

	public static TestT updateTest(String testName,int testFee,Date testEndDate,Date testDay, String orgName, String orgPhone, String orgUrl) {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		TestOrg newOrg = new TestOrg();
		TestT newTest = new TestT();
		tx.begin();
		
		try {
		
			newOrg.setOrgName(orgName);
			newOrg.setOrgPhone(orgPhone);
			newOrg.setOrgUrl(orgUrl);

			newTest.setTestDay(testDay);
			newTest.setTestEndDate(testEndDate);
			newTest.setTestFee(testFee);
			newTest.setTestName(testName);
			newTest.setOrgNumber(newOrg);
			
			newOrg.getTestList().add(newTest);
			
			em.persist(newOrg);
			em.persist(newTest);
			
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally{
			em.close();
		}
			
		return newTest;
	}
	
	
	public static TestT testDelete(int testNum) {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		TestT tt = null;

		tx.begin();
		
		try {
			
			em.remove( em.find(TestT.class, testNum));
			
			tx.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally {
			em.close();
		}
		return tt;
	}
	
//	@Test
	public static ArrayList<TestT> getAllTest() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		ArrayList<TestT> t1 = null;
		tx.begin();
		try {
			System.out.println("[모든시험정보조회]");
			t1 = (ArrayList<TestT>) em.createQuery("select t from TestT t", TestT.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
			em = null;
		}
		return t1;

	}

//	@Test
	public void getOneTest() {
		EntityManager em = PublicCommon.getEntityManager();

		System.out.println("[원하는 시험조회]");
		List<TestT> t = em.createQuery("select t from TestT t where t.testName like '%정보%' ", TestT.class)
				.getResultList();
		for (TestT a : t) {
			System.out.println(a);
		}
	}

	@Test
	public static ArrayList<TestT> getTestWithPrice(int price) {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		ArrayList<TestT> t1 = null;

		tx.begin();
		try {
			t1 = (ArrayList<TestT>) em.createNamedQuery("TestT.findbyTestFee").setParameter("testFee", price)
					.getResultList();
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
