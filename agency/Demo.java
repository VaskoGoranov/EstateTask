package agency;

import java.util.ArrayList;
import java.util.Random;

import estates.Apartment;
import estates.Estate;
import estates.Estate.EstateType;
import estates.House;
import estates.Plot;

public class Demo {
	
	public static void main(String[] args) {
		
		Random r = new Random();
		
		//name generator
		String[] first = {"Ivan", "Daniel", "Kosta", "Asen", "Mihail"}; 
		String[] last = {"Ivanov", "Dimitrov", "Goranov", "Vasilev", "Borisov"}; 
		
		//creating agency
		Agency agency = new Agency("Talanti Estates", "Sofia", "0888555666");
		
		//creating 5 agents
		ArrayList<Agent> fiveAgents = new ArrayList<>(5);
		for (int i = 0; i < 5; i++) {
			String name = first[new Random().nextInt(first.length)] + " " +last[new Random().nextInt(last.length)];
			fiveAgents.add(new Agent(name, "0888111222"));
		}
		
		//adding them to agency
		agency.getAgents().addAll(fiveAgents);
		
		//create 30 Estates
		
		ArrayList<Estate> estates = new ArrayList<>(30);
		
		for (int i = 0; i < 30; i++) {
			int type = r.nextInt(3);
			if (type == 0) {
				estates.add(new Apartment(r.nextInt(80_000) + 70_000, r.nextDouble()*100 + 40));
			}
			if (type == 1) {
				estates.add(new House(r.nextInt(30_000) + 50_000,  r.nextDouble()*100 + 50));
			}
			if (type == 2) {
				estates.add(new Plot(r.nextInt(55_000) + 30_000, r.nextDouble()*100 + 80));
			}
		}
		
		//create 30 seller and add an estate for each
		
		ArrayList<Seller> sellers = new ArrayList<>();
		
		for (int i = 0; i <30; i++) {
			String name = first[new Random().nextInt(first.length)] + " " +last[new Random().nextInt(last.length)];
			sellers.add(new Seller(name, "0888001122", estates.get(i), agency));
		}
		
		//register sellers in agency
		
		for (int i = 0; i<sellers.size(); i++) {
			sellers.get(i).registerEstate();
		}
		
		//create buyers
		
		ArrayList<Buyer> buyers = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			String name = first[new Random().nextInt(first.length)] + " " +last[new Random().nextInt(last.length)];
			
			buyers.add(new Buyer(name, "0987123456", r.nextInt(120_000) + 30_000, agency));
		}
		
		//register in agency
		
		for (int i = 0; i < buyers.size(); i++) {
			buyers.get(i).registerInAgency(agency);
		}
		
		//asking for views
		ArrayList<Estate> temp = new ArrayList<>();
		temp.addAll(agency.getCatalog().get(EstateType.APARTMENT));
		temp.addAll(agency.getCatalog().get(EstateType.HOUSE));
		temp.addAll(agency.getCatalog().get(EstateType.PLOT));
		
		
		for (int i = 0; i < buyers.size(); i++) {
			for (int j = 0; j < 3; j++) {
				EstateType type = EstateType.values()[r.nextInt(EstateType.values().length)];
				buyers.get(i).askForView(temp.get(r.nextInt(temp.size())));				
			}
		}
				
		//buying estates
		
		for (int i = 0; i < buyers.size(); i++) {
			buyers.get(i).buyEstate();
		}
		
		
	}

}
