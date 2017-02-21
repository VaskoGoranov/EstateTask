package agency;

import estates.Estate;

public class View {
	
	private Estate estate;
	private Agent agent;
	private Buyer buyer;
	private String date;
	
	public View(Estate estate, Agent agent, Buyer buyer, String date) {
		this.estate = estate;
		this.agent = agent;
		this.buyer = buyer;
		this.date = date;
	}

	public Estate getEstate() {
		return estate;
	}
	
	

}
