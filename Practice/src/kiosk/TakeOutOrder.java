package kiosk;

public class TakeOutOrder extends Order {

	private OnTakeOut onTakeOut;
	private int time;
	
	//TakeOutOrder 생성자(Order 클래스 상속)
	public TakeOutOrder(String menu, int count, int price) {
		super(menu, count, price);
	}

	public void setOnTakeOut(OnTakeOut onTakeOut) {
		this.onTakeOut = onTakeOut;
	}
	
	public void setTime(int time) {
		this.time = time;
	}

	//order의 setOrderPrice()를 오버라이딩하여 포장 주문 시 주문 금액 출력
	@Override
	protected void setOrderPrice(int price) {
		int discount = 500; //포장 할인액
		super.setOrderPrice(price);
		orderPrice -= discount;
		System.out.println("테이크 아웃은 "+discount+"원이 할인되어 "+orderPrice+"원입니다.");
	}
	
	//order의 runOrder()를 오버라이딩하여 포장 주문 시 주문완료 문구 출력
	@Override
	public boolean runOrder(int deposit) {
		int change = deposit - orderPrice;
		if (change >= 0) {
			System.out.print("잔돈 "+change+"원 입니다. ");
			onTakeOut.successTakeOut(menu, time, count);
			return true;
		} else {
			System.out.println("금액이 부족합니다.");
			return false;
		}
	}

	
}
