package kiosk;

public class TakeOutOrder extends Order {

	private int time;
	
	//TakeOutOrder ������(Order Ŭ���� ���)
	public TakeOutOrder(String menu, int count, int price) {
		super(menu, count, price);
	}

	public void setTime(int time) {
		this.time = time;
	}

	//order�� setOrderPrice()�� �������̵��Ͽ� ���� �ֹ� �� �ֹ� �ݾ� ���
	@Override
	protected void setOrderPrice(int price) {
		int discount = 500; //���� ���ξ�
		super.setOrderPrice(price);
		orderPrice -= discount;
		System.out.println("����ũ �ƿ��� "+discount+"���� ���εǾ� "+orderPrice+"���Դϴ�.");
	}
	
	//order�� runOrder()�� �������̵��Ͽ� ���� �ֹ� �� �ֹ��Ϸ� ���� ���
	@Override
	public boolean runOrder(int deposit) {
		int change = deposit - orderPrice;
		if (change >= 0) {
			System.out.print("�ܵ� "+change+"�� �Դϴ�. ");
			System.out.println(time+ "�� �� "+ menu + " ���� �ֹ��� �Ϸ�˴ϴ�. ��� ��ٷ��ּ���.");
			return true;
		} else {
			System.out.println("�ݾ��� �����մϴ�.");
			return false;
		}
	}

	
	
}
