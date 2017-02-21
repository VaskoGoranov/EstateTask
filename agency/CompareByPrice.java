package agency;

import java.util.Comparator;

import estates.Estate;

public class CompareByPrice implements Comparator<Estate>{

	@Override
	public int compare(Estate o1, Estate o2) {
		
		return o2.getPrice() - o1.getPrice();
	}

}
