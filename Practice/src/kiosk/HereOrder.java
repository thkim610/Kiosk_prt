package kiosk;

public class HereOrder extends Order{

	private int orderNum;
	
	//HereOrder ������(Order Ŭ���� ���)
	public HereOrder(String menu, int count, int price) {
		super(menu, count, price);
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	
	//order�� setOrderPrice()�� �������̵��Ͽ� ���� �ֹ� �� �ֹ� �ݾ� ���
	@Override
	protected void setOrderPrice(int price) {
		super.setOrderPrice(price);
		System.out.println(orderPrice+"�� �Դϴ�.");
	}
	
	//order�� runOrder()�� �������̵��Ͽ� ���� �ֹ� �� �ֹ��Ϸ� ���� ���
	@Override
	public boolean runOrder(int deposit) {
		int change = deposit - orderPrice;
		if (change >= 0) {
			System.out.println("�ܵ� "+change+"�� �Դϴ�. ");
			System.out.println(orderNum+ "��ȣ�� "+ menu + " �ֹ��� �Ϸ�Ǿ����ϴ�. ��� ��ٷ��ּ���.");
			return true;
		} else {
			System.out.println("�ݾ��� �����մϴ�.");
			return false;
		}
	}
	

}
