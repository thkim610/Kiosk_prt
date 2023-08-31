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
				//주문 방식 입력
				System.out.println("주문 방식 번호를 입력해주세요. (1. 배달 2. 포장 3. 매장)");
				int oNum = sc.nextInt();
				
				//번호 잘못 입력 시, 다시 입력하라는 문구 출력
				if(!k.oNumCheck(oNum)) {
					System.out.println("번호를 다시 입력해주세요.");
					continue;
				}
				
				System.out.println("메뉴와 개수를 입력해주세요");
				String menu = sc.next();
				
				//"종료" 입력 시, 반복문을 빠져나가 kiosk 종료
				if (menu.equals("종료")) {
					System.out.println("프로그램을 종료 합니다.");
					break;
				}
				
				int count = sc.nextInt();
				
				//kiosk 인스턴스의 initOrder 메소드를 Order 타입으로 업캐스팅
				Order order = k.initOrder(menu, count,oNum); //initOrder()는 Order타입
				if (order == null) {
					continue;
				}
				
				System.out.print("입금 금액: ");
				int deposit = sc.nextInt(); //입금금액
				
				//주문 방식에 따른 추가 정보 입력
				if(oNum == 1) {
					DeliveryOrder od = (DeliveryOrder) order; //DeliveryOrder로 다운캐스팅
					System.out.println("배달 주소를 입력해주세요.");
					String locate = sc.next();
					
					od.setLocate(locate); //배달 주소 저장
					
				}else if(oNum == 2) {
					TakeOutOrder to = (TakeOutOrder)order; // TakeOutOrder로 다운캐스팅
					System.out.println("포장 시간을 입력해주세요.");
					int time = sc.nextInt();
					
					to.setTime(time); //포장 시간 저장
				}else if(oNum == 3) {
					HereOrder ho = (HereOrder)order; // HereOrder로 다운캐스팅
					System.out.println("주문번호를 입력해주세요.");
					int orderNum = sc.nextInt();
					
					ho.setOrderNum(orderNum); //주문번호 저장
				}
				
				if (order.runOrder(deposit)) {
					
				}
				
			}
			
		} else {
			System.out.println("키오스크 키가 맞지 않습니다.");
		}
		
		sc.close();
	}

}