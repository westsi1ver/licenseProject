package testLicense.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import model.entity.TestT;
import util.PublicCommon;

public class TestTDAO {

//	public static TestT updateTestFee(String testName, int i) {
//		EntityManager em = PublicCommon.getEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		TestT tt = null;
//		tx.begin();
//		
//		try {
//			tt = em.find(TestT.class, testName);
//			
//		}
		
		
//		return null;
//	}
//	
	
	
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
