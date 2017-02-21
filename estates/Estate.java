package estates;

import agency.Agent;
import agency.Seller;

public abstract class Estate {
	
	public enum EstateType {APARTMENT, HOUSE, PLOT}
	
	private String description;
	private String address;
	private int price;
	private EstateType estateType;
	private double area;
	private Agent agent;
	private Seller seller;
	
	public Estate(String description, String address, int price, EstateType estateType, double area) {
		this.description = description;
		this.address = address;
		this.price = price;
		this.estateType = estateType;
		this.area = area;
		
	}
	
	public abstract void printInfo (); 

	public EstateType getEstateType() {
		return estateType;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Agent getAgent() {
		return agent;
	}

	public int getPrice() {
		return price;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	
	

}
