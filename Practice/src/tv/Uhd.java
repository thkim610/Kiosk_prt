package tv;

public class Uhd extends Tv{

	public Uhd(String name, int price) {
		super(name, price);
	}

	//UHD�� 20000�� �λ�
	@Override
	void increasePrice() {
		super.price += 20000;
	}

}
