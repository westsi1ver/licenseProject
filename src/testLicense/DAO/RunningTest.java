package testLicense.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import model.entity.TestOrg;
import util.PublicCommon;


public class RunningTest {
	
	

	@Test
	public void test1() {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		System.out.println(em);
		
		
		tx.begin();
//		
		try {
		
			TestOrg testorg = new TestOrg();
//			testorg.setOrgNumber(1);
			testorg.setOrgName("Qnet");
			testorg.setOrgPhone("031654987");
			testorg.setOrgUrl("www.naver.com");
			
			em.persist(testorg);
			tx.commit();
//			em.close();
			
		}catch(Exception e) {
			tx.rollback();
//			e.printStackTrace();
		}finally {
			em.close();
			PublicCommon.getEntityManager().close();
		}
	}
		
	
////	@Test
//	public void createTeam( ) {
////		EntityManager em = PublicCommon.getEntityManager();
////		EntityTransaction tx = em.getTransaction();
//		
//		tx.begin();
//		
//		try {
////			========����===========
//			TestT st1 = new TestT();
//			st1.setTeamName("����");
//			
//			TestUser p1 = new TestUser();
//			p1.setPlayerName("������");
//			p1.setSalary(5655);
//			p1.setTeamName("����");
//			p1.setPteamNo(st1);
//			
//			TestUser p2 = new TestUser();
//			p2.setPlayerName("ȣ����");
//			p2.setSalary(9995);
//			p2.setTeamName("����");
//			p2.setPteamNo(st1);
//
//			TestUser p3 = new TestUser();
//			p3.setPlayerName("���");
//			p3.setSalary(8995);
//			p3.setTeamName("����");
//			p3.setPteamNo(st1);
//
//			
//			
//			TestOrg d1 = new TestOrg();
//			d1.setDirectorName("�۰Ž�");
//			d1.setSalary(5687);
//			d1.setDteamNo(st1);
//			
//			st1.getPList().add(p1);
//			st1.getPList().add(p2);
//			st1.getPList().add(p3);
//			st1.getDList().add(d1);
//			
//			System.out.println(st1);
//			System.out.println(p1);
//			System.out.println(p2);
//			System.out.println(p3);
//			
//			System.out.println(d1);
//			
//			
////			em.remove(d1);
////			em.remove(p1);
////			em.remove(st1);
//			em.persist(st1);
//			em.persist(p1);
//			em.persist(p2);
//			em.persist(p3);
//			em.persist(d1);
////			===============ÿ��====================
//			TestT st2 = new TestT();
//			st2.setTeamName("ÿ��");
//
//			TestUser cp1 = new TestUser();
//			cp1.setPlayerName("��Ϲ�");
//			cp1.setSalary(7878);
//			cp1.setTeamName("ÿ��");
//			cp1.setPteamNo(st2);
//			
//			TestUser cp2 = new TestUser();
//			cp2.setPlayerName("���ĵ�");
//			cp2.setSalary(9225);
//			cp2.setTeamName("ÿ��");
//			cp2.setPteamNo(st2);
//			
//			
//			TestOrg d2 = new TestOrg();
//			d2.setDirectorName("������");
//			d2.setSalary(5687);
//			d2.setDteamNo(st2);
//			
//			st2.getPList().add(cp1);
//			st2.getPList().add(cp2);
//			st2.getDList().add(d2);
//			
//			System.out.println(st2);
//			System.out.println(cp1);
//			System.out.println(cp2);
//			System.out.println(d2);
//			
//			
////			em.remove(d1);
////			em.remove(p1);
////			em.remove(st1);
//			em.persist(st2);
//			em.persist(cp1);
//			em.persist(cp2);
//			em.persist(d2);
//			
////===================��Ʈ��========================			
//			
//			TestT st3 = new TestT();
//			st3.setTeamName("��Ʈ��");
//
//			TestUser tp1 = new TestUser();
//			tp1.setPlayerName("�����");
//			tp1.setSalary(7878);
//			tp1.setTeamName("��Ʈ��");
//			tp1.setPteamNo(st3);
//			
//			TestUser tp2 = new TestUser();
//			tp2.setPlayerName("�̿�ǥ");
//			tp2.setSalary(9225);
//			tp2.setTeamName("��Ʈ��");
//			tp2.setPteamNo(st3);
//			
//			
//			TestOrg d3 = new TestOrg();
//			d3.setDirectorName("��üƼ��");
//			d3.setSalary(5687);
//			d3.setDteamNo(st3);
//			
//			st3.getPList().add(tp1);
//			st3.getPList().add(tp2);
//			st3.getDList().add(d3);
//			
//			System.out.println(st3);
//			System.out.println(tp1);
//			System.out.println(tp2);
//			System.out.println(d3);
//			
//			
////			em.remove(d1);
////			em.remove(p1);
////			em.remove(st1);
//			em.persist(st3);
//			em.persist(tp1);
//			em.persist(tp2);
//			em.persist(d3);
//			tx.commit();
//		}catch(Exception e) {
//			tx.rollback();
////			e.printStackTrace();
//		}finally {
//			em.close();
//			PublicCommon.getEntityManager().close();
//		}
//	}
	
}
