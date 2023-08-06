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
	public Order initOrder(String menu, int count, int oNum) {
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
			Order order;
			
			//�ֹ� ��� ��ȣ�� ���� Order�� �ڽ� �ν��Ͻ� ����
			if(oNum == 1) {
				order = new DeliveryOrder(menu, count, price); //DeliveryOrder �ν��Ͻ� ����
				return order;
			}else if(oNum == 2) {
				order = new TakeOutOrder(menu, count, price); //TakeOutOrder �ν��Ͻ� ����
				return order;
			}else if (oNum == 3) {
				order = new HereOrder(menu, count, price); //HereOrder �ν��Ͻ� ����
				return order;
			}else {
				System.out.println("�߸��� �ֹ���� ��ȣ�Դϴ�.");
			}
			return null; // �ٸ� ��ȣ �Է� �� null ��ȯ
			
		} else {
			System.out.println("��� �����մϴ�.");
			return null; // �������̱� ������ null��ȯ ����
		}
	}

}