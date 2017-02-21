package estates;

import java.util.Random;

import agency.Agent;

public class Plot extends Estate {
	enum PlotType {NIVA, POLQNA, GORA}
	private boolean inRegulation;
	private PlotType plotType;

	public Plot(int price, double area) {
		super("Good soil! Easy access!", "Pancharevo", price, EstateType.PLOT, area);
		this.inRegulation = new Random().nextBoolean();
		this.plotType = PlotType.values()[new Random().nextInt(PlotType.values().length)];
	}
	
	@Override
	public void printInfo() {
		System.out.println(".........");
		System.out.println(this.plotType + ", price: " + this.getPrice() + ", seller: " + this.getSeller().toString() + ", agent: " + this.getAgent());		
	}
	

}
