package testLicense.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.entity.TestLoc;
import util.PublicCommon;

public class TestLocDAO {

	private static TestLocDAO instance = new TestLocDAO();

	private TestLocDAO() {}

	public static TestLocDAO getInstance() {
		return instance;
	}

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
}