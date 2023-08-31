package tv;

public abstract class Tv {

	String name;
	int price;
	
	public Tv(String name, int price) {
		this.name = name;
		this.price = price;
		increasePrice();
	}
	
	public String toString(){
	    return String.format("%s: %d��", name, price);
	}
	
	abstract void increasePrice(); //�λ�� ���� �����ϴ� �߻�޼ҵ�
	
}
