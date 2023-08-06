package kiosk;

public class Order {
	public String menu;
	public int count;
	int orderPrice; //������ �� ����
	
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
	
	
	protected void setOrderPrice(int price) {
		orderPrice = price * count; // �Ѱ��� = ���ᰡ�� * ����
	}

	public int getOrderPrice() {
		return this.orderPrice; // �� ���� ��� �޼ҵ�
	}

}