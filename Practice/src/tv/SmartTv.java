package tv;

public class SmartTv extends Tv{

	public SmartTv(String name, int price) {
		super(name, price);
	}

	//SmartTv는 30000원 인상
	@Override
	void increasePrice() {
		super.price += 30000;
	}
	
	//앱 실행 메소드
	void openApp(String appName) {
		System.out.println(appName+"를(을) 실행합니다.");
	}

}
