package testLicense.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.entity.TestUser;
import util.PublicCommon;

public class TestUserDAO {

	private static TestUserDAO instance = new TestUserDAO();

	private TestUserDAO() {
	}

	public static TestUserDAO getInstance() {
		return instance;
	}

//	public ArrayList<TestUser> testUserAllRead() {
//		EntityManager em = PublicCommon.getEntityManager();
//		
//		List<TestUser> TestUserall = null;
//		
		
	public ArrayList<TestUser> testUserAllRead() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		ArrayList<TestUser> TestUserall = null;
		tx.begin();
		
		try {
			TestUserall = (ArrayList<TestUser>) em.createQuery("select t from TestUser t", TestUser.class).getResultList();

			} catch (Exception e) {
			e.printStackTrace();
			} finally {
			em.close();
			em = null;
			}
			return TestUserall;
	}

//	@Test

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

//	@Test
	public TestUser testUserUpdate(int user_no, String phoneNum) {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		TestUser testuser = null;

		tx.begin();

		try {

			testuser = em.find(TestUser.class, user_no);
			System.out.println("업데이트 전:");
			System.out.println(testuser);

			testuser = em.find(TestUser.class, user_no);
			testuser.setUserPhone(phoneNum);
			System.out.println("업데이트 후:");

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return testuser;

	}

//	@Test
	public TestUser testUserDelete(int userNum) {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		TestUser testuser = null;

		tx.begin();

		try {

//			System.out.println("[ 삭제 전 검색 ]");
//			TestUser user = em.find(TestUser.class, userNum);
//			System.out.println(user);
//
//			em.remove(user);
//
//			System.out.println("\n[ 삭제 후 검색 ]");
//			TestUser c = em.find(TestUser.class, userNum);
//			em.remove(em.find(TestUser.class, userNum));
			TestUser c = em.find(TestUser.class, userNum);

			em.remove(em.find(TestUser.class, userNum));
			System.out.println(c);

			tx.commit();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		return testuser;

	}

}
