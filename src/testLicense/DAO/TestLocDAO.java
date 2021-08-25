package testLicense.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.entity.AvailableTest;
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

	public static List<?> testLocSpecialSearch(String testName) {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		int tt = (Integer) null;
		List<TestLoc> locSpecial = null;
		List<AvailableTest> locNum = null;
		tx.begin();
		
//		try {
//			tt = ((TestT) em.createQuery("SELECT tt FROM TEST_T tt WHERE tt.TEST_NAME like 'testName%'", TestT.class)).getTestNumber();
//			locNum = (List<AvailableTest>) em.find(AvailableTest.class, tt);
//			
//		}
		
		return null;
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