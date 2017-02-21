package estates;

import java.util.Random;

import agency.Agent;

public class House extends Estate implements IConstructionType{
	
	enum HouseType {ETAJ, HOUSE}
	
	private HouseType houseType;
	private ConstructionType constructionType;
	
	public House(int price, double area) {
		super("Best offer on the market! Comfy and new!", "Bankq", price, EstateType.HOUSE, area);
		this.houseType = HouseType.values()[new Random().nextInt(HouseType.values().length)];
		this.constructionType = ConstructionType.values()[new Random().nextInt(ConstructionType.values().length)];;
	}
	
	@Override
	public void printInfo() {
		System.out.println(".........");
		System.out.println(this.houseType + ", " + this.constructionType + ", price: " + this.getPrice() + ", seller: " + this.getSeller().toString() + ", agent: " + this.getAgent());		
	}

}
