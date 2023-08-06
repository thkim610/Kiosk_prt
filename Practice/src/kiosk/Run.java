package kiosk;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//키오스크 키 입력
		System.out.println("키오스크 키를 입력해주세요");
		int key = sc.nextInt();

		//키오스크 키 확인
		if (Kiosk.key == key) {
			//매장 재고 개수 설정
			System.out.println("매장 재고개수를 입력해주세요");
			int inventory = sc.nextInt();
			
			//Kiosk 클래스 인스턴스 생성 
			Kiosk k = new Kiosk(inventory);
			while (true) {
				System.out.println("메뉴와 개수를 입력해주세요");
				String menu = sc.next();
				if (menu.equals("종료")) {
					System.out.println("프로그램을 종료 합니다.");
					break;
				}
				
				int count = sc.nextInt();
				
				//kiosk 인스턴스의 initOrder 메소드를 Order 타입으로 업캐스팅
				Order order = k.initOrder(menu, count); //initOrder()는 Order타입
				if (order == null) {
					continue;
				}
				
				int deposit = sc.nextInt(); //입금금액
				if (order.runOrder(deposit)) {
					k.subInventory(count); //재고에서 개수 차감
				}
				
			}
			
		} else {
			System.out.println("키오스크 키가 맞지 않습니다.");
		}
		
		sc.close();
	}

}