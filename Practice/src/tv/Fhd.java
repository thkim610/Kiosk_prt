package tv;

public class Fhd extends Tv{

	public Fhd(String name, int price) {
		super(name, price);
	}

	//FHD는 10000원 인상
	@Override
	void increasePrice() {
		super.price += 10000;
		
	}

}
