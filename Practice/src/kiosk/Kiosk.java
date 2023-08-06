package kiosk;

public class Kiosk {
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
	
	public void subInventory(int count) {
		inventory -= count;
	}

	// 객체지향 특징 반영(캡슐화) -> 의존성 반영 (주문 클래스는 키오스크 클래스에 의존)
	public Order initOrder(String menu, int count) {
		int price = 0;

		if (menu.equals("딸기요거트")) {
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
			return null;
		}

		if (isInventory(count)) {
			Order order = new Order(menu, count, price);
			return order; // 인스턴스 반환
		} else {
			System.out.println("재고가 부족합니다.");
			return null; // 참조형이기 때문에 null반환 가능
		}
	}

}