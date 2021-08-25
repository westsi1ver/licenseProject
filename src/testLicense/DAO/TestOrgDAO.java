package testLicense.DAO;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.entity.TestOrg;
import util.PublicCommon;

public class TestOrgDAO {

	private static TestOrgDAO instance = new TestOrgDAO();

	private TestOrgDAO() {
	}

	public static TestOrgDAO getInstance() {
		return instance;
	}

//	@Test
	public ArrayList<TestOrg> getAllOrg() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		ArrayList<TestOrg> testOrg = null;
		
		tx.begin();

		try {
			System.out.println("모든기관 정보조회");
			testOrg = (ArrayList<TestOrg>) em.createQuery("select t from TestOrg t", TestOrg.class).getResultList();
			return testOrg;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
			em = null;
		}
		return testOrg;
	}

	public TestOrg getOneOrg(String orgName) {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		TestOrg org = null;

		tx.begin();
		
		try {
			System.out.println("원하는 기관 정보조회");
			org = (TestOrg) em.createNamedQuery("TestOrg.findbyOrgName").setParameter("orgName", orgName).getSingleResult();
		} catch (Exception e) {
//			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
			em = null;
		}
		return org;
	}
}
