package testLicense.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import model.entity.TestLoc;
import model.entity.TestT;
import util.PublicCommon;

public class TestLocDAO {

	
	//모든 시험장 검색
//	@Test
	public static List<TestLoc> TestLocSearchAll() {
		List<TestLoc> locAll = null;
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			locAll = em.createQuery("select t from TestLoc t", TestLoc.class ).getResultList();
			
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
		em.close();
		em = null;
	}
		return locAll;
}

	



//	//@Test
//		public void TestLocSearch() {
//			EntityManager em = PublicCommon.getEntityManager();
//			
//			int avaId = 3;
//			AvailableDAO ava = em.find(AvailableDAO.class, avaId);
//			
//			TestLoc loc = ava.getTestLoc();
//			TestT test = ava.getTestT();
//			
//			
//			em.close();
//			em=null;
//			
//
//		}

}