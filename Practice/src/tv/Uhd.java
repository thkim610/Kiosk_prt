package tv;

public class Uhd extends Tv{

	public Uhd(String name, int price) {
		super(name, price);
	}

	//UHD는 20000원 인상
	@Override
	void increasePrice() {
		super.price += 20000;
	}

}
