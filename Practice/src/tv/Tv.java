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
	    return String.format("%s: %d원", name, price);
	}
	
	abstract void increasePrice(); //인상된 가격 정의하는 추상메소드
	
}
