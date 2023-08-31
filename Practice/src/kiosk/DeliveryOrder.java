package kiosk;

public class DeliveryOrder extends Order{

	OnDelivery onDelivery;
	String locate; //배달 주소

	//DeliveryOrder 생성자(Order 클래스 상속)
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
	
	//order의 setOrderPrice()를 오버라이딩하여 배달 주문 시 주문 금액 출력
	@Override
	protected void setOrderPrice(int price) {
		int deliveryTips = 3000; //배달료
		orderPrice = price * count + deliveryTips;
		System.out.println("배달비 "+deliveryTips+"원이 추가되어 "+orderPrice+"원입니다.");
		System.out.println("배달 주문은 정확한 금액을 결제 해주세요.");
		
	}

	//order의 runOrder()를 오버라이딩하여 배달 주문 시 주문완료 문구 출력
	@Override
	public boolean runOrder(int deposit) {
		int change = deposit - orderPrice;
		if (change >= 0) {
			onDelivery.successDelivery(menu, locate, count);
			return true;
		} else {
			System.out.println("금액이 부족합니다.");
			return false;
		}
	}
	
	
}