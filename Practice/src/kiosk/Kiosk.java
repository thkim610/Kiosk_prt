package kiosk;

public class Kiosk implements OnDelivery, OnTakeOut, OnHere {
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

	public boolean oNumCheck(int oNum) {
		if (oNum == 1 || oNum == 2 || oNum == 3) {
			return true;
		} else {
			return false;
		}
	}

	public void subInventory(int count) {
		inventory -= count;
		System.out.println("���� ���� ���: " + inventory);
	}

	// ��ü���� Ư¡ �ݿ�(ĸ��ȭ) -> ������ �ݿ� (�ֹ� Ŭ������ Ű����ũ Ŭ������ ����)
	public Order initOrder(String menu, int count, int oNum) {
		Order order = null;
		int price = 0;

		if (menu.equals("��")) {
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
		}

		if (isInventory(count)) {

			// �ֹ� ��� ��ȣ�� ���� Order�� �ڽ� �ν��Ͻ� ����
			if (oNum == 1) {
				order = new DeliveryOrder(menu, count, price); // DeliveryOrder �ν��Ͻ� ����
				// �ٿ�ĳ�����Ͽ� DeliveryOrder �ν��Ͻ��� ���ڰ����� �������̽��� ���ڰ��� ����
				((DeliveryOrder) order).setOnDelivery(this);

			} else if (oNum == 2) {
				order = new TakeOutOrder(menu, count, price); // TakeOutOrder �ν��Ͻ� ����
				// �ٿ�ĳ�����Ͽ� TakeOutOrder �ν��Ͻ��� ���ڰ����� �������̽��� ���ڰ��� ����
				((TakeOutOrder) order).setOnTakeOut(this);
			} else if (oNum == 3) {
				order = new HereOrder(menu, count, price); // HereOrder �ν��Ͻ� ����
				// �ٿ�ĳ�����Ͽ� HereOrder �ν��Ͻ��� ���ڰ����� �������̽��� ���ڰ��� ����
				((HereOrder) order).setOnHere(this);
			}

		} else {
			System.out.println("��� �����մϴ�.");
		}
		return order;
	}

	// OnDelivery �������̽��� ���ǵ� �߻�޼ҵ� ����
	@Override
	public void successDelivery(String menu, String locate, int count) {
		System.out.println(locate + " �ּҷ� " + menu + " ��� �ֹ��� �Ϸ� �Ǿ����ϴ�.");
		subInventory(count); // ����� ���� ����
	}

	// OnTakeOut �������̽��� ���ǵ� �߻�޼ҵ� ����
	@Override
	public void successTakeOut(String menu, int time, int count) {
		System.out.println(time + "�� �� " + menu + " ���� �ֹ��� �Ϸ�˴ϴ�. ��� ��ٷ��ּ���.");
		subInventory(count); // ����� ���� ����

	}

	// OnHere �������̽��� ���ǵ� �߻�޼ҵ� ����
	@Override
	public void successHere(String menu, int orderNum, int count) {
		System.out.println(orderNum + "��ȣ�� " + menu + " �ֹ��� �Ϸ�Ǿ����ϴ�. ��� ��ٷ��ּ���.");
		subInventory(count); // ����� ���� ����
	}

}