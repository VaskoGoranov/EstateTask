package agency;

import java.util.ArrayList;
import java.util.Random;

import estates.Estate;

public class Buyer extends Client {
	
	private int money;
	private ArrayList<View> views;
	private Agent agent;
	private Agency agency;
	
	public Buyer(String name, String phone, int money, Agency agency) {
		super(name, phone);
		this.money = money;
		this.views = new ArrayList<>();
		this.agency = agency;
	}
	
	public void registerInAgency (Agency a) {
		this.agent = a.getAgents().get(new Random().nextInt(a.getAgents().size()));
		this.agent.getBuyers().add(this);
	}
	
	public void askForView (Estate e) {
		if (e.getPrice() < this.money) {
			View view = new View(e, this.agent, this, "Today");
			this.views.add(view);
			e.getAgent().getViews().add(view);
		}
		else {
			System.out.println(this.getName() + " cannot view " +e.getEstateType() + " price: " + e.getPrice() + ". Not enough money.");
		}
		
	}
	
	public void buyEstate () {
		if (!this.views.isEmpty()) {
			Estate est = this.views.get(new Random().nextInt(this.views.size())).getEstate();
		
			int commission = est.getPrice()*3/100;
			this.agency.setBudget(this.agency.getBudget() + (commission));
			this.agent.setDealsMoney(this.agent.getDealsMoney() + (commission));
			this.money -= est.getPrice();
		}
		else {
			System.out.println(this.getName() + " was not able to view a single estate!");
		}
	}

	public int getMoney() {
		return money;
	}

	public ArrayList<View> getViews() {
		return views;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + money;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		Buyer other = (Buyer) obj;
		if (money != other.money)
			return false;
		return true;
	}
	
	
	
	

}
