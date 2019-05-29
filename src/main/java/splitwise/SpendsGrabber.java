package splitwise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpendsGrabber implements Expenditure{
	//private Set<Spender> tourists;
	
	private Map<String,Spender> tourists;
	public SpendsGrabber() {
		//tourists=new HashSet<Spender>();
		tourists=new HashMap<String,Spender>();
	}

	//@Override
	public void registerExpense(Spender spend) {
		TourSpender s=((TourSpender)spend);
		if(!tourists.containsKey(s.getName())) {
			tourists.put(s.getName(),spend);
		}
		
		
		
	}

	//@Override
	public void updateTransactions(String spender, List<Spender> spendee,int money) {
		// TODO Auto-generated method stub
		
		int total=money/spendee.size();
		tourists.get(spender).updateTransactions(-money);
		for( Spender spen:spendee) {
			{	TourSpender s=((TourSpender)spen);
				
				tourists.get(s.getName()).updateTransactions(Math.abs(total));
				
			}
			
		}
		notifySpends();
	}

	private void notifySpends() {
		for(Map.Entry<String, Spender>s:tourists.entrySet()) {
			s.getValue().printTransactions();
		}
		
	}

}
