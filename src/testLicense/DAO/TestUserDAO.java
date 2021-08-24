package testLicense.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import model.entity.TestUser;
import util.PublicCommon;


public class TestUserDAO {
	
	//@Test
	public void TestUserAllRead() {
		EntityManager em = PublicCommon.getEntityManager();
		
//		System.out.println("[1.한명만 찾기] :");
//		TestUser t = (TestUser) em.createNamedQuery("TestUser.findbyuserName").setParameter("userName", "박지성").getSingleResult();
//		System.out.println(t);
		
		System.out.println("[모두찾기]");
		List<TestUser> allTestuser = em.createQuery("select t from TestUser t", TestUser.class ).getResultList();
		for(TestUser t: allTestuser) {
			System.out.println(t);
		}
		em.close();
		em = null;
	}
	
//	@Test
	public void TestUserOneRead() {
		EntityManager em = PublicCommon.getEntityManager();
		
		System.out.println("[1.한명만 찾기] :");
		TestUser t = (TestUser) em.createNamedQuery("TestUser.findbyuserName").setParameter("userName", "김연경").getSingleResult();
		System.out.println(t);
	}
	@Test
	public void TestUserUpdate() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		try {

			TestUser t = em.find(TestUser.class, 3);	
			t.setUserPhone("0316549878");;
			System.out.println(t);

			tx.commit();
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
				
	}
	
//	@Test
	public void probonoDelete() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		
		try {
			
			System.out.println("[ 삭제 전 검색 ]");
			TestUser a = em.find(TestUser.class, 2);	
			System.out.println(a);
			
			em.remove(a);
			
			System.out.println("\n[ 삭제 후 검색 ]");
			TestUser c = em.find(TestUser.class, 2);	
			
			if(c == null) {
				System.out.println("찾으시는 데이터가 없습니다.");
			}else {
				System.out.println(c);
			}

			tx.commit();

		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
	
	
	
	
	}
	
}
