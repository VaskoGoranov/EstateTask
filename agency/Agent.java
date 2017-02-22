package agency;

import java.util.ArrayList;
import java.util.HashSet;

public class Agent {
	
	private String name;
	private String phone;
	private HashSet<Buyer> buyers;
	private HashSet<Seller> sellers;
	private ArrayList<View> views;
	private int dealsMoney;
	
	public Agent(String name, String phone) {
		this.name = name;
		this.phone = phone;
		this.buyers = new HashSet<>();
		this.sellers = new HashSet<>();
		this.views = new ArrayList<>();
		dealsMoney = 0;
	}
	

	@Override
	public String toString() {
		return name + ", phone: " + phone + ", money from deals: " + dealsMoney;
	}
	
	public HashSet<Buyer> getBuyers() {
		return buyers;
	}

	public HashSet<Seller> getSellers() {
		return sellers;
	}

	public ArrayList<View> getViews() {
		return views;
	}

	public int getDealsMoney() {
		return dealsMoney;
	}

	public void setDealsMoney(int dealsMoney) {
		this.dealsMoney = dealsMoney;
	}

	
}
