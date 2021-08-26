package testLicense.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import model.entity.AvailableTest;
import model.entity.TestLoc;
import model.entity.TestT;
import util.PublicCommon;

public class AvailableDAO {

//	
//	//특정 시험 (sql에 따른 시험장들 검색 -list)
//	@Test
//	public List<?> testLocSearch(int testid){
//		
//		EntityManager em = PublicCommon.getEntityManager();
//		EntityTransaction tx = em.getTransaction();
//
//		
//		tx.begin();
//		
//		try {
//			AvailableTest map = em.find(AvailableTest.class, avaid);
////			TestT test = map.getTestNumber().;
////			TestLoc loc = map.getLocNumber().getLocName();
//			
////			TestT test = em.find(TestT.class,testid);
////			AvailableTest map = test.getTestName();
////			TestLoc loc = map.getLocNumber().getLocName();
//			
//			TestT test = em.find(TestT.class,testid);
//			String test1 = map.getLocNumber().getLocName();
//			
//			
//			
//		}catch(Exception e) {
//			tx.rollback();
//			e.printStackTrace();
//		} finally {
//			em.close();
//		}
//		
//		
//		return test;
//		
//	}
	
	


}
