package splitwise;

import java.util.ArrayList;
import java.util.List;

public class TransactionParser {
	SpendsGrabber grab;
	public TransactionParser() {
		grab=new SpendsGrabber();
	}

	public static void main(String args[]) {
		
		TransactionParser parser=new TransactionParser();
		parser.parse("A spends 100 for A,B,C,D,E");
		parser.parse("B spends 500 for C,D,F");
		
	}

	private void parse(String transString) {
		String spender=transString.substring(0,1);
		int amount=Integer.parseInt(transString.substring(transString.indexOf("spends")+7,transString.lastIndexOf("for")-1));
		String spendees[]=transString.substring(transString.lastIndexOf(" ")+1,transString.length()).split(",");
		List<Spender> spendee=new ArrayList<Spender>();
		for(String s:spendees) {
			TourSpender spend=new TourSpender(grab,s,0);
			spendee.add(spend);
		}
		grab.updateTransactions(spender,spendee,amount);
		
	}
}