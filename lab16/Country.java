package lab16;

public class Country {

	private String name;//gives it stability, control for preventing errors
	private int populations;//gives it stability, control for preventing errors
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulations() {
		return populations;
	}

	public void setPopulations(int populations) {
		this.populations = populations;
	}

	public Country() {//default one that's required, Make sure you write it.
		super();
	}
	public Country (String name, int populations) {
		super();
		this.name = name;
		this.populations = populations;
}

	@Override
	public String toString() {
		return "Country [name=" + name + ", populations=" + populations + "]";
	}
}