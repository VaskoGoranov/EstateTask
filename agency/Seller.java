package agency;

import java.util.Random;

import estates.Estate;

public class Seller extends Client {
	
	private Estate estate;
	private Agency agency;
	private int money;

	public Seller(String name, String phone, Estate estate, Agency agency) {
		super(name, phone);
		this.estate = estate;
		this.agency = agency;
		this.estate.setSeller(this);
		this.money = 0;
	}

	public void registerEstate () {
		this.agency.getCatalog().get(this.estate.getEstateType()).add(this.estate);
		this.estate.setAgent(this.agency.getAgents().get(new Random().nextInt(agency.getAgents().size())));
		this.estate.getAgent().getSellers().add(this);
	}

	@Override
	public String toString() {
		return this.getName() + ", phone: " + this.getPhone();
	}

	
	

}
