package kiosk;

public class Kiosk {
	public static int key = 0;
	private int inventory; // ��� ����

	// ������
	public Kiosk(int inventory) {
		this.inventory = inventory;
	}
	
	// ��� ������ ����� �ִ��� Ȯ�� (true/false)
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

	// ��ü���� Ư¡ �ݿ�(ĸ��ȭ) -> ������ �ݿ� (�ֹ� Ŭ������ Ű����ũ Ŭ������ ����)
	public Order initOrder(String menu, int count) {
		int price = 0;

		if (menu.equals("������Ʈ")) {
			price = 4500;
		} else if (menu.equals("ī���") || menu.equals("��ũƼ")) {
			price = 3500;
		} else if (menu.equals("�Ƹ޸�ī��")) {
			price = 2000;
		} else {
			price = 0;
		}

		if (price == 0) {
			System.out.println("�޴��� �����ϴ�.");
			return null;
		}

		if (isInventory(count)) {
			Order order = new Order(menu, count, price);
			return order; // �ν��Ͻ� ��ȯ
		} else {
			System.out.println("��� �����մϴ�.");
			return null; // �������̱� ������ null��ȯ ����
		}
	}

}