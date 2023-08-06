package kiosk;

public class Order {
	public String menu;
	public int count;
	private int orderPrice; //������ �� ����
	
	public Order(String menu, int count, int price) {
		this.menu = menu;
		this.count = count;
		setOrderPrice(price);
	}
	
	public boolean runOrder(int deposit) {
		int change = deposit - orderPrice;
		if (change >= 0) {
			System.out.print("�ܵ� "+change+"�� ");
			System.out.println(menu + " ���Խ��ϴ�.");
			return true;
		} else {
			System.out.println("�ݾ��� �����մϴ�.");
			return false;
		}
	}
	
	
	private void setOrderPrice(int price) {
		orderPrice = price * count; // �Ѱ��� = ���ᰡ�� * ����
		System.out.println(orderPrice + "�� �Դϴ�.");
	}

	public int getOrderPrice() {
		return this.orderPrice; // �� ���� ��� �޼ҵ�
	}

}