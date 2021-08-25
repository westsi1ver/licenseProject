package testLicense.view;

import java.util.ArrayList;
import java.util.List;

import model.entity.TestT;

public class EndView {

	public static void listView(List<?> SearchAll) {
		if(SearchAll != null) {
			int length = SearchAll.size();
			if(length != 0) {
				int sum = 0;
				for(int i =0; i<length;i++) {
					sum = i+1;
				}
				System.out.println("모든 시험장 수 :" + sum );
				for(int index = 0; index < length; index++){			
					System.out.println(SearchAll.get(index));
			}
		}else {
			System.out.println("존재하는 시험장이 없어요.");
		}
		
	}else {
		System.out.println("존재하는 시험장이 없습니다.");
	}
	}

	public static void showError(String msg) {
		System.out.println(msg);
		
	}

<<<<<<< HEAD
	public static void oneView(TestT updateTestFee) {
		System.out.println(updateTestFee);
	}

=======
	public static void printAll (ArrayList all) {
		if(all != null) {
			int length = all.size();
			if(length != 0) {
				int sum = 0;
				for(int i =0; i<length;i++) {
					sum = i+1;
				}
				System.out.println("모든 시험장 수 :" + sum );
				for(int index = 0; index < length; index++){			
					System.out.println(all.get(index));
			}
		}else {
			System.out.println("존재하는 시험장이 없어요.");
		}
		
	}else {
		System.out.println("존재하는 시험장이 없습니다.");
	}
	}
	
	public static void printOne(Object object) {
		if (object != null) {
			System.out.println(object);
		} else {
			System.out.println("요청하신 정보가 없습니다.");
		}
	}
	
	
	
>>>>>>> a6bc92e83bc3cc548a5ba56c458b874d3dc55b8b
	
	
	
	
}
