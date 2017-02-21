package agency;
import estates.Estate;
import estates.Estate.EstateType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeSet;

import estates.Estate;

public class Agency {
	
	private static final int AGENCY_BUDGET = 100_000;
	private String name;
	private String address;
	private String phone;
	private int budget;
	private ArrayList<Agent> agents;
	private HashMap<Enum, TreeSet<Estate>> catalog;
	
	public Agency(String name, String address, String phone) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.agents = new ArrayList<>();
		this.catalog = new HashMap<>();
		catalog.put(EstateType.APARTMENT, new TreeSet<>(new CompareByPrice()));
		catalog.put(EstateType.HOUSE, new TreeSet<>(new CompareByPrice()));
		catalog.put(EstateType.PLOT, new TreeSet<>(new CompareByPrice()));
		this.budget = AGENCY_BUDGET;
	}
	
	public void printInfo () {
		System.out.println("=====" +this.name+ "=====");
		System.out.println("Address: " + this.address);
		System.out.println("Phone: " + this.phone);
		System.out.println("Agents List: ");
		for (Agent a : agents) {
			System.out.println(a.toString());
		}
		System.out.println("----------------");
		System.out.println("===== Catalog Of Estates =====");
		for (Entry<Enum, TreeSet<Estate>> e : catalog.entrySet()) {
			System.out.println("  " + e.getKey());
			for (Estate est : e.getValue()) {
				est.printInfo();
			}
		}
	}

	public HashMap<Enum, TreeSet<Estate>> getCatalog() {
		return catalog;
	}

	public ArrayList<Agent> getAgents() {
		return agents;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}
	
	

}
