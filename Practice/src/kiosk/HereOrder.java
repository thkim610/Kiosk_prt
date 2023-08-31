package kiosk;

public class HereOrder extends Order{

	private OnHere onHere;
	private int orderNum;
	
	//HereOrder 생성자(Order 클래스 상속)
	public HereOrder(String menu, int count, int price) {
		super(menu, count, price);
	}

	public void setOnHere(OnHere onHere) {
		this.onHere = onHere;
	}
	
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	
	//order의 setOrderPrice()를 오버라이딩하여 매장 주문 시 주문 금액 출력
	@Override
	protected void setOrderPrice(int price) {
		super.setOrderPrice(price);
		System.out.println(orderPrice+"원 입니다.");
	}
	
	//order의 runOrder()를 오버라이딩하여 매장 주문 시 주문완료 문구 출력
	@Override
	public boolean runOrder(int deposit) {
		int change = deposit - orderPrice;
		if (change >= 0) {
			System.out.println("잔돈 "+change+"원 입니다. ");
			onHere.successHere(menu, orderNum, count);;
			return true;
		} else {
			System.out.println("금액이 부족합니다.");
			return false;
		}
	}
	

}
