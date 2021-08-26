package testLicense.DAO;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.util.ArrayList;
import java.util.List;

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

	public List<TestUser> testUserAllRead() {
		EntityManager em = PublicCommon.getEntityManager();
		List<TestUser> TestUserall = null;
		
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
			t1 = (TestUser) em.createNamedQuery("TestUser.findbyuserId").setParameter("userId", userId).getSingleResult();
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
	public void testUserUpdate(int user_no, String phoneNum) {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		
		try {

			TestUser t = em.find(TestUser.class, user_no);
			t.setUserPhone(phoneNum);

			System.out.println(t);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}

	}

//	@Test
	public void testUserDelete(int userNum) {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {

			System.out.println("[ 삭제 전 검색 ]");
			TestUser user = em.find(TestUser.class, userNum);
			System.out.println(user);

			em.remove(user);

			System.out.println("\n[ 삭제 후 검색 ]");
			TestUser c = em.find(TestUser.class, userNum);

			if (c == null) {
				System.out.println("찾으시는 데이터가 없습니다.");
			} else {
				System.out.println(c);
			}

			tx.commit();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}

	}

}
