package cc.ccs.chap71;
abstract class CashCard{
	 String name;
	 int balance;
	 int bonus;
	public CashCard(){
	}
	public CashCard(String name, int balance, int bonus){
		this.name = name;
		this.balance = balance;
		this.bonus = bonus;
	}
	
	void store(int money){
		if(money > 0){
			balance += money;
			if(balance > 1000) {
				bonus += 1;
			}
		}else{
			print(" error");
		}
	}
	void charge(int money){
		if(money > 0 && balance >= money){
			balance -= money;
		}else{
			print("money short");
		}
	}
	public abstract void print(String text);
}