package exchange;

public class Exchange {

	private double amount;
	private String notation;
	
	public Exchange(double amount, String notation) {
		this.amount = amount;
		this.notation = notation;
	}

	public String toString(){
	    return String.format("%s: %f %s", this.getClass().getSimpleName(), amount, notation);
	}
	
	
}
