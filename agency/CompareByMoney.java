package agency;

import java.util.Comparator;

public class CompareByMoney implements Comparator<Agent>{

	@Override
	public int compare(Agent o1, Agent o2) {
		
		return o2.getDealsMoney() - o1.getDealsMoney();
	}
	
	

}
