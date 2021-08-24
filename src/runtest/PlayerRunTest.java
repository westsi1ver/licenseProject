package runtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.persistence.EntityManager;

import model.entity.TestUser;
import util.PublicCommon;

public class PlayerRunTest {

//	@Test
//	public void activistCreate() {
//		EntityManager em = PublicCommon.getEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		
//		tx.begin();
//		
//		try {
//			
//			//ManyToOne���� �����صּ� ���� ������Ʈ�� '�ֻ��' �߰�
//			ProbonoProject p = em.find(ProbonoProject.class, 1);
//			
////			System.out.println(p);
//			
//			Activist a = new Activist("giver4", "�ֻ��", "gp4", "psychology", p);
//			System.out.println(a);
//			
//			em.persist(a);
//			
//			tx.commit();
//			
//		}catch(Exception e) {
//			tx.rollback();
////			e.printStackTrace();
//		}finally {
//			em.close();
//		}
//	}

//	@Test

	public void playerRead() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String esc = null;
		try {

			while (esc == null) {
				System.out.println("===================����� ������ �����ϼ���.===================");
				System.out.println("1) �Ѹ� ã�� \t 2) ��ü ����ã�� \t 3)�������� ã��  4)��Ʈ�� ���� ã��\t 5)ÿ�� ���� ã�� 0) �ý��� ����");

				int inputNum = Integer.parseInt(br.readLine());
				EntityManager em = PublicCommon.getEntityManager();

				// findOne
				if (inputNum == 1) {
					System.out.println("[�̸� �˻� ]");
					System.out.println("���� �̸��� �ۼ��� �ּ���: ");
					String name = br.readLine();
					TestUser p = em.find(TestUser.class, name);
					System.out.println(p);
				}

				// findAll
				else if (inputNum == 2) {
					System.out.println("\n[ ��ü ���� ã�� ]");
					List<TestUser> allplayer = em.createQuery("select m from Player m ", TestUser.class).getResultList();
					for (TestUser player : allplayer) {
						System.out.println(player);
					}
					System.out.println("[��ü��� �� ���� �� ]:" + allplayer.size());
				}

				else if (inputNum == 3) {
					System.out.println("\n[ ���� ���� ã�� ]");
					List<TestUser> allplayer0 = em
							.createQuery("select m from Player m where team_Name = '����'", TestUser.class).getResultList();
					for (TestUser player : allplayer0) {
						System.out.println(player);
					}
				}

				else if (inputNum == 4) {
					System.out.println("\n[ ��Ʈ�� ���� ã�� ]");
					List<TestUser> allplayer1 = em
							.createQuery("select m from Player m where team_Name = '��Ʈ��'", TestUser.class)
							.getResultList();
					for (TestUser player1 : allplayer1) {
						System.out.println(player1);
					}
				}

				else if (inputNum == 5) {
					System.out.println("\n[ ÿ�� ���� ã�� ]");
					List<TestUser> allplayer2 = em
							.createQuery("select m from Player m where team_Name = 'ÿ��'", TestUser.class).getResultList();
					for (TestUser player2 : allplayer2) {
						System.out.println(player2);
					}
				}
				
				else if(inputNum == 0) {
					System.out.println("�ý�������");
					break;
				}

				em.close();
			}
		} catch (IOException | NumberFormatException |

				ArrayIndexOutOfBoundsException e) {
//		e.printStackTrace();
//		EndView.showError("���信 �°� �Է����ּ���.");
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void playerUpdate() {
		
	}
	
////	@Test
//	public void activistUpdate() {
//		EntityManager em = PublicCommon.getEntityManager();
//		EntityTransaction tx = em.getTransaction();
//
//		try {
//
//			Activist a = em.find(Activist.class, "giver4");	
//			a.setMajor("**** �����о� update ****");
//			System.out.println(a);
//
//		}catch(Exception e) {
//			tx.rollback();
//			e.printStackTrace();
//		}finally {
//			em.close();
//		}
//	}
//	
////	@Test
//	public void activistDelete() {
//		EntityManager em = PublicCommon.getEntityManager();
//		EntityTransaction tx = em.getTransaction();
//
//		tx.begin();
//		
//		try {
//			
//			System.out.println("[ ���� �� �˻� ]");
//			Activist a = em.find(Activist.class, "giver4");	
//			System.out.println(a);
//			
//			em.remove(a);
//			
//			System.out.println("\n[ ���� �� �˻� ]");
//			Activist b = em.find(Activist.class, "giver4");	
//			
//			if(b == null) {
//				System.out.println("ã���ô� �����Ͱ� �����ϴ�.");
//			}else {
//				System.out.println(b);
//			}
//
//			tx.commit();
//
//		}catch(Exception e) {
//			tx.rollback();
//			e.printStackTrace();
//		}finally {
//			em.close();
//		}
//	}
}
