package tv;

public class SmartTv extends Tv{

	public SmartTv(String name, int price) {
		super(name, price);
	}

	//SmartTv�� 30000�� �λ�
	@Override
	void increasePrice() {
		super.price += 30000;
	}
	
	//�� ���� �޼ҵ�
	void openApp(String appName) {
		System.out.println(appName+"��(��) �����մϴ�.");
	}

}
