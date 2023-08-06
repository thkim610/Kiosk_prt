package kiosk;

public class DeliveryOrder extends Order{

	OnDelivery onDelivery;
	String locate; //��� �ּ�

	//DeliveryOrder ������(Order Ŭ���� ���)
	public DeliveryOrder(String menu, int count, int price) {
		super(menu, count, price);
		setLocate(locate);
	}
	
	public void setLocate(String locate) {
		this.locate = locate;
	}

	public void setOnDelivery(OnDelivery onDelivery) {
		this.onDelivery = onDelivery;
	}
	
	//order�� setOrderPrice()�� �������̵��Ͽ� ��� �ֹ� �� �ֹ� �ݾ� ���
	@Override
	protected void setOrderPrice(int price) {
		int deliveryTips = 3000; //��޷�
		orderPrice = price * count + deliveryTips;
		System.out.println("��޺� "+deliveryTips+"���� �߰��Ǿ� "+orderPrice+"���Դϴ�.");
		System.out.println("��� �ֹ��� ��Ȯ�� �ݾ��� ���� ���ּ���.");
		
	}

	//order�� runOrder()�� �������̵��Ͽ� ��� �ֹ� �� �ֹ��Ϸ� ���� ���
	@Override
	public boolean runOrder(int deposit) {
		int change = deposit - orderPrice;
		if (change >= 0) {
			onDelivery.successDelivery(menu, locate, count);
			return true;
		} else {
			System.out.println("�ݾ��� �����մϴ�.");
			return false;
		}
	}

	
	
	
}