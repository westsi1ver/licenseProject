package testLicense.DAO;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import model.entity.TestUser;
import util.PublicCommon;

public class TestUserDAO {

	private static TestUserDAO instance = new TestUserDAO();

	private TestUserDAO() {
	}

	public static TestUserDAO getInstance() {
		return instance;
	}

	public ArrayList<TestUser> testUserAllRead() {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		ArrayList<TestUser> TestUserall = null;

		tx.begin();

		try {
			TestUserall = (ArrayList<TestUser>) em.createQuery("select t from TestUser t", TestUser.class)
					.getResultList();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
		return TestUserall;
	}

	public TestUser testUserOneRead(String userId) {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		TestUser t1 = null;

		tx.begin();

		try {
			t1 = (TestUser) em.createNamedQuery("TestUser.findbyuserId").setParameter("userId", userId)
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

	public boolean testUserUpdate(int user_no, String phoneNum) {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		TestUser testuser = null;
		boolean updateresult = false;

		tx.begin();

		try {
			testuser = em.find(TestUser.class, user_no);
			System.out.println("업데이트 후:");
			System.out.println(testuser);

			testuser = em.find(TestUser.class, user_no);
			System.out.println("업데이트 전:");
			testuser.setUserPhone(phoneNum);
			updateresult = true;
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
//			e.printStackTrace();
		} finally {
			em.close();
		}
		return updateresult;

	}

	public boolean testUserDelete(int userNum) {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		TestUser testuser = null;
		boolean updateresult = false;

		tx.begin();

		try {
			testuser = em.find(TestUser.class, userNum);

			em.remove(em.find(TestUser.class, userNum));
			tx.commit();
			updateresult = true;
		} catch (Exception e) {
			tx.rollback();
//			e.printStackTrace();
		} finally {
			em.close();
		}
		return updateresult;
	}
}
