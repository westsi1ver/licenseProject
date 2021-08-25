package testLicense.DAO;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.entity.TestOrg;
import util.PublicCommon;

public class TestOrgDAO {
//	@Test
	public static ArrayList<TestOrg> getAllOrg() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		ArrayList<TestOrg> testorg = null;
		tx.begin();

		try {
			System.out.println("모든기관 정보조회");
			testorg = (ArrayList<TestOrg>) em.createQuery("select t from TestOrg t", TestOrg.class).getResultList();
			return testorg;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
			em = null;
		}
		return testorg;
	}

	public static TestOrg getOneOrg(String orgName) {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		TestOrg t1 = null;

		tx.begin();
		try {
			System.out.println("원하는 기관 정보조회");
			t1 = (TestOrg) em.createNamedQuery("TestOrg.findbyOrgName").setParameter("orgName", orgName)
					.getSingleResult();
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
