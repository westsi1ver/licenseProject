package testLicense.view;

import java.util.List;

import model.entity.TestT;

public class EndView {

	public static void listView(List<?> SearchAll) {
		if (SearchAll != null) {
			int length = SearchAll.size();
			if (length != 0) {
				int sum = 0;
				for (int i = 0; i < length; i++) {
					sum = i + 1;
				}
				System.out.println("검색한 총 결과 :" + sum);
				for (int index = 0; index < length; index++) {
					System.out.println(SearchAll.get(index));
				}
			} else {
				System.out.println("검색결과가 존재하지 않습니다.");
			}

		} else {
			System.out.println("검색결과가 존재하지 않습니다...");
		}
	}

	public static void showError(String msg) {
		System.out.println(msg);
	}

	public static void showmessage(String msg) {
		System.out.println(msg);
	}
	
	public static void oneView(TestT updateTestFee) {
		System.out.println(updateTestFee);
	}

	public static void printOne(Object object) {
		if (object != null) {
			System.out.println(object);
		} else {
			System.out.println("요청하신 정보가 없습니다.");
		}
	}

}
