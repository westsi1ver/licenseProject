package testLicense.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.entity.TestLoc;
import util.PublicCommon;

public class TestLocDAO {

	private static TestLocDAO instance = new TestLocDAO();

	private TestLocDAO() {
	}

	public static TestLocDAO getInstance() {
		return instance;
	}

	// 모든 시험장 검색
//	@Test
	public List<TestLoc> testLocSearchAll() {
		List<TestLoc> locAll = null;
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			locAll = em.createQuery("select t from TestLoc t", TestLoc.class).getResultList();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			em = null;
		}
		return locAll;
	}

//	public List<?> testLocSpecialSearch(String testName) {
//		EntityManager em = PublicCommon.getEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		int tt = (Integer) null;
//		List<TestLoc> locSpecial = null;
//		List<AvailableTest> locNum = null;
//		tx.begin();

//		try {
//			tt = ((TestT) em.createQuery("SELECT tt FROM TEST_T tt WHERE tt.TEST_NAME like 'testName%'", TestT.class)).getTestNumber();
//			locNum = (List<AvailableTest>) em.find(AvailableTest.class, tt);
//			
//		}

//		return null;
//	}

//	//@Test
//		public void testLocSearch() {
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