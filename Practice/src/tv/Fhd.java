package tv;

public class Fhd extends Tv{

	public Fhd(String name, int price) {
		super(name, price);
	}

	//FHD�� 10000�� �λ�
	@Override
	void increasePrice() {
		super.price += 10000;
		
	}

}
