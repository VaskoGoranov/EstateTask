package estates;

import java.util.Random;

import agency.Agent;

public class Apartment extends Estate implements IConstructionType{
	
	enum ApartmentType {STUDIO, GARSONIERA, DVUSTAEN, TRISTAEN, MEZONET}
	
	private ApartmentType apartmentType;
	private ConstructionType constructionType;
	
	public Apartment(int price, double area) {
		super("Best price in town! Mint condition!", "Sofia", price, EstateType.APARTMENT, area);
		this.apartmentType = ApartmentType.values()[new Random().nextInt(ApartmentType.values().length)];
		this.constructionType = ConstructionType.values()[new Random().nextInt(ConstructionType.values().length)];
	}

	@Override
	public void printInfo() {
		System.out.println(".........");
		System.out.println(this.apartmentType + ", " + this.constructionType + ", price: " + this.getPrice() + ", seller: " + this.getSeller().toString() + ", agent: " + this.getAgent());		
	}
	
	

}
