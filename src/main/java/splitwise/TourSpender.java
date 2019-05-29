package splitwise;


public class TourSpender implements Spender {
	private int money;
	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	private String name;
	Expenditure grabs;
	
	public TourSpender(SpendsGrabber grabs) {
		this.grabs=grabs;
	}
	
	public TourSpender(SpendsGrabber grabs,String name,int money) {
		this.name=name;
		this.money=money;
		grabs.registerExpense(this);
	}

	
	public void updateTransactions(int money) {
		this.money+=money;
		
	}


//	@Override
	public void printTransactions() {
		if(this.money<0) {
			System.out.println(this.name+" recieves "+Math.abs(this.money)+"\n");
		}else {
			System.out.println(this.name+" gives "+this.money+"\n");
		}
		
	}

}