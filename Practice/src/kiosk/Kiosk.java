package kiosk;

public class Kiosk implements OnDelivery, OnTakeOut, OnHere {
	public static int key = 0;
	private int inventory; // 재고 개수

	// 생성자
	public Kiosk(int inventory) {
		this.inventory = inventory;
	}

	// 재고 개수가 충분히 있는지 확인 (true/false)
	private boolean isInventory(int count) {
		if (inventory >= count) {
			return true;
		} else {
			return false;
		}
	}

	public boolean oNumCheck(int oNum) {
		if (oNum == 1 || oNum == 2 || oNum == 3) {
			return true;
		} else {
			return false;
		}
	}

	public void subInventory(int count) {
		inventory -= count;
		System.out.println("매장 남은 재고: " + inventory);
	}

	// 객체지향 특징 반영(캡슐화) -> 의존성 반영 (주문 클래스는 키오스크 클래스에 의존)
	public Order initOrder(String menu, int count, int oNum) {
		Order order = null;
		int price = 0;

		if (menu.equals("물")) {
			price = 4500;
		} else if (menu.equals("카페라떼") || menu.equals("밀크티")) {
			price = 3500;
		} else if (menu.equals("아메리카노")) {
			price = 2000;
		} else {
			price = 0;
		}

		if (price == 0) {
			System.out.println("메뉴가 없습니다.");
		}

		if (isInventory(count)) {

			// 주문 방식 번호에 따라 Order의 자식 인스턴스 생성
			if (oNum == 1) {
				order = new DeliveryOrder(menu, count, price); // DeliveryOrder 인스턴스 생성
				// 다운캐스팅하여 DeliveryOrder 인스턴스의 인자값들을 인터페이스의 인자값에 저장
				((DeliveryOrder) order).setOnDelivery(this);

			} else if (oNum == 2) {
				order = new TakeOutOrder(menu, count, price); // TakeOutOrder 인스턴스 생성
				// 다운캐스팅하여 TakeOutOrder 인스턴스의 인자값들을 인터페이스의 인자값에 저장
				((TakeOutOrder) order).setOnTakeOut(this);
			} else if (oNum == 3) {
				order = new HereOrder(menu, count, price); // HereOrder 인스턴스 생성
				// 다운캐스팅하여 HereOrder 인스턴스의 인자값들을 인터페이스의 인자값에 저장
				((HereOrder) order).setOnHere(this);
			}

		} else {
			System.out.println("재고가 부족합니다.");
		}
		return order;
	}

	// OnDelivery 인터페이스에 정의된 추상메소드 구현
	@Override
	public void successDelivery(String menu, String locate, int count) {
		System.out.println(locate + " 주소로 " + menu + " 배달 주문이 완료 되었습니다.");
		subInventory(count); // 재고에서 개수 차감
	}

	// OnTakeOut 인터페이스에 정의된 추상메소드 구현
	@Override
	public void successTakeOut(String menu, int time, int count) {
		System.out.println(time + "분 뒤 " + menu + " 포장 주문이 완료됩니다. 잠시 기다려주세요.");
		subInventory(count); // 재고에서 개수 차감

	}

	// OnHere 인터페이스에 정의된 추상메소드 구현
	@Override
	public void successHere(String menu, int orderNum, int count) {
		System.out.println(orderNum + "번호로 " + menu + " 주문이 완료되었습니다. 잠시 기다려주세요.");
		subInventory(count); // 재고에서 개수 차감
	}

}