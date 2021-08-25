package testLicense.DAO;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.entity.TestOrg;
import model.entity.TestT;
import util.PublicCommon;

public class TestTDAO {


	public static TestT updateTestFee3(int testNum, int fee) {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		TestT tt = null;
		tx.begin();
		
		try {
			tt = em.find(TestT.class, testNum);
			tt.setTestFee(fee);
			tt.getOrgNumber().getOrgName();
			em.persist(tt);
			
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally{
			em.close();
		}
			
		return tt;
	}

	public static TestT updateTest(String testName,int testFee,Date testEndDate,Date testDay, String orgName, String orgPhone, String orgUrl) {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		TestOrg newOrg = new TestOrg();
		TestT newTest = new TestT();
		tx.begin();
		
		try {
		
			newOrg.setOrgName(orgName);
			newOrg.setOrgPhone(orgPhone);
			newOrg.setOrgUrl(orgUrl);

			newTest.setTestDay(testDay);
			newTest.setTestEndDate(testEndDate);
			newTest.setTestFee(testFee);
			newTest.setTestName(testName);
			newTest.setOrgNumber(newOrg);
			
			newOrg.getTestList().add(newTest);
			
			em.persist(newOrg);
			em.persist(newTest);
			
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally{
			em.close();
		}
			
		return newTest;
	}
	
	
	public static TestT testDelete(int testNum) {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		TestT tt = null;
		TestOrg kk = new TestOrg();

		tx.begin();
		
		try {
			tt = em.find(TestT.class,testNum);
			kk = tt.getOrgNumber();
			em.remove(kk);
			em.remove(tt);
			
			tx.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally {
			em.close();
		}
		return tt;
	}
	

}
